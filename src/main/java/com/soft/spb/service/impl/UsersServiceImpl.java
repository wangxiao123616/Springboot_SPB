package com.soft.spb.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.soft.spb.core.constant.ResultCode;
import com.soft.spb.core.exception.ServiceException;
import com.soft.spb.mapper.UserMapper;
import com.soft.spb.mapper.UserSignMapper;
import com.soft.spb.mapper.UsersMapper;
import com.soft.spb.pojo.dto.SUserDetails;
import com.soft.spb.pojo.dto.UpdatePwdDto;
import com.soft.spb.pojo.dto.UserDto;
import com.soft.spb.pojo.entity.User;
import com.soft.spb.pojo.entity.Users;
import com.soft.spb.service.StudentsService;
import com.soft.spb.service.UserService;
import com.soft.spb.service.UsersService;
import com.soft.spb.util.AesUtil;
import com.soft.spb.util.FileUpload;
import com.soft.spb.util.MD5Util;
import com.soft.spb.util.RedisUtil;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author wyw
 * @since 2022-03-19
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements UsersService {

    private final UserService userService;
    private final StudentsService studentsService;
    private final UsersMapper usersMapper;
    private final UserMapper userMapper;
    private final UserSignMapper userSignMapper;

    private final AuthenticationManager authenticationManager;

    private final RedisUtil redisUtil;

    private final String secret = "${token.secret}";

    private final PasswordEncoder pas;

    private static final String[] PATH = {"/HeadImage/", "/BackgroundImage/", "/PostBarImage/"
            , "/APostBarImage/", "/Voice/", "/Video/", "/Diary/", "/Other/"};

    @Override
    public Map<String, Object> login(UserDto userDto) throws ServiceException {
        Authentication authenticate;
        try {
            String s = AesUtil.aesDecrypt(userDto.getPassword());
            UsernamePasswordAuthenticationToken utor = new UsernamePasswordAuthenticationToken(userDto.getUserAccount(),
                    s);
            authenticate = authenticationManager.authenticate(utor);
        } catch (Exception e) {
            throw new ServiceException(ResultCode.USER_PASSWORD_ERROR);
        }
        SUserDetails s = (SUserDetails) authenticate.getPrincipal();

        Map<String, Object> claims = new HashMap<>();
        claims.put("login_user_key", s.getUsername());
        String token = Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS256, secret).compact();
        redisUtil.setEasyObject("login:web:" + userDto.getUserAccount(), s);

        return userService.getUserInfoToken(userDto.getUserAccount(), token);
    }

    @Override
    public boolean logout(UserDto userDto) throws ServiceException {
        return redisUtil.deleteObject("login:web:" + userDto.getUserAccount());
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Map<String, Object> register(UserDto userDto) throws ServiceException {
        try{
            // 1. 先检查用户是否已经存在
            if (getOne(
                    Wrappers.<Users>lambdaQuery().eq(Users::getUserAccount, userDto.getUserAccount())
            ) != null) {
                throw new ServiceException(ResultCode.USER_IS_EXIST);
            }
            // 2. 再检测用户是否有权进行注册
            if (!studentsService.canRegister(userDto.getUserAccount())) {
                throw new ServiceException(ResultCode.USER_ACCOUNT_NOT_PERMISSION_TO_REGISTER);
            }
            Users users = Users.builder()
                    .userAccount(userDto.getUserAccount())
                    .userPassword(pas.encode(userDto.getPassword()))
                    .userSecretProtection("111111111")
                    .build();
            int usersInsert = usersMapper.insert(users);
            int userInsert = userMapper.insert(User.builder()
                    .userAccount(userDto.getUserAccount())
                    .userName(userDto.getUserName())
                    .userHeadImage("http://tva1.sinaimg.cn/large/008cx1U7gy1h0nd9uybdcj305k05k0sr.jpg")
                    .userLongday(0)
                    .build());
            int i = userSignMapper.initSign(userDto.getUserAccount());

            if (usersInsert != 1 && userInsert != 1 && i != 1) {
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                throw new ServiceException(ResultCode.SYSTEM_ERROR);
            }
            if (!createFolder(userDto.getUserAccount())){
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                throw new ServiceException(ResultCode.SYSTEM_ERROR);
            }
            return userService.getUserInfo(userDto.getUserAccount());
        }catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            throw  new ServiceException(ResultCode.SYSTEM_ERROR);
        }
    }

    @Override
    public Boolean updatePwd(UpdatePwdDto updatePwd) throws ServiceException {
        Users users = getOne(
                Wrappers.<Users>lambdaQuery().eq(Users::getUserAccount, updatePwd.getUserAccount()));
        // 1. 先判断用户是否存在
        if (users == null) {
            throw new ServiceException(ResultCode.USER_NOT_FOUND);
        }
        // 2. 再判断密码是否正确
        if (pas.matches(updatePwd.getUserOldPwd(),users.getUserPassword())) {
            int update = usersMapper.update(null, Wrappers.<Users>lambdaUpdate().eq(Users::getUserAccount, updatePwd.getUserAccount())
                    .set(Users::getUserPassword, pas.encode(updatePwd.getUserPwd())));
            if (update == 1) {
                redisUtil.deleteObject("login:web:" + updatePwd.getUserAccount());
                return true;
            } else {
                throw new ServiceException(ResultCode.USER_XIU_USER_CODE);
            }
        } else {
            throw new ServiceException(ResultCode.USER_PASSWORD_ERROR);
        }
    }

    private boolean createFolder(String account) {
        boolean key = true;
        for (String s : PATH) {
            File path = new File(FileUpload.PREFIX + account + s);
            if (!path.exists()) {
                key = path.mkdirs();
            }
            if (!key) {
                return false;
            }
        }
        return true;
    }

}

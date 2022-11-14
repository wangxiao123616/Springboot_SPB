package com.soft.spb.service.impl;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.soft.spb.mapper.UserMapper;
import com.soft.spb.pojo.dto.SUserDetails;
import com.soft.spb.pojo.entity.*;
import com.soft.spb.pojo.vo.UserVo;
import com.soft.spb.service.*;
import com.soft.spb.util.AliOssUtil;
import com.soft.spb.util.SqlProcess;
import lombok.RequiredArgsConstructor;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author wyw
 * @since 2022-03-19
 */

@DubboService
@Component
@RequiredArgsConstructor(onConstructor = @_(@Autowired))
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    private final UserMapper userMapper;

    private final StudentsService studentsService;
    private final FollowService followService;
    private final AttentiontopicService attentiontopicService;
    private final CollectbarService collectbarService;
    private final PostbarlistService postbarlistService;
    private final UserSignService userSignService;

    private final LikepbService likepbService;

    @Override
    public List<UserVo> querySearchUser(String search) {
        return userMapper.querySearchUser(search);
    }

    @Override
    public Map<String, Object> getUserInfoToken(String userAccount,String token) {
        Map<String, Object> userInfo = getUserInfo(userAccount);
        userInfo.put("token",token);
        return userInfo;
    }

    @Override
    public Map<String, Object> getUserInfo(String userAccount) {
        Map<String, Object> map = new HashMap<>();
        // 1. 先获取用户的基本信息
        User user = getOne(
                Wrappers.<User>lambdaQuery().eq(User::getUserAccount, userAccount)
        );
        Students studentsInfo = studentsService.getStudentsInfo(userAccount);

        UserVo userVo = new UserVo();
        BeanUtils.copyProperties(user, userVo);
        BeanUtils.copyProperties(studentsInfo, userVo);
        map.put("userInfo", userVo);

        // 2. 再获取用户关注列表信息
        map.put("followPresenter", followService.queryFollowList(Follow.builder().followAccount(userAccount).build()));

        // 3. 添加被关注列表信息
        map.put("followedPresenter", followService.queryFollowedList(Follow.builder().followedAccount(userAccount).build()));

        // 3. 添加用户所关注的话题列表
        map.put("attentionTopicPresenter", attentiontopicService.getAttentionTopPresenter(userAccount));

        // 4. 添加用户收藏的帖子信息
        map.put("collectBar", collectbarService.getCollectBarPresenter(userAccount));

        map.put("barCount", postbarlistService.queryUserBarCount(userAccount));

        UserSign userSign = userSignService.queryUserBadge(userAccount);
        int badgeC = 0;
        if (StringUtils.isNotEmpty(userSign.getSignLikeBadge())) {
            String[] split = userSign.getSignLikeBadge().split("\\|");
            badgeC += split.length;
        }
        if (StringUtils.isNotEmpty(userSign.getSignStarBadge())) {
            badgeC += 1;
        }
        if (StringUtils.isNotEmpty(userSign.getSignTaskBadge())) {
            String[] split = userSign.getSignTaskBadge().split("\\|");
            badgeC += split.length;
        }
        if (userSign.getSignCtBadge() != 1) {
            badgeC += 1;
        }
        map.put("badgeCount", badgeC);

        // 5. 添加用户所点赞的帖子
        Likepb likepb = new Likepb();
        likepb.setUserAccount(userAccount);
        map.put("likeBar", likepbService.queryLike(likepb));
        return map;
    }

    @Override
    public Map<String, Object> getUserInfo() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        SUserDetails s = (SUserDetails) authentication.getPrincipal();
        return this.getUserInfo(s.getUsername());
    }

    @Override
    public Boolean updateUserPersonalInformation(User user) {
        return SqlProcess.transactionalProcess(userMapper.updateUserPersonalInformation(user));
    }
}

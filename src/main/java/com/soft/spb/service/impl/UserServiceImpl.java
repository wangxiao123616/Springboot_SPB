package com.soft.spb.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.soft.spb.mapper.UserMapper;
import com.soft.spb.mapper.UsersMapper;
import com.soft.spb.pojo.entity.*;
import com.soft.spb.pojo.vo.UserVo;
import com.soft.spb.service.*;
import com.soft.spb.util.AliOssUtil;
import com.soft.spb.util.SqlProcess;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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

@Service
@RequiredArgsConstructor(onConstructor = @_(@Autowired))
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    private final UserMapper userMapper;

    private final StudentsService studentsService;
    private final FollowService followService;
    private final AttentiontopicService attentiontopicService;
    private final CollectbarService collectbarService;

    private final LikepbService likepbService;

    @Override
    public int deleteUserIp(String userAccount) {

        return userMapper.deleteUserIp(userAccount);
    }

    @Override
    public List<Course> querySchoolTable() {

        return userMapper.querySchoolTable();
    }

    @Override
    public List<User> querySearchUser(String search) {

        return userMapper.querySearchUser(search);
    }

    @Override
    public int updateUserBadgeImage(String userBadge, String userAccount) {
        int count = userMapper.updateUserBadgeImage(userBadge, userAccount);
        return count;
    }

    @Override
    public Integer updateUserBgImage(MultipartFile[] userBgImage, String userAccount) {
        List<String> stringList = AliOssUtil.upload(userBgImage);
        String bgImage = stringList.get(0);
        String substring = bgImage.substring(51);
        User user = new User();
        user.setUserBgImage(substring);
        int count = userMapper.updateUserBgImage(substring, userAccount);
        return count;
    }

    @Override
    public Integer updateUserHeadImage(MultipartFile[] userHeadImage, String userAccount) {
        List<String> headList = AliOssUtil.upload(userHeadImage);
        String headString = headList.get(0);
        String substring = headString.substring(51);
        User user = new User();
        user.setUserHeadImage(substring);
        int count = userMapper.updateUserHeadImage(substring, userAccount);
        return count;
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

        // 5. 添加用户所点赞的帖子
        Likepb likepb = new Likepb();
        likepb.setUserAccount(userAccount);
        map.put("likeBar", likepbService.queryLike(likepb));
        return map;
    }

    @Override
    public int updateUserIp(User user) {
        int count = userMapper.updateUserIp(user.getUserIp(), user.getUserAccount());
        return count;
    }

    @Override
    public Boolean updateUserPersonalInformation(User user) {
        return SqlProcess.transactionalProcess(userMapper.updateUserPersonalInformation(user));
    }

    @Override
    public int updateUserPrivacy(User user) {
        int count = userMapper.updateUserPrivacy(user);
        return count;
    }

    @Override
    public int updateUserToken(User user) {
        int count = userMapper.updateUserToken(user);
        return count;
    }
}

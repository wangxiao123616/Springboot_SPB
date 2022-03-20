package com.soft.spb.mapper;

import com.soft.spb.pojo.entity.Follow;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author wyw
 * @since 2022-03-19
 */
public interface FollowMapper extends BaseMapper<Follow> {

    List<Follow> getFollow();

    int addFollow(Follow follow);

    int deleteFollow(@Param("followAccount") String followAccount, @Param("followedAccount") String followedAccount);
}

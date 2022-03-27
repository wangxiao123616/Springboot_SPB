package com.soft.spb.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.soft.spb.pojo.entity.Diary;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author wyw
 * @since 2022-03-19
 */
public interface DiaryMapper extends BaseMapper<Diary> {
    /**
     * 2.7.1. 添加日记
     *
     * @return
     * @Param diary
     */
    int addDiary(Diary diary);

    /**
     * 2.7.2. 删除日记
     *
     * @return
     * @Param diary
     */
    int deleteDiary(Diary diary);

    /**
     * 2.7.3. 获取日记列表
     *
     * @return
     * @Param diary
     */
    List<Diary> queryDiary(Diary diary);

}

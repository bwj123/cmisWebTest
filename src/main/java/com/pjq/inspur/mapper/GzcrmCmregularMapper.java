package com.pjq.inspur.mapper;

import com.pjq.inspur.pojo.GzcrmCmregular;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GzcrmCmregularMapper {
    int deleteByPrimaryKey(Integer cmKey);

    int insert(GzcrmCmregular record);

    int insertSelective(GzcrmCmregular record);

    GzcrmCmregular selectByPrimaryKey(Integer cmKey);

    int updateByPrimaryKeySelective(GzcrmCmregular record);

    int updateByPrimaryKey(GzcrmCmregular record);

    List<GzcrmCmregular> queryRegularList(@Param("mDate") String meetingDate, @Param("mTheme") String theme);
}
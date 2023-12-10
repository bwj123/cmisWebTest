package com.pjq.inspur.mapper;

import com.pjq.inspur.pojo.GzcrmCinfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GzcrmCinfoMapper {
    int deleteByPrimaryKey(Integer cKey);

    int insert(GzcrmCinfo record);

    int insertSelective(GzcrmCinfo record);

    GzcrmCinfo selectByPrimaryKey(Integer cKey);

    int updateByPrimaryKeySelective(GzcrmCinfo record);

    int updateByPrimaryKey(GzcrmCinfo record);

    List<GzcrmCinfo> queryCinfoList(@Param("p1") String cName, @Param("p2") String cSsn);
}
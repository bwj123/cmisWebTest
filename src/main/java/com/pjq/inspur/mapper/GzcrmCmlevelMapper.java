package com.pjq.inspur.mapper;

import com.pjq.inspur.pojo.GzcrmCmlevel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GzcrmCmlevelMapper {
    int deleteByPrimaryKey(Integer cmKey);

    int insert(GzcrmCmlevel record);

    int insertSelective(GzcrmCmlevel record);

    GzcrmCmlevel selectByPrimaryKey(Integer cmKey);

    int updateByPrimaryKeySelective(GzcrmCmlevel record);

    int updateByPrimaryKey(GzcrmCmlevel record);

    List<GzcrmCmlevel> queryList(@Param("p1") String cmId6, @Param("p2") String holdDate, @Param("p3") String holdLevel);
}
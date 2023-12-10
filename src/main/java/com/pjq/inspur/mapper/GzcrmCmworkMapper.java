package com.pjq.inspur.mapper;

import com.pjq.inspur.pojo.GzcrmCmwork;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GzcrmCmworkMapper {
    int deleteByPrimaryKey(Integer cmKey);

    int insert(GzcrmCmwork record);

    int insertSelective(GzcrmCmwork record);

    GzcrmCmwork selectByPrimaryKey(Integer cmKey);

    int updateByPrimaryKeySelective(GzcrmCmwork record);

    int updateByPrimaryKey(GzcrmCmwork record);

    List<GzcrmCmwork> queryList(@Param("p1") String cmId7, @Param("p2") String cmPosition);

}
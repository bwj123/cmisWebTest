package com.pjq.inspur.mapper;

import com.pjq.inspur.pojo.GzcrmCmrpr;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GzcrmCmrprMapper {
    int deleteByPrimaryKey(Integer cmKey);

    int insert(GzcrmCmrpr record);

    int insertSelective(GzcrmCmrpr record);

    GzcrmCmrpr selectByPrimaryKey(Integer cmKey);

    int updateByPrimaryKeySelective(GzcrmCmrpr record);

    int updateByPrimaryKey(GzcrmCmrpr record);

    List<GzcrmCmrpr> queryList(@Param("p1") String cmId3, @Param("p2") String cmType);
}
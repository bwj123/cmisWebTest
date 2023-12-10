package com.pjq.inspur.mapper;

import com.pjq.inspur.pojo.GzcrmCminfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GzcrmCminfoMapper {
    int deleteByPrimaryKey(Integer cmId);

    int insert(GzcrmCminfo record);

    int insertSelective(GzcrmCminfo record);

    GzcrmCminfo selectByPrimaryKey(Integer cmId);

    int updateByPrimaryKeySelective(GzcrmCminfo record);

    int updateByPrimaryKey(GzcrmCminfo record);

    List<GzcrmCminfo> queryCminfoList(@Param("cmUnit") String deptName, @Param("status") String status, @Param("cmName") String cmName);

    List<GzcrmCminfo> queryDetil(@Param("c1") String cmUnit, @Param("c2") String cmStatus, @Param("c3") String cmSex, @Param("c4") String cmEdu, @Param("c5") String cmPL, @Param("c6") String cmLevel);

    List<GzcrmCminfo> queryAll();

}
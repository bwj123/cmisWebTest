package com.pjq.inspur.mapper;

import com.pjq.inspur.pojo.GzcrmCmresults;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GzcrmCmresultsMapper {
    int deleteByPrimaryKey(Integer cmKey);

    int insert(GzcrmCmresults record);

    int insertSelective(GzcrmCmresults record);

    GzcrmCmresults selectByPrimaryKey(Integer cmKey);

    int updateByPrimaryKeySelective(GzcrmCmresults record);

    int updateByPrimaryKey(GzcrmCmresults record);

    List<GzcrmCmresults> queryList(@Param("p1") String cmId, @Param("p2") String workYear);

}
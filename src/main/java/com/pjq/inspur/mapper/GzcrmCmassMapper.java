package com.pjq.inspur.mapper;

import com.pjq.inspur.pojo.GzcrmCmass;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GzcrmCmassMapper {
    int deleteByPrimaryKey(Integer cmKey);

    int insert(GzcrmCmass record);

    int insertSelective(GzcrmCmass record);

    GzcrmCmass selectByPrimaryKey(Integer cmKey);

    int updateByPrimaryKeySelective(GzcrmCmass record);

    int updateByPrimaryKey(GzcrmCmass record);

    List<GzcrmCmass> queryList(@Param("p1") String cmId4, @Param("p2") String cmassDate);

}
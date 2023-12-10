package com.pjq.inspur.mapper;

import com.pjq.inspur.pojo.GzcrmCmltr;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GzcrmCmltrMapper {
    int deleteByPrimaryKey(Integer cmKey);

    int insert(GzcrmCmltr record);

    int insertSelective(GzcrmCmltr record);

    GzcrmCmltr selectByPrimaryKey(Integer cmKey);

    int updateByPrimaryKeySelective(GzcrmCmltr record);

    int updateByPrimaryKey(GzcrmCmltr record);

    List<GzcrmCmltr> queryList(@Param("p1") String cmId5, @Param("p2") String cmTime, @Param("p3") String cmSub);

}
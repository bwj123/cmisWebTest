package com.pjq.inspur.mapper;

import com.pjq.inspur.pojo.GzcrmCminfoWork;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GzcrmCminfoWorkMapper {
    int deleteByPrimaryKey(Integer cmKey);

    int insert(GzcrmCminfoWork record);

    int insertSelective(GzcrmCminfoWork record);

    GzcrmCminfoWork selectByPrimaryKey(Integer cmKey);

    int updateByPrimaryKeySelective(GzcrmCminfoWork record);

    int updateByPrimaryKey(GzcrmCminfoWork record);

    List<GzcrmCminfoWork> queryList(@Param("workKey") String workKey, @Param("inDate") String inDate);

}
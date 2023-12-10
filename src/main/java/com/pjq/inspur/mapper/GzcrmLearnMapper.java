package com.pjq.inspur.mapper;

import com.pjq.inspur.pojo.GzcrmLearn;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GzcrmLearnMapper {
    int deleteByPrimaryKey(Integer lKey);

    int insert(GzcrmLearn record);

    int insertSelective(GzcrmLearn record);

    GzcrmLearn selectByPrimaryKey(Integer lKey);

    int updateByPrimaryKeySelective(GzcrmLearn record);

    int updateByPrimaryKey(GzcrmLearn record);

    List<GzcrmLearn> queryLearnList(@Param("lName") String lname, @Param("lType") String ltype);
}
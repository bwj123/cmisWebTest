package com.pjq.inspur.mapper;

import com.pjq.inspur.pojo.YcMember;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface YcMemberMapper {
    int deleteByPrimaryKey(Integer memId);
    //逆向工程生成的业务接口
    int insert(YcMember record);

    int insertSelective(YcMember record);

    YcMember selectByPrimaryKey(Integer memId);

    int updateByPrimaryKeySelective(YcMember record);

    int updateByPrimaryKey(YcMember record);

    //用户登录
    List<YcMember> login(@Param("cname") String userName, @Param("memPass") String passWord);

    //用户查询
    List<YcMember> queryMemberList(@Param("cname") String memName);

    int updateStatusById(@Param("memId") int memid, @Param("status") String status);

    int resetPassById(@Param("memId") int memid);
}
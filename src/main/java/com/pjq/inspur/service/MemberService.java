package com.pjq.inspur.service;

import com.pjq.inspur.pojo.YcMember;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("memberService")
public interface MemberService {

    //登录
    List<YcMember> login(String userName, String passWord);

    List<YcMember> queryMemberList(String memId, String memName);
    //添加用户
    int insertMember(YcMember ycMember);

    int deleteMememberById(int memid);

    YcMember queryMemberById(int memid);

    int updateMember(YcMember ycMember);

    int updateStatusById(int memid, String status);

    int resetPassById(int memid);

    boolean deleteMany(String checkTnum);

    boolean add(YcMember member);

}
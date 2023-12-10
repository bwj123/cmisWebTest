package com.pjq.inspur.service.impl;

import com.pjq.inspur.mapper.YcMemberMapper;
import com.pjq.inspur.pojo.YcMember;
import com.pjq.inspur.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("memberService")
public class MemberServiceImpl implements MemberService {
    @Autowired
    private YcMemberMapper ycMemberMapper;

    @Override
    public List<YcMember> login(String userName, String passWord) {
        return ycMemberMapper.login(userName, passWord);
    }

    @Override
    public List<YcMember> queryMemberList(String memId, String memName) {
        List<YcMember> list = new ArrayList<>();
        if (memId != null && !memId.equals("")) {
            list.add(ycMemberMapper.selectByPrimaryKey(Integer.parseInt(memId)));
        } else {
            list = ycMemberMapper.queryMemberList("%" + memName + "%");
        }
        return list;
    }

    @Override
    public int insertMember(YcMember ycMember) {
        return ycMemberMapper.insert(ycMember);
    }

    @Override
    public int deleteMememberById(int memid) {
        return ycMemberMapper.deleteByPrimaryKey(memid);
    }

    @Override
    public YcMember queryMemberById(int memid) {
        return ycMemberMapper.selectByPrimaryKey(memid);
    }

    @Override
    public int updateMember(YcMember ycMember) {
        return ycMemberMapper.updateByPrimaryKeySelective(ycMember);
    }

    @Override
    public int updateStatusById(int memid, String status) {
        if (status.equals("T")) {
            status = "F";
        } else {
            status = "T";
        }
        return ycMemberMapper.updateStatusById(memid, status);
    }

    @Override
    public int resetPassById(int memid) {
        return ycMemberMapper.resetPassById(memid);
    }

    @Override
    public boolean deleteMany(String checkTnum) {
        if (checkTnum != null && !checkTnum.equals("")) {
            String[] ids = checkTnum.split(",");
            for (int i = 0; i < ids.length; i++) {
                ycMemberMapper.deleteByPrimaryKey(Integer.parseInt(ids[i]));
            }
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean add(YcMember member) {
        return false;
    }
}
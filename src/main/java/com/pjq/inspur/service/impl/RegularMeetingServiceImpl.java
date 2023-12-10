package com.pjq.inspur.service.impl;

import com.pjq.inspur.mapper.GzcrmCmregularMapper;
import com.pjq.inspur.pojo.GzcrmCmregular;
import com.pjq.inspur.service.RegularMeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("regularMeetingService")
public class RegularMeetingServiceImpl implements RegularMeetingService {
    @Autowired
    private GzcrmCmregularMapper gzcrmCmregularMapper;

    @Override
    public int deleteRegularById(int reId) {
        return gzcrmCmregularMapper.deleteByPrimaryKey(reId);
    }

    @Override
    public boolean deleteMany(String checkTnum) {
        if (checkTnum != null && !checkTnum.equals("")) {
            String[] ids = checkTnum.split(",");
            for (int i = 0; i < ids.length; i++) {
                gzcrmCmregularMapper.deleteByPrimaryKey(Integer.parseInt(ids[i]));
            }
            return true;
        } else {
            return false;
        }
    }

    @Override
    public GzcrmCmregular queryRegularById(int reId) {
        return gzcrmCmregularMapper.selectByPrimaryKey(reId);
    }

    @Override
    public int updateRegular(GzcrmCmregular cmregular) {
        return gzcrmCmregularMapper.updateByPrimaryKeySelective(cmregular);
    }

    @Override
    public int insertRegular(GzcrmCmregular cmregular) {
        return gzcrmCmregularMapper.insert(cmregular);
    }

    @Override
    public List<GzcrmCmregular> queryRegulaList(String meetingId, String meetingDate, String meetingTheme) {
        List<GzcrmCmregular> list = new ArrayList<>();
        if (meetingId != null && !meetingId.equals("")) {
            GzcrmCmregular tmp = gzcrmCmregularMapper.selectByPrimaryKey(Integer.parseInt(meetingId));
            if (tmp != null) {
                list.add(tmp);
            }
        } else {
            list = gzcrmCmregularMapper.queryRegularList(meetingDate, "%" + meetingTheme + "%");
        }
        return list;
    }
}
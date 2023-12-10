package com.pjq.inspur.service.impl;

import com.pjq.inspur.mapper.GzcrmCmresultsMapper;
import com.pjq.inspur.pojo.GzcrmCmresults;
import com.pjq.inspur.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("resultService")
public class ResultServiceImpl implements ResultService {
    @Autowired
    private GzcrmCmresultsMapper gzcrmCmresultsMapper;

    @Override
    public int deleteResultById(int resId) {
        return gzcrmCmresultsMapper.deleteByPrimaryKey(resId);
    }

    @Override
    public List<GzcrmCmresults> queryList(String cmId, String workYear) {
        List<GzcrmCmresults> list = new ArrayList<>();
        if (cmId != null && !cmId.equals("")) {
            return gzcrmCmresultsMapper.queryList(cmId, workYear);
        }
        return gzcrmCmresultsMapper.queryList(null, workYear);
    }

    @Override
    public GzcrmCmresults queryResultById(int resId) {
        return gzcrmCmresultsMapper.selectByPrimaryKey(resId);
    }

    @Override
    public int update(GzcrmCmresults cmresults) {
        return gzcrmCmresultsMapper.updateByPrimaryKeySelective(cmresults);
    }

    @Override
    public boolean deleteMany(String checkTnum) {
        if (checkTnum != null && !checkTnum.equals("")) {
            String[] ids = checkTnum.split(",");
            for (int i = 0; i < ids.length; i++) {
                gzcrmCmresultsMapper.deleteByPrimaryKey(Integer.parseInt(ids[i]));
            }
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int insert(GzcrmCmresults cmresults) {
        return gzcrmCmresultsMapper.insert(cmresults);
    }
}
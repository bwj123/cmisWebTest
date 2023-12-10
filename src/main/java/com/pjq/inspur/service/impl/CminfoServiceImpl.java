package com.pjq.inspur.service.impl;

import com.pjq.inspur.mapper.GzcrmCminfoMapper;
import com.pjq.inspur.pojo.GzcrmCminfo;
import com.pjq.inspur.service.CminfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("cminfoService")
public class CminfoServiceImpl implements CminfoService {
    @Autowired
    private GzcrmCminfoMapper cminfoMapper;

    @Override
    public int insertCminfo(GzcrmCminfo gzcrmCminfo) {
        return cminfoMapper.insert(gzcrmCminfo);
    }

    @Override
    public int deleteCminfoById(int cmId) {
        return cminfoMapper.deleteByPrimaryKey(cmId);
    }

    @Override
    public int updateCminfo(GzcrmCminfo gzcrmCminfo) {
        return cminfoMapper.updateByPrimaryKeySelective(gzcrmCminfo);
    }

    @Override
    public GzcrmCminfo queryCminfoById(int cmId) {
        return cminfoMapper.selectByPrimaryKey(cmId);
    }

    @Override
    public boolean deleteMany(String checkTnum) {
        if (checkTnum != null && !checkTnum.equals("")) {
            String[] ids = checkTnum.split(",");
            for (int i = 0; i < ids.length; i++) {
                cminfoMapper.deleteByPrimaryKey(Integer.parseInt(ids[i]));
            }
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<GzcrmCminfo> queryCminfoList(String deptName, String cminfoId, String cmName, String status) {
        List<GzcrmCminfo> list = new ArrayList<>();
        if (cminfoId != null && !cminfoId.equals("")) {
            list.add(cminfoMapper.selectByPrimaryKey(Integer.parseInt(cminfoId)));
        } else {
            list = cminfoMapper.queryCminfoList("%" + deptName + "%", status, "%" + cmName + "%");
        }
        return list;
    }

    @Override
    public List<GzcrmCminfo> queryDetil(String cmUnit, String cmStatus, String cmSex, String cmEdu, String cmPL, String cmLevel) {
        List<GzcrmCminfo> list = cminfoMapper.queryDetil("%" + cmUnit + "%", cmStatus, cmSex, cmEdu, cmPL, cmLevel);
        return list;
    }

    @Override
    public List<GzcrmCminfo> queryAll() {
        return cminfoMapper.queryAll();
    }
}
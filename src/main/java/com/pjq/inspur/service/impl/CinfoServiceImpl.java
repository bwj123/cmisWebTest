package com.pjq.inspur.service.impl;

import com.pjq.inspur.mapper.GzcrmCinfoMapper;
import com.pjq.inspur.pojo.GzcrmCinfo;
import com.pjq.inspur.service.CinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lijiahui
 * @date 2020/7/11 -10:31
 */
@Service("cinfoService")
public class CinfoServiceImpl implements CinfoService {
    @Autowired
    private GzcrmCinfoMapper cinfoMapper;

    @Override
    public int deleteLearnById(int cId) {
        return cinfoMapper.deleteByPrimaryKey(cId);
    }

    @Override
    public boolean deleteMany(String checkTnum) {
        if (checkTnum != null && !checkTnum.equals("")) {
            String[] ids = checkTnum.split(",");
            for (int i = 0; i < ids.length; i++) {
                cinfoMapper.deleteByPrimaryKey(Integer.parseInt(ids[i]));
            }
            return true;
        } else {
            return false;
        }
    }

    @Override
    public GzcrmCinfo queryCinfoById(int cId) {
        return cinfoMapper.selectByPrimaryKey(cId);
    }

    @Override
    public int updateCinfo(GzcrmCinfo cinfo) {
        return cinfoMapper.updateByPrimaryKeySelective(cinfo);
    }

    @Override
    public int insertCinfo(GzcrmCinfo cinfo) {
        return cinfoMapper.insert(cinfo);
    }

    @Override
    public List<GzcrmCinfo> queryCinfoList(String cId, String cName, String cSsn) {
        List<GzcrmCinfo> list = new ArrayList<>();
        if (cId != null && !cId.equals("")) {
            GzcrmCinfo tmp = cinfoMapper.selectByPrimaryKey(Integer.parseInt(cId));
            if (tmp != null) {
                list.add(tmp);
            }
        } else {
            list = cinfoMapper.queryCinfoList("%" + cName + "%", "%" + cSsn + "%");
        }
        return list;
    }
}
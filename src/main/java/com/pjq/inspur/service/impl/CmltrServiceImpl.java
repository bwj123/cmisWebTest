package com.pjq.inspur.service.impl;

import com.pjq.inspur.mapper.GzcrmCmltrMapper;
import com.pjq.inspur.pojo.GzcrmCmltr;
import com.pjq.inspur.service.CmltrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lijiahui
 * @date 2020/7/12 -14:58
 */
@Service("cmltrService")
public class CmltrServiceImpl implements CmltrService {
    @Autowired
    private GzcrmCmltrMapper cmltrMapper;

    @Override
    public List<GzcrmCmltr> queryList(String cmId5, String cmTime, String cmSub) {
        return cmltrMapper.queryList(cmId5, cmTime, "%" + cmSub + "%");
    }

    @Override
    public int deleteCmltrById(int cmltrId) {
        return cmltrMapper.deleteByPrimaryKey(cmltrId);
    }

    @Override
    public boolean deleteMany(String checkTnum) {
        if (checkTnum != null && !checkTnum.equals("")) {
            String[] ids = checkTnum.split(",");
            for (int i = 0; i < ids.length; i++) {
                cmltrMapper.deleteByPrimaryKey(Integer.parseInt(ids[i]));
            }
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int insertCmrpr(GzcrmCmltr cmltr) {
        return cmltrMapper.insert(cmltr);
    }

    @Override
    public GzcrmCmltr queryCmltrById(int cmltrId) {
        return cmltrMapper.selectByPrimaryKey(cmltrId);
    }

    @Override
    public int update(GzcrmCmltr cmltr) {
        return cmltrMapper.updateByPrimaryKeySelective(cmltr);
    }
}
package com.pjq.inspur.service.impl;

import com.pjq.inspur.mapper.GzcrmCmassMapper;
import com.pjq.inspur.pojo.GzcrmCmass;
import com.pjq.inspur.service.CmassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lijiahui
 * @date 2020/7/11 -14:07
 */
@Service("cmassService")
public class CmassServcieImpl implements CmassService {
    @Autowired
    private GzcrmCmassMapper cmassMapper;

    @Override
    public List<GzcrmCmass> queryList(String cmId4, String cmassDate) {
        return cmassMapper.queryList(cmId4, cmassDate);
    }

    @Override
    public int deleteCmassById(int cmassId) {
        return cmassMapper.deleteByPrimaryKey(cmassId);
    }

    @Override
    public boolean deleteMany(String checkTnum) {
        if (checkTnum != null && !checkTnum.equals("")) {
            String[] ids = checkTnum.split(",");
            for (int i = 0; i < ids.length; i++) {
                cmassMapper.deleteByPrimaryKey(Integer.parseInt(ids[i]));
            }
            return true;
        } else {
            return false;
        }
    }

    @Override
    public GzcrmCmass queryCerById(int cmassId) {
        return cmassMapper.selectByPrimaryKey(cmassId);
    }

    @Override
    public int update(GzcrmCmass cmass) {
        return cmassMapper.updateByPrimaryKeySelective(cmass);
    }

    @Override
    public int insert(GzcrmCmass cmass) {
        return cmassMapper.insert(cmass);
    }
}
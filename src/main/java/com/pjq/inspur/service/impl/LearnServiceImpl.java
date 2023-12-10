package com.pjq.inspur.service.impl;

import com.pjq.inspur.mapper.GzcrmLearnMapper;
import com.pjq.inspur.pojo.GzcrmLearn;
import com.pjq.inspur.service.LearnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lijiahui
 * @date 2020/7/12 -16:38
 */
@Service("learnService")
public class LearnServiceImpl implements LearnService {
    @Autowired
    private GzcrmLearnMapper gzcrmLearnMapper;

    @Override
    public int deleteLearnById(int learnId) {
        return gzcrmLearnMapper.deleteByPrimaryKey(learnId);
    }

    @Override
    public GzcrmLearn queryLearnById(int learnId) {
        return gzcrmLearnMapper.selectByPrimaryKey(learnId);
    }

    @Override
    public int insertLearn(GzcrmLearn gzcrmLearn) {
        return gzcrmLearnMapper.insert(gzcrmLearn);
    }

    @Override
    public boolean deleteMany(String checkTnum) {
        if (checkTnum != null && !checkTnum.equals("")) {
            String[] ids = checkTnum.split(",");
            for (int i = 0; i < ids.length; i++) {
                gzcrmLearnMapper.deleteByPrimaryKey(Integer.parseInt(ids[i]));
            }
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<GzcrmLearn> queryLearnList(String lname, String ltype) {
        return gzcrmLearnMapper.queryLearnList("%" + lname + "%", ltype);
    }

    @Override
    public int updateLearn(GzcrmLearn gzcrmLearn) {
        return gzcrmLearnMapper.updateByPrimaryKeySelective(gzcrmLearn);
    }
}
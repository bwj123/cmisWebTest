package com.pjq.inspur.service;

import com.pjq.inspur.pojo.GzcrmLearn;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("learnService")
public interface LearnService {

    int deleteLearnById(int learnId);

    GzcrmLearn queryLearnById(int learnId);

    int insertLearn(GzcrmLearn gzcrmLearn);

    boolean deleteMany(String checkTnum);

    List<GzcrmLearn> queryLearnList(String lname, String ltype);

    int updateLearn(GzcrmLearn gzcrmLearn);

}
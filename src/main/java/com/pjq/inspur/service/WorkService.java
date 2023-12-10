package com.pjq.inspur.service;

import com.pjq.inspur.pojo.GzcrmCminfoWork;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("workService")
public interface WorkService {

    int deleteWorkById(int workId);

    boolean deleteMany(String checkTnum);

    int insertWork(GzcrmCminfoWork gzcrmCminfoWork);

    int updateWork(GzcrmCminfoWork gzcrmCminfoWork);

    List<GzcrmCminfoWork> queryList(String workKey, String inDate);

    GzcrmCminfoWork queryWorkRecordById(int workId);

}
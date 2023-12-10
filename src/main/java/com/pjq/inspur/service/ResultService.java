package com.pjq.inspur.service;

import com.pjq.inspur.pojo.GzcrmCmresults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("resultService")
public interface ResultService {

    int deleteResultById(int resId);

    List<GzcrmCmresults> queryList(String cmId, String workYear);

    GzcrmCmresults queryResultById(int resId);

    int update(GzcrmCmresults cmresults);

    boolean deleteMany(String checkTnum);

    int insert(GzcrmCmresults cmresults);

}
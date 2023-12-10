package com.pjq.inspur.service;

import com.pjq.inspur.pojo.GzcrmCmrpr;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("cmrprService")
public interface CmrprService {

    List<GzcrmCmrpr> queryList(String cmId3, String cmType);

    int deleteCmrprById(int cmrprId);

    boolean deleteMany(String checkTnum);

    int insertCmrpr(GzcrmCmrpr cmrpr);

    GzcrmCmrpr queryCerById(int cmrprId);

    int update(GzcrmCmrpr cmrpr);

}
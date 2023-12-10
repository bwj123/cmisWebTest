package com.pjq.inspur.service;

import com.pjq.inspur.pojo.GzcrmCmltr;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("cmltrServcie")
public interface CmltrService {

    List<GzcrmCmltr> queryList(String cmId5, String cmTime, String cmSub);

    int deleteCmltrById(int cmltrId);

    boolean deleteMany(String checkTnum);

    int insertCmrpr(GzcrmCmltr cmltr);

    GzcrmCmltr queryCmltrById(int cmltrId);

    int update(GzcrmCmltr cmltr);

}
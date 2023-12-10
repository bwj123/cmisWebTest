package com.pjq.inspur.service;

import com.pjq.inspur.pojo.GzcrmCmwork;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("cmWorkService")
public interface CmWorkService {

    List<GzcrmCmwork> queryList(String cmId7, String cmPosition);

    int deleteCmWorkById(int cmworkId);

    boolean deleteMany(String checkTnum);

    GzcrmCmwork queryCmWorkById(int cmworkId);

    int update(GzcrmCmwork cmwork);

    int insert(GzcrmCmwork cmwork);

}
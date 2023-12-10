package com.pjq.inspur.service;


import com.pjq.inspur.pojo.GzcrmCmlevel;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("cmlevelService")
public interface CmlevelService {

    List<GzcrmCmlevel> queryList(String cmId6, String holdDate, String holdLevel);

    int deleteCmlevelById(int cmlevelId);

    boolean deleteMany(String checkTnum);

    GzcrmCmlevel queryCmlevelById(int cmlevelId);

    int update(GzcrmCmlevel cmlevel);

    int insert(GzcrmCmlevel cmlevel);

}
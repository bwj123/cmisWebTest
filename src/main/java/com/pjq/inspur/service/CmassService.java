package com.pjq.inspur.service;

import com.pjq.inspur.pojo.GzcrmCmass;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("cmassService")
public interface CmassService {

    List<GzcrmCmass> queryList(String cmId4, String cmassDate);

    int deleteCmassById(int cmassId);

    boolean deleteMany(String checkTnum);

    GzcrmCmass queryCerById(int cmassId);

    int update(GzcrmCmass cmass);

    int insert(GzcrmCmass cmass);

}
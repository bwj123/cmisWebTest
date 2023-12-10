package com.pjq.inspur.service;

import com.pjq.inspur.pojo.GzcrmCminfo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("cminfoService")
public interface CminfoService {

    int insertCminfo(GzcrmCminfo gzcrmCminfo);

    int deleteCminfoById(int cmId);

    int updateCminfo(GzcrmCminfo gzcrmCminfo);

    GzcrmCminfo queryCminfoById(int cmId);

    boolean deleteMany(String checkTnum);

    List<GzcrmCminfo> queryCminfoList(String deptName, String cminfoId, String cmName, String status);

    List<GzcrmCminfo> queryDetil(String cmUnit, String cmStatus, String cmSex, String cmEdu, String cmPL, String cmLevel);

    List<GzcrmCminfo> queryAll();
}

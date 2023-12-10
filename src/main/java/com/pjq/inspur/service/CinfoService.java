package com.pjq.inspur.service;

import com.pjq.inspur.pojo.GzcrmCinfo;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("cinfoService")
public interface CinfoService {

    int deleteLearnById(int cId);

    boolean deleteMany(String checkTnum);

    GzcrmCinfo queryCinfoById(int cId);

    int updateCinfo(GzcrmCinfo cinfo);

    int insertCinfo(GzcrmCinfo cinfo);

    List<GzcrmCinfo> queryCinfoList(String cId, String cName, String cSsn);

}
package com.pjq.inspur.service;

import com.pjq.inspur.pojo.GzcrmCmregular;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("regularMeetingService")
public interface RegularMeetingService {

    int deleteRegularById(int reId);

    boolean deleteMany(String checkTnum);

    GzcrmCmregular queryRegularById(int reId);

    int updateRegular(GzcrmCmregular cmregular);

    int insertRegular(GzcrmCmregular cmregular);

    List<GzcrmCmregular> queryRegulaList(String meetingId, String meetingDate, String meetingTheme);

}
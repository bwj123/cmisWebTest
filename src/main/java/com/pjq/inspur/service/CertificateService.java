package com.pjq.inspur.service;

import com.pjq.inspur.pojo.GzcrmCertificate;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("certificateService")
public interface CertificateService {

    int deleteCerById(int cerId);

    boolean deleteMany(String checkTnum);

    GzcrmCertificate queryCerById(int cerId);

    int updateLearn(GzcrmCertificate certificate);

    int insertCer(GzcrmCertificate certificate);

    List<GzcrmCertificate> queryList(String cmId2, String cerName);

}

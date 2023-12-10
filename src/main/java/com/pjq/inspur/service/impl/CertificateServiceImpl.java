package com.pjq.inspur.service.impl;

import com.pjq.inspur.mapper.GzcrmCertificateMapper;
import com.pjq.inspur.pojo.GzcrmCertificate;
import com.pjq.inspur.service.CertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lijiahui
 * @date 2020/7/12 -11:40
 */
@Service("certificateService")
public class CertificateServiceImpl implements CertificateService {
    @Autowired
    private GzcrmCertificateMapper certificateMapper;

    @Override
    public int deleteCerById(int cerId) {
        return certificateMapper.deleteByPrimaryKey(cerId);
    }

    @Override
    public boolean deleteMany(String checkTnum) {
        if (checkTnum != null && !checkTnum.equals("")) {
            String[] ids = checkTnum.split(",");
            for (int i = 0; i < ids.length; i++) {
                certificateMapper.deleteByPrimaryKey(Integer.parseInt(ids[i]));
            }
            return true;
        } else {
            return false;
        }
    }

    @Override
    public GzcrmCertificate queryCerById(int cerId) {
        return certificateMapper.selectByPrimaryKey(cerId);
    }

    @Override
    public int updateLearn(GzcrmCertificate certificate) {
        return certificateMapper.updateByPrimaryKeySelective(certificate);
    }

    @Override
    public int insertCer(GzcrmCertificate certificate) {
        return certificateMapper.insert(certificate);
    }

    @Override
    public List<GzcrmCertificate> queryList(String cmId2, String cerName) {
        List<GzcrmCertificate> list = new ArrayList<>();
        if (cmId2 != null && !cmId2.equals("")) {
            list = certificateMapper.queryList(cmId2, "%" + cerName + "%");
        } else {
            list = certificateMapper.queryList(null, "%" + cerName + "%");
        }
        return list;
    }
}
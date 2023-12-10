package com.pjq.inspur.service.impl;

import com.pjq.inspur.mapper.GzcrmCmarketingRecordMapper;
import com.pjq.inspur.pojo.GzcrmCmarketingRecord;
import com.pjq.inspur.service.MarketRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("marketRecordService")
public class MarketRecordServiceImpl implements MarketRecordService {
    @Autowired
    private GzcrmCmarketingRecordMapper cmarketingRecordMapper;

    @Override
    public int deleteRecordById(int mrId) {
        return cmarketingRecordMapper.deleteByPrimaryKey(mrId);
    }

    @Override
    public boolean deleteMany(String checkTnum) {
        if (checkTnum != null && !checkTnum.equals("")) {
            String[] ids = checkTnum.split(",");
            for (int i = 0; i < ids.length; i++) {
                cmarketingRecordMapper.deleteByPrimaryKey(Integer.parseInt(ids[i]));
            }
            return true;
        } else {
            return false;
        }
    }

    @Override
    public GzcrmCmarketingRecord qureyMarketRecordById(int mrId) {
        return cmarketingRecordMapper.selectByPrimaryKey(mrId);
    }

    @Override
    public int insertMarketRecord(GzcrmCmarketingRecord gzcrmCmarketingRecord) {
        return cmarketingRecordMapper.insert(gzcrmCmarketingRecord);
    }

    @Override
    public List<GzcrmCmarketingRecord> queryList(String mrId, String mrName) {
        List<GzcrmCmarketingRecord> list = new ArrayList<>();
        if (mrId != null && !mrId.equals("")) {
            GzcrmCmarketingRecord tmp = cmarketingRecordMapper.selectByPrimaryKey(Integer.parseInt(mrId));
            if (tmp != null) {
                list.add(tmp);
            }
        } else {
            list = cmarketingRecordMapper.queryList("%" + mrName + "%");
        }
        return list;
    }

    @Override
    public int updateMarketRecord(GzcrmCmarketingRecord gzcrmCmarketingRecord) {
        return cmarketingRecordMapper.updateByPrimaryKeySelective(gzcrmCmarketingRecord);
    }
}
package com.pjq.inspur.service;

import com.pjq.inspur.pojo.GzcrmCmarketingRecord;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("marketRecordService")
public interface MarketRecordService {

    int deleteRecordById(int mrId);

    boolean deleteMany(String checkTnum);

    GzcrmCmarketingRecord qureyMarketRecordById(int mrId);

    int insertMarketRecord(GzcrmCmarketingRecord gzcrmCmarketingRecord);

    List<GzcrmCmarketingRecord> queryList(String mrId, String mrName);

    int updateMarketRecord(GzcrmCmarketingRecord gzcrmCmarketingRecord);

}
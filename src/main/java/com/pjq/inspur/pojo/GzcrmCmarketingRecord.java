package com.pjq.inspur.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class GzcrmCmarketingRecord {
    private Integer cKey;

    private Integer cCmId;

    private String cName;

    private String cManagement;

    private String cDemand;

    private String cReport;

    private String cTestimonials;

    private String cEvaluation;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date cDate;

    private Integer cId;

    public Integer getcKey() {
        return cKey;
    }

    public void setcKey(Integer cKey) {
        this.cKey = cKey;
    }

    public Integer getcCmId() {
        return cCmId;
    }

    public void setcCmId(Integer cCmId) {
        this.cCmId = cCmId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName == null ? null : cName.trim();
    }

    public String getcManagement() {
        return cManagement;
    }

    public void setcManagement(String cManagement) {
        this.cManagement = cManagement == null ? null : cManagement.trim();
    }

    public String getcDemand() {
        return cDemand;
    }

    public void setcDemand(String cDemand) {
        this.cDemand = cDemand == null ? null : cDemand.trim();
    }

    public String getcReport() {
        return cReport;
    }

    public void setcReport(String cReport) {
        this.cReport = cReport == null ? null : cReport.trim();
    }

    public String getcTestimonials() {
        return cTestimonials;
    }

    public void setcTestimonials(String cTestimonials) {
        this.cTestimonials = cTestimonials == null ? null : cTestimonials.trim();
    }

    public String getcEvaluation() {
        return cEvaluation;
    }

    public void setcEvaluation(String cEvaluation) {
        this.cEvaluation = cEvaluation == null ? null : cEvaluation.trim();
    }

    public Date getcDate() {
        return cDate;
    }

    public void setcDate(Date cDate) {
        this.cDate = cDate;
    }

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }
}
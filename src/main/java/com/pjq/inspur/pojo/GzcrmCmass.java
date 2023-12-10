package com.pjq.inspur.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class GzcrmCmass {
    private Integer cmKey;

    private Integer cmId;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date cmAsstime;

    private String cmAssub;

    private String cmAssperiod;

    private String cmAssperesult;

    private String cmAssraisal;

    private String cmAssunit;

    private String cmRemark;

    private String cmAtttachment;

    private String cmModificationPerson;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date cmModificationDate;

    public Integer getCmKey() {
        return cmKey;
    }

    public void setCmKey(Integer cmKey) {
        this.cmKey = cmKey;
    }

    public Integer getCmId() {
        return cmId;
    }

    public void setCmId(Integer cmId) {
        this.cmId = cmId;
    }

    public Date getCmAsstime() {
        return cmAsstime;
    }

    public void setCmAsstime(Date cmAsstime) {
        this.cmAsstime = cmAsstime;
    }

    public String getCmAssub() {
        return cmAssub;
    }

    public void setCmAssub(String cmAssub) {
        this.cmAssub = cmAssub == null ? null : cmAssub.trim();
    }

    public String getCmAssperiod() {
        return cmAssperiod;
    }

    public void setCmAssperiod(String cmAssperiod) {
        this.cmAssperiod = cmAssperiod == null ? null : cmAssperiod.trim();
    }

    public String getCmAssperesult() {
        return cmAssperesult;
    }

    public void setCmAssperesult(String cmAssperesult) {
        this.cmAssperesult = cmAssperesult == null ? null : cmAssperesult.trim();
    }

    public String getCmAssraisal() {
        return cmAssraisal;
    }

    public void setCmAssraisal(String cmAssraisal) {
        this.cmAssraisal = cmAssraisal == null ? null : cmAssraisal.trim();
    }

    public String getCmAssunit() {
        return cmAssunit;
    }

    public void setCmAssunit(String cmAssunit) {
        this.cmAssunit = cmAssunit == null ? null : cmAssunit.trim();
    }

    public String getCmRemark() {
        return cmRemark;
    }

    public void setCmRemark(String cmRemark) {
        this.cmRemark = cmRemark == null ? null : cmRemark.trim();
    }

    public String getCmAtttachment() {
        return cmAtttachment;
    }

    public void setCmAtttachment(String cmAtttachment) {
        this.cmAtttachment = cmAtttachment == null ? null : cmAtttachment.trim();
    }

    public String getCmModificationPerson() {
        return cmModificationPerson;
    }

    public void setCmModificationPerson(String cmModificationPerson) {
        this.cmModificationPerson = cmModificationPerson == null ? null : cmModificationPerson.trim();
    }

    public Date getCmModificationDate() {
        return cmModificationDate;
    }

    public void setCmModificationDate(Date cmModificationDate) {
        this.cmModificationDate = cmModificationDate;
    }
}
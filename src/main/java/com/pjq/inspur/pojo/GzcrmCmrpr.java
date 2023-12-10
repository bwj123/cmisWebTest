package com.pjq.inspur.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class GzcrmCmrpr {
    private Integer cmKey;

    private Integer cmId;

    private String cmType;

    private String cmSub;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date cmDate;

    private String cmAunit;

    private String cmAperson;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date cmRdate;

    private String cmAreason;

    private String cmRemark;

    private String cmAttachment;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date cmModificationDate;

    private String cmModificationPerson;

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

    public String getCmType() {
        return cmType;
    }

    public void setCmType(String cmType) {
        this.cmType = cmType == null ? null : cmType.trim();
    }

    public String getCmSub() {
        return cmSub;
    }

    public void setCmSub(String cmSub) {
        this.cmSub = cmSub == null ? null : cmSub.trim();
    }

    public Date getCmDate() {
        return cmDate;
    }

    public void setCmDate(Date cmDate) {
        this.cmDate = cmDate;
    }

    public String getCmAunit() {
        return cmAunit;
    }

    public void setCmAunit(String cmAunit) {
        this.cmAunit = cmAunit == null ? null : cmAunit.trim();
    }

    public String getCmAperson() {
        return cmAperson;
    }

    public void setCmAperson(String cmAperson) {
        this.cmAperson = cmAperson == null ? null : cmAperson.trim();
    }

    public Date getCmRdate() {
        return cmRdate;
    }

    public void setCmRdate(Date cmRdate) {
        this.cmRdate = cmRdate;
    }

    public String getCmAreason() {
        return cmAreason;
    }

    public void setCmAreason(String cmAreason) {
        this.cmAreason = cmAreason == null ? null : cmAreason.trim();
    }

    public String getCmRemark() {
        return cmRemark;
    }

    public void setCmRemark(String cmRemark) {
        this.cmRemark = cmRemark == null ? null : cmRemark.trim();
    }

    public String getCmAttachment() {
        return cmAttachment;
    }

    public void setCmAttachment(String cmAttachment) {
        this.cmAttachment = cmAttachment == null ? null : cmAttachment.trim();
    }

    public Date getCmModificationDate() {
        return cmModificationDate;
    }

    public void setCmModificationDate(Date cmModificationDate) {
        this.cmModificationDate = cmModificationDate;
    }

    public String getCmModificationPerson() {
        return cmModificationPerson;
    }

    public void setCmModificationPerson(String cmModificationPerson) {
        this.cmModificationPerson = cmModificationPerson == null ? null : cmModificationPerson.trim();
    }
}
package com.pjq.inspur.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class GzcrmCmltr {
    private Integer cmKey;

    private Integer cmId;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date cmTdate;

    private String cmSub;

    private String cmTunit;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date cmStartdate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date cmEnddate;

    private String cmKnow;

    private Integer cmCredit;

    private Double cmScore;

    private String cmAttachment;

    private String cmRemark;

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

    public Date getCmTdate() {
        return cmTdate;
    }

    public void setCmTdate(Date cmTdate) {
        this.cmTdate = cmTdate;
    }

    public String getCmSub() {
        return cmSub;
    }

    public void setCmSub(String cmSub) {
        this.cmSub = cmSub == null ? null : cmSub.trim();
    }

    public String getCmTunit() {
        return cmTunit;
    }

    public void setCmTunit(String cmTunit) {
        this.cmTunit = cmTunit == null ? null : cmTunit.trim();
    }

    public Date getCmStartdate() {
        return cmStartdate;
    }

    public void setCmStartdate(Date cmStartdate) {
        this.cmStartdate = cmStartdate;
    }

    public Date getCmEnddate() {
        return cmEnddate;
    }

    public void setCmEnddate(Date cmEnddate) {
        this.cmEnddate = cmEnddate;
    }

    public String getCmKnow() {
        return cmKnow;
    }

    public void setCmKnow(String cmKnow) {
        this.cmKnow = cmKnow == null ? null : cmKnow.trim();
    }

    public Integer getCmCredit() {
        return cmCredit;
    }

    public void setCmCredit(Integer cmCredit) {
        this.cmCredit = cmCredit;
    }

    public Double getCmScore() {
        return cmScore;
    }

    public void setCmScore(Double cmScore) {
        this.cmScore = cmScore;
    }

    public String getCmAttachment() {
        return cmAttachment;
    }

    public void setCmAttachment(String cmAttachment) {
        this.cmAttachment = cmAttachment == null ? null : cmAttachment.trim();
    }

    public String getCmRemark() {
        return cmRemark;
    }

    public void setCmRemark(String cmRemark) {
        this.cmRemark = cmRemark == null ? null : cmRemark.trim();
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
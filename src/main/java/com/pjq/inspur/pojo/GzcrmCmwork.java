package com.pjq.inspur.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class GzcrmCmwork {
    private Integer cmKey;

    private Integer cmId;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date cmOfficeDate;

    private String cmPosition;

    private String cmUnit;

    private String cmAttachment;

    private String cmWork;

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

    public Date getCmOfficeDate() {
        return cmOfficeDate;
    }

    public void setCmOfficeDate(Date cmOfficeDate) {
        this.cmOfficeDate = cmOfficeDate;
    }

    public String getCmPosition() {
        return cmPosition;
    }

    public void setCmPosition(String cmPosition) {
        this.cmPosition = cmPosition == null ? null : cmPosition.trim();
    }

    public String getCmUnit() {
        return cmUnit;
    }

    public void setCmUnit(String cmUnit) {
        this.cmUnit = cmUnit == null ? null : cmUnit.trim();
    }

    public String getCmAttachment() {
        return cmAttachment;
    }

    public void setCmAttachment(String cmAttachment) {
        this.cmAttachment = cmAttachment == null ? null : cmAttachment.trim();
    }

    public String getCmWork() {
        return cmWork;
    }

    public void setCmWork(String cmWork) {
        this.cmWork = cmWork == null ? null : cmWork.trim();
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
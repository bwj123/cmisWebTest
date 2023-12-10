package com.pjq.inspur.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class GzcrmCmlevel {
    private Integer cmKey;

    private Integer cmId;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date cmHoldDate;

    private String cmHoldLevel;

    private String cmHoldType;

    private String cmAttachment;

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

    public Date getCmHoldDate() {
        return cmHoldDate;
    }

    public void setCmHoldDate(Date cmHoldDate) {
        this.cmHoldDate = cmHoldDate;
    }

    public String getCmHoldLevel() {
        return cmHoldLevel;
    }

    public void setCmHoldLevel(String cmHoldLevel) {
        this.cmHoldLevel = cmHoldLevel == null ? null : cmHoldLevel.trim();
    }

    public String getCmHoldType() {
        return cmHoldType;
    }

    public void setCmHoldType(String cmHoldType) {
        this.cmHoldType = cmHoldType == null ? null : cmHoldType.trim();
    }

    public String getCmAttachment() {
        return cmAttachment;
    }

    public void setCmAttachment(String cmAttachment) {
        this.cmAttachment = cmAttachment == null ? null : cmAttachment.trim();
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
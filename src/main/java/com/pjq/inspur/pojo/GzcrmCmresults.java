package com.pjq.inspur.pojo;

import java.util.Date;

public class GzcrmCmresults {
    private Integer cmKey;

    private Integer cmId;

    private String cmYear;

    private String cmResult;

    private String cmAttachment;

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

    public String getCmYear() {
        return cmYear;
    }

    public void setCmYear(String cmYear) {
        this.cmYear = cmYear == null ? null : cmYear.trim();
    }

    public String getCmResult() {
        return cmResult;
    }

    public void setCmResult(String cmResult) {
        this.cmResult = cmResult == null ? null : cmResult.trim();
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
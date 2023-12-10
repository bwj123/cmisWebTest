package com.pjq.inspur.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class GzcrmCmregular {
    private Integer cmKey;

    private Integer cmId;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date cmRegularDate;

    private String cmRegularPersonnel;

    private String cmRegularTheme;

    private String cmAttachment;

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

    public Date getCmRegularDate() {
        return cmRegularDate;
    }

    public void setCmRegularDate(Date cmRegularDate) {
        this.cmRegularDate = cmRegularDate;
    }

    public String getCmRegularPersonnel() {
        return cmRegularPersonnel;
    }

    public void setCmRegularPersonnel(String cmRegularPersonnel) {
        this.cmRegularPersonnel = cmRegularPersonnel == null ? null : cmRegularPersonnel.trim();
    }

    public String getCmRegularTheme() {
        return cmRegularTheme;
    }

    public void setCmRegularTheme(String cmRegularTheme) {
        this.cmRegularTheme = cmRegularTheme == null ? null : cmRegularTheme.trim();
    }

    public String getCmAttachment() {
        return cmAttachment;
    }

    public void setCmAttachment(String cmAttachment) {
        this.cmAttachment = cmAttachment == null ? null : cmAttachment.trim();
    }
}
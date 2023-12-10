package com.pjq.inspur.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class GzcrmLearn {
    private Integer lKey;

    private String lName;

    private String lType;

    private String lDes;

    private String lUrl;

    private String lLine;

    private String lUper;

    private String lUnit;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date lDate;

    public Integer getlKey() {
        return lKey;
    }

    public void setlKey(Integer lKey) {
        this.lKey = lKey;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName == null ? null : lName.trim();
    }

    public String getlType() {
        return lType;
    }

    public void setlType(String lType) {
        this.lType = lType == null ? null : lType.trim();
    }

    public String getlDes() {
        return lDes;
    }

    public void setlDes(String lDes) {
        this.lDes = lDes == null ? null : lDes.trim();
    }

    public String getlUrl() {
        return lUrl;
    }

    public void setlUrl(String lUrl) {
        this.lUrl = lUrl == null ? null : lUrl.trim();
    }

    public String getlLine() {
        return lLine;
    }

    public void setlLine(String lLine) {
        this.lLine = lLine == null ? null : lLine.trim();
    }

    public String getlUper() {
        return lUper;
    }

    public void setlUper(String lUper) {
        this.lUper = lUper == null ? null : lUper.trim();
    }

    public String getlUnit() {
        return lUnit;
    }

    public void setlUnit(String lUnit) {
        this.lUnit = lUnit == null ? null : lUnit.trim();
    }

    public Date getlDate() {
        return lDate;
    }

    public void setlDate(Date lDate) {
        this.lDate = lDate;
    }
}
package com.pjq.inspur.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class GzcrmCertificate {
    private Integer cmKey;

    private Integer cmId;

    private String cmCertificateName;

    private String cmCertificateType;

    private String cmCertificateNo;

    private String cmCertificateUnit;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date cmStartDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date cmEndDate;

    private Integer cmPeriod;

    private String cmCertificateUrl;

    private String cmInvalid;

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

    public String getCmCertificateName() {
        return cmCertificateName;
    }

    public void setCmCertificateName(String cmCertificateName) {
        this.cmCertificateName = cmCertificateName == null ? null : cmCertificateName.trim();
    }

    public String getCmCertificateType() {
        return cmCertificateType;
    }

    public void setCmCertificateType(String cmCertificateType) {
        this.cmCertificateType = cmCertificateType == null ? null : cmCertificateType.trim();
    }

    public String getCmCertificateNo() {
        return cmCertificateNo;
    }

    public void setCmCertificateNo(String cmCertificateNo) {
        this.cmCertificateNo = cmCertificateNo == null ? null : cmCertificateNo.trim();
    }

    public String getCmCertificateUnit() {
        return cmCertificateUnit;
    }

    public void setCmCertificateUnit(String cmCertificateUnit) {
        this.cmCertificateUnit = cmCertificateUnit == null ? null : cmCertificateUnit.trim();
    }

    public Date getCmStartDate() {
        return cmStartDate;
    }

    public void setCmStartDate(Date cmStartDate) {
        this.cmStartDate = cmStartDate;
    }

    public Date getCmEndDate() {
        return cmEndDate;
    }

    public void setCmEndDate(Date cmEndDate) {
        this.cmEndDate = cmEndDate;
    }

    public Integer getCmPeriod() {
        return cmPeriod;
    }

    public void setCmPeriod(Integer cmPeriod) {
        this.cmPeriod = cmPeriod;
    }

    public String getCmCertificateUrl() {
        return cmCertificateUrl;
    }

    public void setCmCertificateUrl(String cmCertificateUrl) {
        this.cmCertificateUrl = cmCertificateUrl == null ? null : cmCertificateUrl.trim();
    }

    public String getCmInvalid() {
        return cmInvalid;
    }

    public void setCmInvalid(String cmInvalid) {
        this.cmInvalid = cmInvalid == null ? null : cmInvalid.trim();
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
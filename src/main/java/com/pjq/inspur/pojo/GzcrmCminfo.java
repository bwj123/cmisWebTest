package com.pjq.inspur.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class GzcrmCminfo {
    private Integer cmId;

    private String cmName;

    private String cmSex;

    private String cmSsn;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date cmBirthday;

    private Integer cmAge;

    private String cmNation;

    private String cmPoliticalLandscape;

    private String cmHometown;

    private String cmPhoto;

    private String cmEducation;

    private String cmDegree;

    private String cmStatus;

    private String cmGraduated;

    private String cmProfessionalTitles;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date cmHiredate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date cmEntryTime;

    private Integer cmFinancialYears;

    private Integer cmWorkingYears;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date cmExitTime;

    private Integer cmResultsLastYear;

    private Integer cmTotalCredits;

    private String cmLevel;

    private String cmUnit;

    private String cmDept;

    private String cmPosition;

    private String cmTel;

    private String cmMobile;

    private String cmBusinessLines;

    private String cmCertificateNumber;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date cmQualificationDate;

    private Integer cmQualificationPeriod;

    private String cmStatusNumber;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date cmStatusNumberDate;

    private Integer cmStatusNumberPeriod;

    private String cmLevelNumber;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date cmLevelDate;

    private Integer cmLevelPeriod;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date cmModificationDate;

    private String cmModificationPerson;

    public Integer getCmId() {
        return cmId;
    }

    public void setCmId(Integer cmId) {
        this.cmId = cmId;
    }

    public String getCmName() {
        return cmName;
    }

    public void setCmName(String cmName) {
        this.cmName = cmName == null ? null : cmName.trim();
    }

    public String getCmSex() {
        return cmSex;
    }

    public void setCmSex(String cmSex) {
        this.cmSex = cmSex == null ? null : cmSex.trim();
    }

    public String getCmSsn() {
        return cmSsn;
    }

    public void setCmSsn(String cmSsn) {
        this.cmSsn = cmSsn == null ? null : cmSsn.trim();
    }

    public Date getCmBirthday() {
        return cmBirthday;
    }

    public void setCmBirthday(Date cmBirthday) {
        this.cmBirthday = cmBirthday;
    }

    public Integer getCmAge() {
        return cmAge;
    }

    public void setCmAge(Integer cmAge) {
        this.cmAge = cmAge;
    }

    public String getCmNation() {
        return cmNation;
    }

    public void setCmNation(String cmNation) {
        this.cmNation = cmNation == null ? null : cmNation.trim();
    }

    public String getCmPoliticalLandscape() {
        return cmPoliticalLandscape;
    }

    public void setCmPoliticalLandscape(String cmPoliticalLandscape) {
        this.cmPoliticalLandscape = cmPoliticalLandscape == null ? null : cmPoliticalLandscape.trim();
    }

    public String getCmHometown() {
        return cmHometown;
    }

    public void setCmHometown(String cmHometown) {
        this.cmHometown = cmHometown == null ? null : cmHometown.trim();
    }

    public String getCmPhoto() {
        return cmPhoto;
    }

    public void setCmPhoto(String cmPhoto) {
        this.cmPhoto = cmPhoto == null ? null : cmPhoto.trim();
    }

    public String getCmEducation() {
        return cmEducation;
    }

    public void setCmEducation(String cmEducation) {
        this.cmEducation = cmEducation == null ? null : cmEducation.trim();
    }

    public String getCmDegree() {
        return cmDegree;
    }

    public void setCmDegree(String cmDegree) {
        this.cmDegree = cmDegree == null ? null : cmDegree.trim();
    }

    public String getCmStatus() {
        return cmStatus;
    }

    public void setCmStatus(String cmStatus) {
        this.cmStatus = cmStatus == null ? null : cmStatus.trim();
    }

    public String getCmGraduated() {
        return cmGraduated;
    }

    public void setCmGraduated(String cmGraduated) {
        this.cmGraduated = cmGraduated == null ? null : cmGraduated.trim();
    }

    public String getCmProfessionalTitles() {
        return cmProfessionalTitles;
    }

    public void setCmProfessionalTitles(String cmProfessionalTitles) {
        this.cmProfessionalTitles = cmProfessionalTitles == null ? null : cmProfessionalTitles.trim();
    }

    public Date getCmHiredate() {
        return cmHiredate;
    }

    public void setCmHiredate(Date cmHiredate) {
        this.cmHiredate = cmHiredate;
    }

    public Date getCmEntryTime() {
        return cmEntryTime;
    }

    public void setCmEntryTime(Date cmEntryTime) {
        this.cmEntryTime = cmEntryTime;
    }

    public Integer getCmFinancialYears() {
        return cmFinancialYears;
    }

    public void setCmFinancialYears(Integer cmFinancialYears) {
        this.cmFinancialYears = cmFinancialYears;
    }

    public Integer getCmWorkingYears() {
        return cmWorkingYears;
    }

    public void setCmWorkingYears(Integer cmWorkingYears) {
        this.cmWorkingYears = cmWorkingYears;
    }

    public Date getCmExitTime() {
        return cmExitTime;
    }

    public void setCmExitTime(Date cmExitTime) {
        this.cmExitTime = cmExitTime;
    }

    public Integer getCmResultsLastYear() {
        return cmResultsLastYear;
    }

    public void setCmResultsLastYear(Integer cmResultsLastYear) {
        this.cmResultsLastYear = cmResultsLastYear;
    }

    public Integer getCmTotalCredits() {
        return cmTotalCredits;
    }

    public void setCmTotalCredits(Integer cmTotalCredits) {
        this.cmTotalCredits = cmTotalCredits;
    }

    public String getCmLevel() {
        return cmLevel;
    }

    public void setCmLevel(String cmLevel) {
        this.cmLevel = cmLevel == null ? null : cmLevel.trim();
    }

    public String getCmUnit() {
        return cmUnit;
    }

    public void setCmUnit(String cmUnit) {
        this.cmUnit = cmUnit == null ? null : cmUnit.trim();
    }

    public String getCmDept() {
        return cmDept;
    }

    public void setCmDept(String cmDept) {
        this.cmDept = cmDept == null ? null : cmDept.trim();
    }

    public String getCmPosition() {
        return cmPosition;
    }

    public void setCmPosition(String cmPosition) {
        this.cmPosition = cmPosition == null ? null : cmPosition.trim();
    }

    public String getCmTel() {
        return cmTel;
    }

    public void setCmTel(String cmTel) {
        this.cmTel = cmTel == null ? null : cmTel.trim();
    }

    public String getCmMobile() {
        return cmMobile;
    }

    public void setCmMobile(String cmMobile) {
        this.cmMobile = cmMobile == null ? null : cmMobile.trim();
    }

    public String getCmBusinessLines() {
        return cmBusinessLines;
    }

    public void setCmBusinessLines(String cmBusinessLines) {
        this.cmBusinessLines = cmBusinessLines == null ? null : cmBusinessLines.trim();
    }

    public String getCmCertificateNumber() {
        return cmCertificateNumber;
    }

    public void setCmCertificateNumber(String cmCertificateNumber) {
        this.cmCertificateNumber = cmCertificateNumber == null ? null : cmCertificateNumber.trim();
    }

    public Date getCmQualificationDate() {
        return cmQualificationDate;
    }

    public void setCmQualificationDate(Date cmQualificationDate) {
        this.cmQualificationDate = cmQualificationDate;
    }

    public Integer getCmQualificationPeriod() {
        return cmQualificationPeriod;
    }

    public void setCmQualificationPeriod(Integer cmQualificationPeriod) {
        this.cmQualificationPeriod = cmQualificationPeriod;
    }

    public String getCmStatusNumber() {
        return cmStatusNumber;
    }

    public void setCmStatusNumber(String cmStatusNumber) {
        this.cmStatusNumber = cmStatusNumber == null ? null : cmStatusNumber.trim();
    }

    public Date getCmStatusNumberDate() {
        return cmStatusNumberDate;
    }

    public void setCmStatusNumberDate(Date cmStatusNumberDate) {
        this.cmStatusNumberDate = cmStatusNumberDate;
    }

    public Integer getCmStatusNumberPeriod() {
        return cmStatusNumberPeriod;
    }

    public void setCmStatusNumberPeriod(Integer cmStatusNumberPeriod) {
        this.cmStatusNumberPeriod = cmStatusNumberPeriod;
    }

    public String getCmLevelNumber() {
        return cmLevelNumber;
    }

    public void setCmLevelNumber(String cmLevelNumber) {
        this.cmLevelNumber = cmLevelNumber == null ? null : cmLevelNumber.trim();
    }

    public Date getCmLevelDate() {
        return cmLevelDate;
    }

    public void setCmLevelDate(Date cmLevelDate) {
        this.cmLevelDate = cmLevelDate;
    }

    public Integer getCmLevelPeriod() {
        return cmLevelPeriod;
    }

    public void setCmLevelPeriod(Integer cmLevelPeriod) {
        this.cmLevelPeriod = cmLevelPeriod;
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
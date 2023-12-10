package com.pjq.inspur.pojo;

public class GzcrmCinfo {
    private Integer cKey;

    private Integer cCmId;

    private String cSsn;

    private String cName;

    private String cTel;

    private Double cSalary;

    private Double cBalance;

    private Double cDebt;

    private String cBusiness;

    private String cUnit;

    private String cAdd;

    public Integer getcKey() {
        return cKey;
    }

    public void setcKey(Integer cKey) {
        this.cKey = cKey;
    }

    public Integer getcCmId() {
        return cCmId;
    }

    public void setcCmId(Integer cCmId) {
        this.cCmId = cCmId;
    }

    public String getcSsn() {
        return cSsn;
    }

    public void setcSsn(String cSsn) {
        this.cSsn = cSsn == null ? null : cSsn.trim();
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName == null ? null : cName.trim();
    }

    public String getcTel() {
        return cTel;
    }

    public void setcTel(String cTel) {
        this.cTel = cTel == null ? null : cTel.trim();
    }

    public Double getcSalary() {
        return cSalary;
    }

    public void setcSalary(Double cSalary) {
        this.cSalary = cSalary;
    }

    public Double getcBalance() {
        return cBalance;
    }

    public void setcBalance(Double cBalance) {
        this.cBalance = cBalance;
    }

    public Double getcDebt() {
        return cDebt;
    }

    public void setcDebt(Double cDebt) {
        this.cDebt = cDebt;
    }

    public String getcBusiness() {
        return cBusiness;
    }

    public void setcBusiness(String cBusiness) {
        this.cBusiness = cBusiness == null ? null : cBusiness.trim();
    }

    public String getcUnit() {
        return cUnit;
    }

    public void setcUnit(String cUnit) {
        this.cUnit = cUnit == null ? null : cUnit.trim();
    }

    public String getcAdd() {
        return cAdd;
    }

    public void setcAdd(String cAdd) {
        this.cAdd = cAdd == null ? null : cAdd.trim();
    }
}
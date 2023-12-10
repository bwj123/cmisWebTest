package com.pjq.inspur.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class YcMember {
    private Integer memId;

    private String cname;

    private String memPass;

    private String memSex;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date memBorn;

    private String memMail;

    private String memQuestion;

    private String memAnswer;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date registerTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date lastTime;

    private String isenable;

    private Integer roleid;

    private String others;

    public Integer getMemId() {
        return memId;
    }

    public void setMemId(Integer memId) {
        this.memId = memId;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname == null ? null : cname.trim();
    }

    public String getMemPass() {
        return memPass;
    }

    public void setMemPass(String memPass) {
        this.memPass = memPass == null ? null : memPass.trim();
    }

    public String getMemSex() {
        return memSex;
    }

    public void setMemSex(String memSex) {
        this.memSex = memSex == null ? null : memSex.trim();
    }

    public Date getMemBorn() {
        return memBorn;
    }

    public void setMemBorn(Date memBorn) {
        this.memBorn = memBorn;
    }

    public String getMemMail() {
        return memMail;
    }

    public void setMemMail(String memMail) {
        this.memMail = memMail == null ? null : memMail.trim();
    }

    public String getMemQuestion() {
        return memQuestion;
    }

    public void setMemQuestion(String memQuestion) {
        this.memQuestion = memQuestion == null ? null : memQuestion.trim();
    }

    public String getMemAnswer() {
        return memAnswer;
    }

    public void setMemAnswer(String memAnswer) {
        this.memAnswer = memAnswer == null ? null : memAnswer.trim();
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    public Date getLastTime() {
        return lastTime;
    }

    public void setLastTime(Date lastTime) {
        this.lastTime = lastTime;
    }

    public String getIsenable() {
        return isenable;
    }

    public void setIsenable(String isenable) {
        this.isenable = isenable == null ? null : isenable.trim();
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public String getOthers() {
        return others;
    }

    public void setOthers(String others) {
        this.others = others == null ? null : others.trim();
    }
}
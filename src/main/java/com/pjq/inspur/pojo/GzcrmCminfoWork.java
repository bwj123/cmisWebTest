package com.pjq.inspur.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class GzcrmCminfoWork {
    private Integer cmKey;

    private Integer cmId;

    private String cmManagement;

    private String cmProduct;

    private String cmLoan;

    private String cmWarning;

    private String cmIssue;

    private String cmWorkProposal;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date cmDate;

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

    public String getCmManagement() {
        return cmManagement;
    }

    public void setCmManagement(String cmManagement) {
        this.cmManagement = cmManagement == null ? null : cmManagement.trim();
    }

    public String getCmProduct() {
        return cmProduct;
    }

    public void setCmProduct(String cmProduct) {
        this.cmProduct = cmProduct == null ? null : cmProduct.trim();
    }

    public String getCmLoan() {
        return cmLoan;
    }

    public void setCmLoan(String cmLoan) {
        this.cmLoan = cmLoan == null ? null : cmLoan.trim();
    }

    public String getCmWarning() {
        return cmWarning;
    }

    public void setCmWarning(String cmWarning) {
        this.cmWarning = cmWarning == null ? null : cmWarning.trim();
    }

    public String getCmIssue() {
        return cmIssue;
    }

    public void setCmIssue(String cmIssue) {
        this.cmIssue = cmIssue == null ? null : cmIssue.trim();
    }

    public String getCmWorkProposal() {
        return cmWorkProposal;
    }

    public void setCmWorkProposal(String cmWorkProposal) {
        this.cmWorkProposal = cmWorkProposal == null ? null : cmWorkProposal.trim();
    }

    public Date getCmDate() {
        return cmDate;
    }

    public void setCmDate(Date cmDate) {
        this.cmDate = cmDate;
    }
}
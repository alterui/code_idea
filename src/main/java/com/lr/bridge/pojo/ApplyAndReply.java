package com.lr.bridge.pojo;

import java.util.Date;

public class ApplyAndReply {
    private Integer id;

    private String contractorUnit;

    private String bidNum;

    private String supervision;

    private String serialNum;

    private String formName;

    private String director;

    private String projectName;

    private String contractorName;

    private Date applicationTime;

    private String directorView;

    private Date directorReplyTime;

    private String centerView;

    private Date centerReplyTime;

    public ApplyAndReply(Integer id, String contractorUnit, String bidNum, String supervision, String serialNum, String formName, String director, String projectName, String contractorName, Date applicationTime, String directorView, Date directorReplyTime, String centerView, Date centerReplyTime) {
        this.id = id;
        this.contractorUnit = contractorUnit;
        this.bidNum = bidNum;
        this.supervision = supervision;
        this.serialNum = serialNum;
        this.formName = formName;
        this.director = director;
        this.projectName = projectName;
        this.contractorName = contractorName;
        this.applicationTime = applicationTime;
        this.directorView = directorView;
        this.directorReplyTime = directorReplyTime;
        this.centerView = centerView;
        this.centerReplyTime = centerReplyTime;
    }

    public ApplyAndReply() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContractorUnit() {
        return contractorUnit;
    }

    public void setContractorUnit(String contractorUnit) {
        this.contractorUnit = contractorUnit == null ? null : contractorUnit.trim();
    }

    public String getBidNum() {
        return bidNum;
    }

    public void setBidNum(String bidNum) {
        this.bidNum = bidNum == null ? null : bidNum.trim();
    }

    public String getSupervision() {
        return supervision;
    }

    public void setSupervision(String supervision) {
        this.supervision = supervision == null ? null : supervision.trim();
    }

    public String getSerialNum() {
        return serialNum;
    }

    public void setSerialNum(String serialNum) {
        this.serialNum = serialNum == null ? null : serialNum.trim();
    }

    public String getFormName() {
        return formName;
    }

    public void setFormName(String formName) {
        this.formName = formName == null ? null : formName.trim();
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director == null ? null : director.trim();
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName == null ? null : projectName.trim();
    }

    public String getContractorName() {
        return contractorName;
    }

    public void setContractorName(String contractorName) {
        this.contractorName = contractorName == null ? null : contractorName.trim();
    }

    public Date getApplicationTime() {
        return applicationTime;
    }

    public void setApplicationTime(Date applicationTime) {
        this.applicationTime = applicationTime;
    }

    public String getDirectorView() {
        return directorView;
    }

    public void setDirectorView(String directorView) {
        this.directorView = directorView == null ? null : directorView.trim();
    }

    public Date getDirectorReplyTime() {
        return directorReplyTime;
    }

    public void setDirectorReplyTime(Date directorReplyTime) {
        this.directorReplyTime = directorReplyTime;
    }

    public String getCenterView() {
        return centerView;
    }

    public void setCenterView(String centerView) {
        this.centerView = centerView == null ? null : centerView.trim();
    }

    public Date getCenterReplyTime() {
        return centerReplyTime;
    }

    public void setCenterReplyTime(Date centerReplyTime) {
        this.centerReplyTime = centerReplyTime;
    }
}
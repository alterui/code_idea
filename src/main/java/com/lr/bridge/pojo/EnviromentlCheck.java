package com.lr.bridge.pojo;

public class EnviromentlCheck {
    private Integer id;

    private String environmentalInspectId;

    private String constructionSite;

    private String causeOfTheAccident;

    private String natureOfTheAccident;

    private String treatment;

    private String preliminaryTreatmentComments;

    public EnviromentlCheck(Integer id, String environmentalInspectId, String constructionSite, String causeOfTheAccident, String natureOfTheAccident, String treatment, String preliminaryTreatmentComments) {
        this.id = id;
        this.environmentalInspectId = environmentalInspectId;
        this.constructionSite = constructionSite;
        this.causeOfTheAccident = causeOfTheAccident;
        this.natureOfTheAccident = natureOfTheAccident;
        this.treatment = treatment;
        this.preliminaryTreatmentComments = preliminaryTreatmentComments;
    }

    public EnviromentlCheck() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEnvironmentalInspectId() {
        return environmentalInspectId;
    }

    public void setEnvironmentalInspectId(String environmentalInspectId) {
        this.environmentalInspectId = environmentalInspectId == null ? null : environmentalInspectId.trim();
    }

    public String getConstructionSite() {
        return constructionSite;
    }

    public void setConstructionSite(String constructionSite) {
        this.constructionSite = constructionSite == null ? null : constructionSite.trim();
    }

    public String getCauseOfTheAccident() {
        return causeOfTheAccident;
    }

    public void setCauseOfTheAccident(String causeOfTheAccident) {
        this.causeOfTheAccident = causeOfTheAccident == null ? null : causeOfTheAccident.trim();
    }

    public String getNatureOfTheAccident() {
        return natureOfTheAccident;
    }

    public void setNatureOfTheAccident(String natureOfTheAccident) {
        this.natureOfTheAccident = natureOfTheAccident == null ? null : natureOfTheAccident.trim();
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment == null ? null : treatment.trim();
    }

    public String getPreliminaryTreatmentComments() {
        return preliminaryTreatmentComments;
    }

    public void setPreliminaryTreatmentComments(String preliminaryTreatmentComments) {
        this.preliminaryTreatmentComments = preliminaryTreatmentComments == null ? null : preliminaryTreatmentComments.trim();
    }
}
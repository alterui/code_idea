package com.lr.bridge.pojo;

import java.util.Date;

public class BeamQuality {
    private Integer id;

    private String struId;

    private String axialDevi;

    private String sectionDevi;

    private String topElevDevi;

    private String segmHeightDevi;

    private String heightDevi;

    private String crossSlopeDevi;

    private String embePartsDevi;

    private String smooDevi;

    private String cableTubeAxisDevi;

    private String prestTendDevi;

    private String cableTensi;

    private String bridgeSite;

    private Date beamqualityCheckTime;

    private Integer isQualify;

    public BeamQuality(Integer id, String struId, String axialDevi, String sectionDevi, String topElevDevi, String segmHeightDevi, String heightDevi, String crossSlopeDevi, String embePartsDevi, String smooDevi, String cableTubeAxisDevi, String prestTendDevi, String cableTensi, String bridgeSite, Date beamqualityCheckTime, Integer isQualify) {
        this.id = id;
        this.struId = struId;
        this.axialDevi = axialDevi;
        this.sectionDevi = sectionDevi;
        this.topElevDevi = topElevDevi;
        this.segmHeightDevi = segmHeightDevi;
        this.heightDevi = heightDevi;
        this.crossSlopeDevi = crossSlopeDevi;
        this.embePartsDevi = embePartsDevi;
        this.smooDevi = smooDevi;
        this.cableTubeAxisDevi = cableTubeAxisDevi;
        this.prestTendDevi = prestTendDevi;
        this.cableTensi = cableTensi;
        this.bridgeSite = bridgeSite;
        this.beamqualityCheckTime = beamqualityCheckTime;
        this.isQualify = isQualify;
    }

    public BeamQuality() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStruId() {
        return struId;
    }

    public void setStruId(String struId) {
        this.struId = struId == null ? null : struId.trim();
    }

    public String getAxialDevi() {
        return axialDevi;
    }

    public void setAxialDevi(String axialDevi) {
        this.axialDevi = axialDevi == null ? null : axialDevi.trim();
    }

    public String getSectionDevi() {
        return sectionDevi;
    }

    public void setSectionDevi(String sectionDevi) {
        this.sectionDevi = sectionDevi == null ? null : sectionDevi.trim();
    }

    public String getTopElevDevi() {
        return topElevDevi;
    }

    public void setTopElevDevi(String topElevDevi) {
        this.topElevDevi = topElevDevi == null ? null : topElevDevi.trim();
    }

    public String getSegmHeightDevi() {
        return segmHeightDevi;
    }

    public void setSegmHeightDevi(String segmHeightDevi) {
        this.segmHeightDevi = segmHeightDevi == null ? null : segmHeightDevi.trim();
    }

    public String getHeightDevi() {
        return heightDevi;
    }

    public void setHeightDevi(String heightDevi) {
        this.heightDevi = heightDevi == null ? null : heightDevi.trim();
    }

    public String getCrossSlopeDevi() {
        return crossSlopeDevi;
    }

    public void setCrossSlopeDevi(String crossSlopeDevi) {
        this.crossSlopeDevi = crossSlopeDevi == null ? null : crossSlopeDevi.trim();
    }

    public String getEmbePartsDevi() {
        return embePartsDevi;
    }

    public void setEmbePartsDevi(String embePartsDevi) {
        this.embePartsDevi = embePartsDevi == null ? null : embePartsDevi.trim();
    }

    public String getSmooDevi() {
        return smooDevi;
    }

    public void setSmooDevi(String smooDevi) {
        this.smooDevi = smooDevi == null ? null : smooDevi.trim();
    }

    public String getCableTubeAxisDevi() {
        return cableTubeAxisDevi;
    }

    public void setCableTubeAxisDevi(String cableTubeAxisDevi) {
        this.cableTubeAxisDevi = cableTubeAxisDevi == null ? null : cableTubeAxisDevi.trim();
    }

    public String getPrestTendDevi() {
        return prestTendDevi;
    }

    public void setPrestTendDevi(String prestTendDevi) {
        this.prestTendDevi = prestTendDevi == null ? null : prestTendDevi.trim();
    }

    public String getCableTensi() {
        return cableTensi;
    }

    public void setCableTensi(String cableTensi) {
        this.cableTensi = cableTensi == null ? null : cableTensi.trim();
    }

    public String getBridgeSite() {
        return bridgeSite;
    }

    public void setBridgeSite(String bridgeSite) {
        this.bridgeSite = bridgeSite == null ? null : bridgeSite.trim();
    }

    public Date getBeamqualityCheckTime() {
        return beamqualityCheckTime;
    }

    public void setBeamqualityCheckTime(Date beamqualityCheckTime) {
        this.beamqualityCheckTime = beamqualityCheckTime;
    }

    public Integer getIsQualify() {
        return isQualify;
    }

    public void setIsQualify(Integer isQualify) {
        this.isQualify = isQualify;
    }
}
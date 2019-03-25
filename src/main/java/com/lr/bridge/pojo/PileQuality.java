package com.lr.bridge.pojo;

import java.util.Date;

public class PileQuality {
    private Integer id;

    private String struId;

    private String pileDevi;

    private String sediThiDevi;

    private String vertDevi;

    private String holeDepthDevi;

    private String aperDevi;

    private String mudPropDevi;

    private String mudSurfDevi;

    private String rebarDevi;

    private String conctre;

    private String fillingFactor;

    private String pileTopDevi;

    private Date pilequalityCheckTime;

    private Integer isQualify;

    public PileQuality(Integer id, String struId, String pileDevi, String sediThiDevi, String vertDevi, String holeDepthDevi, String aperDevi, String mudPropDevi, String mudSurfDevi, String rebarDevi, String conctre, String fillingFactor, String pileTopDevi, Date pilequalityCheckTime, Integer isQualify) {
        this.id = id;
        this.struId = struId;
        this.pileDevi = pileDevi;
        this.sediThiDevi = sediThiDevi;
        this.vertDevi = vertDevi;
        this.holeDepthDevi = holeDepthDevi;
        this.aperDevi = aperDevi;
        this.mudPropDevi = mudPropDevi;
        this.mudSurfDevi = mudSurfDevi;
        this.rebarDevi = rebarDevi;
        this.conctre = conctre;
        this.fillingFactor = fillingFactor;
        this.pileTopDevi = pileTopDevi;
        this.pilequalityCheckTime = pilequalityCheckTime;
        this.isQualify = isQualify;
    }

    public PileQuality() {
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

    public String getPileDevi() {
        return pileDevi;
    }

    public void setPileDevi(String pileDevi) {
        this.pileDevi = pileDevi == null ? null : pileDevi.trim();
    }

    public String getSediThiDevi() {
        return sediThiDevi;
    }

    public void setSediThiDevi(String sediThiDevi) {
        this.sediThiDevi = sediThiDevi == null ? null : sediThiDevi.trim();
    }

    public String getVertDevi() {
        return vertDevi;
    }

    public void setVertDevi(String vertDevi) {
        this.vertDevi = vertDevi == null ? null : vertDevi.trim();
    }

    public String getHoleDepthDevi() {
        return holeDepthDevi;
    }

    public void setHoleDepthDevi(String holeDepthDevi) {
        this.holeDepthDevi = holeDepthDevi == null ? null : holeDepthDevi.trim();
    }

    public String getAperDevi() {
        return aperDevi;
    }

    public void setAperDevi(String aperDevi) {
        this.aperDevi = aperDevi == null ? null : aperDevi.trim();
    }

    public String getMudPropDevi() {
        return mudPropDevi;
    }

    public void setMudPropDevi(String mudPropDevi) {
        this.mudPropDevi = mudPropDevi == null ? null : mudPropDevi.trim();
    }

    public String getMudSurfDevi() {
        return mudSurfDevi;
    }

    public void setMudSurfDevi(String mudSurfDevi) {
        this.mudSurfDevi = mudSurfDevi == null ? null : mudSurfDevi.trim();
    }

    public String getRebarDevi() {
        return rebarDevi;
    }

    public void setRebarDevi(String rebarDevi) {
        this.rebarDevi = rebarDevi == null ? null : rebarDevi.trim();
    }

    public String getConctre() {
        return conctre;
    }

    public void setConctre(String conctre) {
        this.conctre = conctre == null ? null : conctre.trim();
    }

    public String getFillingFactor() {
        return fillingFactor;
    }

    public void setFillingFactor(String fillingFactor) {
        this.fillingFactor = fillingFactor == null ? null : fillingFactor.trim();
    }

    public String getPileTopDevi() {
        return pileTopDevi;
    }

    public void setPileTopDevi(String pileTopDevi) {
        this.pileTopDevi = pileTopDevi == null ? null : pileTopDevi.trim();
    }

    public Date getPilequalityCheckTime() {
        return pilequalityCheckTime;
    }

    public void setPilequalityCheckTime(Date pilequalityCheckTime) {
        this.pilequalityCheckTime = pilequalityCheckTime;
    }

    public Integer getIsQualify() {
        return isQualify;
    }

    public void setIsQualify(Integer isQualify) {
        this.isQualify = isQualify;
    }
}
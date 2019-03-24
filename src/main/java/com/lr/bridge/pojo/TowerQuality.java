package com.lr.bridge.pojo;

import java.util.Date;

public class TowerQuality {
    private Integer id;

    private String struId;

    private String axisDevi;

    private String crossDimeDevi;

    private String vert;

    private String coluWallThic;

    private String anchnDevi;

    private String cableAxisDevi;

    private String crossbeamDimeDevi;

    private String crossbeamTopDevi;

    private String crossbeamAxisDevi;

    private String crossbeamThicDevi;

    private String embePartsDevi;

    private String jointDisl;

    private Date towerqualityCheckTime;

    public TowerQuality(Integer id, String struId, String axisDevi, String crossDimeDevi, String vert, String coluWallThic, String anchnDevi, String cableAxisDevi, String crossbeamDimeDevi, String crossbeamTopDevi, String crossbeamAxisDevi, String crossbeamThicDevi, String embePartsDevi, String jointDisl, Date towerqualityCheckTime) {
        this.id = id;
        this.struId = struId;
        this.axisDevi = axisDevi;
        this.crossDimeDevi = crossDimeDevi;
        this.vert = vert;
        this.coluWallThic = coluWallThic;
        this.anchnDevi = anchnDevi;
        this.cableAxisDevi = cableAxisDevi;
        this.crossbeamDimeDevi = crossbeamDimeDevi;
        this.crossbeamTopDevi = crossbeamTopDevi;
        this.crossbeamAxisDevi = crossbeamAxisDevi;
        this.crossbeamThicDevi = crossbeamThicDevi;
        this.embePartsDevi = embePartsDevi;
        this.jointDisl = jointDisl;
        this.towerqualityCheckTime = towerqualityCheckTime;
    }

    public TowerQuality() {
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

    public String getAxisDevi() {
        return axisDevi;
    }

    public void setAxisDevi(String axisDevi) {
        this.axisDevi = axisDevi == null ? null : axisDevi.trim();
    }

    public String getCrossDimeDevi() {
        return crossDimeDevi;
    }

    public void setCrossDimeDevi(String crossDimeDevi) {
        this.crossDimeDevi = crossDimeDevi == null ? null : crossDimeDevi.trim();
    }

    public String getVert() {
        return vert;
    }

    public void setVert(String vert) {
        this.vert = vert == null ? null : vert.trim();
    }

    public String getColuWallThic() {
        return coluWallThic;
    }

    public void setColuWallThic(String coluWallThic) {
        this.coluWallThic = coluWallThic == null ? null : coluWallThic.trim();
    }

    public String getAnchnDevi() {
        return anchnDevi;
    }

    public void setAnchnDevi(String anchnDevi) {
        this.anchnDevi = anchnDevi == null ? null : anchnDevi.trim();
    }

    public String getCableAxisDevi() {
        return cableAxisDevi;
    }

    public void setCableAxisDevi(String cableAxisDevi) {
        this.cableAxisDevi = cableAxisDevi == null ? null : cableAxisDevi.trim();
    }

    public String getCrossbeamDimeDevi() {
        return crossbeamDimeDevi;
    }

    public void setCrossbeamDimeDevi(String crossbeamDimeDevi) {
        this.crossbeamDimeDevi = crossbeamDimeDevi == null ? null : crossbeamDimeDevi.trim();
    }

    public String getCrossbeamTopDevi() {
        return crossbeamTopDevi;
    }

    public void setCrossbeamTopDevi(String crossbeamTopDevi) {
        this.crossbeamTopDevi = crossbeamTopDevi == null ? null : crossbeamTopDevi.trim();
    }

    public String getCrossbeamAxisDevi() {
        return crossbeamAxisDevi;
    }

    public void setCrossbeamAxisDevi(String crossbeamAxisDevi) {
        this.crossbeamAxisDevi = crossbeamAxisDevi == null ? null : crossbeamAxisDevi.trim();
    }

    public String getCrossbeamThicDevi() {
        return crossbeamThicDevi;
    }

    public void setCrossbeamThicDevi(String crossbeamThicDevi) {
        this.crossbeamThicDevi = crossbeamThicDevi == null ? null : crossbeamThicDevi.trim();
    }

    public String getEmbePartsDevi() {
        return embePartsDevi;
    }

    public void setEmbePartsDevi(String embePartsDevi) {
        this.embePartsDevi = embePartsDevi == null ? null : embePartsDevi.trim();
    }

    public String getJointDisl() {
        return jointDisl;
    }

    public void setJointDisl(String jointDisl) {
        this.jointDisl = jointDisl == null ? null : jointDisl.trim();
    }

    public Date getTowerqualityCheckTime() {
        return towerqualityCheckTime;
    }

    public void setTowerqualityCheckTime(Date towerqualityCheckTime) {
        this.towerqualityCheckTime = towerqualityCheckTime;
    }
}
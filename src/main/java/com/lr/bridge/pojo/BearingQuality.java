package com.lr.bridge.pojo;

import java.util.Date;

public class BearingQuality {
    private Integer id;

    private String struId;

    private String upCentVert;

    private String downCentTran;

    private String sameCentVert;

    private String sameRela;

    private String edgeHeig;

    private String crossLineTors;

    private String actiVert;

    private Date bearingqualityCheckTime;

    public BearingQuality(Integer id, String struId, String upCentVert, String downCentTran, String sameCentVert, String sameRela, String edgeHeig, String crossLineTors, String actiVert, Date bearingqualityCheckTime) {
        this.id = id;
        this.struId = struId;
        this.upCentVert = upCentVert;
        this.downCentTran = downCentTran;
        this.sameCentVert = sameCentVert;
        this.sameRela = sameRela;
        this.edgeHeig = edgeHeig;
        this.crossLineTors = crossLineTors;
        this.actiVert = actiVert;
        this.bearingqualityCheckTime = bearingqualityCheckTime;
    }

    public BearingQuality() {
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

    public String getUpCentVert() {
        return upCentVert;
    }

    public void setUpCentVert(String upCentVert) {
        this.upCentVert = upCentVert == null ? null : upCentVert.trim();
    }

    public String getDownCentTran() {
        return downCentTran;
    }

    public void setDownCentTran(String downCentTran) {
        this.downCentTran = downCentTran == null ? null : downCentTran.trim();
    }

    public String getSameCentVert() {
        return sameCentVert;
    }

    public void setSameCentVert(String sameCentVert) {
        this.sameCentVert = sameCentVert == null ? null : sameCentVert.trim();
    }

    public String getSameRela() {
        return sameRela;
    }

    public void setSameRela(String sameRela) {
        this.sameRela = sameRela == null ? null : sameRela.trim();
    }

    public String getEdgeHeig() {
        return edgeHeig;
    }

    public void setEdgeHeig(String edgeHeig) {
        this.edgeHeig = edgeHeig == null ? null : edgeHeig.trim();
    }

    public String getCrossLineTors() {
        return crossLineTors;
    }

    public void setCrossLineTors(String crossLineTors) {
        this.crossLineTors = crossLineTors == null ? null : crossLineTors.trim();
    }

    public String getActiVert() {
        return actiVert;
    }

    public void setActiVert(String actiVert) {
        this.actiVert = actiVert == null ? null : actiVert.trim();
    }

    public Date getBearingqualityCheckTime() {
        return bearingqualityCheckTime;
    }

    public void setBearingqualityCheckTime(Date bearingqualityCheckTime) {
        this.bearingqualityCheckTime = bearingqualityCheckTime;
    }
}
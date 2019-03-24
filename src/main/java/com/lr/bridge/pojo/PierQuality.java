package com.lr.bridge.pojo;

import java.util.Date;

public class PierQuality {
    private Integer id;

    private String struId;

    private String length;

    private String width;

    private String topElev;

    private String axisOffs;

    private String vert;

    private String surfVert;

    private String planeness;

    private String inteFaultTable;

    private Date pierqualityCheckTime;

    public PierQuality(Integer id, String struId, String length, String width, String topElev, String axisOffs, String vert, String surfVert, String planeness, String inteFaultTable, Date pierqualityCheckTime) {
        this.id = id;
        this.struId = struId;
        this.length = length;
        this.width = width;
        this.topElev = topElev;
        this.axisOffs = axisOffs;
        this.vert = vert;
        this.surfVert = surfVert;
        this.planeness = planeness;
        this.inteFaultTable = inteFaultTable;
        this.pierqualityCheckTime = pierqualityCheckTime;
    }

    public PierQuality() {
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

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length == null ? null : length.trim();
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width == null ? null : width.trim();
    }

    public String getTopElev() {
        return topElev;
    }

    public void setTopElev(String topElev) {
        this.topElev = topElev == null ? null : topElev.trim();
    }

    public String getAxisOffs() {
        return axisOffs;
    }

    public void setAxisOffs(String axisOffs) {
        this.axisOffs = axisOffs == null ? null : axisOffs.trim();
    }

    public String getVert() {
        return vert;
    }

    public void setVert(String vert) {
        this.vert = vert == null ? null : vert.trim();
    }

    public String getSurfVert() {
        return surfVert;
    }

    public void setSurfVert(String surfVert) {
        this.surfVert = surfVert == null ? null : surfVert.trim();
    }

    public String getPlaneness() {
        return planeness;
    }

    public void setPlaneness(String planeness) {
        this.planeness = planeness == null ? null : planeness.trim();
    }

    public String getInteFaultTable() {
        return inteFaultTable;
    }

    public void setInteFaultTable(String inteFaultTable) {
        this.inteFaultTable = inteFaultTable == null ? null : inteFaultTable.trim();
    }

    public Date getPierqualityCheckTime() {
        return pierqualityCheckTime;
    }

    public void setPierqualityCheckTime(Date pierqualityCheckTime) {
        this.pierqualityCheckTime = pierqualityCheckTime;
    }
}
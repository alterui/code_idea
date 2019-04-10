package com.lr.bridge.pojo;

import java.util.Date;

public class EnvProtection {
    private Integer id;

    private String cbdw;

    private String bdh;

    private String jldw;

    private String bh;

    private String sqbmz;

    private String zjb;

    private String gcmz;

    private String cbr;

    private String zjyj;

    private String hbzxyj;

    private Date sqsj;

    public EnvProtection(Integer id, String cbdw, String bdh, String jldw, String bh, String sqbmz, String zjb, String gcmz, String cbr, String zjyj, String hbzxyj, Date sqsj) {
        this.id = id;
        this.cbdw = cbdw;
        this.bdh = bdh;
        this.jldw = jldw;
        this.bh = bh;
        this.sqbmz = sqbmz;
        this.zjb = zjb;
        this.gcmz = gcmz;
        this.cbr = cbr;
        this.zjyj = zjyj;
        this.hbzxyj = hbzxyj;
        this.sqsj = sqsj;
    }

    public EnvProtection() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCbdw() {
        return cbdw;
    }

    public void setCbdw(String cbdw) {
        this.cbdw = cbdw == null ? null : cbdw.trim();
    }

    public String getBdh() {
        return bdh;
    }

    public void setBdh(String bdh) {
        this.bdh = bdh == null ? null : bdh.trim();
    }

    public String getJldw() {
        return jldw;
    }

    public void setJldw(String jldw) {
        this.jldw = jldw == null ? null : jldw.trim();
    }

    public String getBh() {
        return bh;
    }

    public void setBh(String bh) {
        this.bh = bh == null ? null : bh.trim();
    }

    public String getSqbmz() {
        return sqbmz;
    }

    public void setSqbmz(String sqbmz) {
        this.sqbmz = sqbmz == null ? null : sqbmz.trim();
    }

    public String getZjb() {
        return zjb;
    }

    public void setZjb(String zjb) {
        this.zjb = zjb == null ? null : zjb.trim();
    }

    public String getGcmz() {
        return gcmz;
    }

    public void setGcmz(String gcmz) {
        this.gcmz = gcmz == null ? null : gcmz.trim();
    }

    public String getCbr() {
        return cbr;
    }

    public void setCbr(String cbr) {
        this.cbr = cbr == null ? null : cbr.trim();
    }

    public String getZjyj() {
        return zjyj;
    }

    public void setZjyj(String zjyj) {
        this.zjyj = zjyj == null ? null : zjyj.trim();
    }

    public String getHbzxyj() {
        return hbzxyj;
    }

    public void setHbzxyj(String hbzxyj) {
        this.hbzxyj = hbzxyj == null ? null : hbzxyj.trim();
    }

    public Date getSqsj() {
        return sqsj;
    }

    public void setSqsj(Date sqsj) {
        this.sqsj = sqsj;
    }
}
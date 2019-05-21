package com.lr.bridge.vo;

/**
 * Created by ALTERUI on 2019/4/8 20:47
 */
public class EntityCountDate {
    private int isQualify;
    private int count;



    public EntityCountDate(int isQuality, int count) {
        this.isQualify = isQuality;
        this.count = count;
    }
    public EntityCountDate() {
        super();
    }

    public int getIsQuality() {
        return isQualify;
    }

    public void setIsQuality(int isQuality) {
        this.isQualify = isQuality;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
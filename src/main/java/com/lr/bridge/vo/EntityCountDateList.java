package com.lr.bridge.vo;

import java.util.List;

/**
 * Created by ALTERUI on 2019/4/8 20:45
 */
public class EntityCountDateList {

    private String checkTime;
    private List<EntityCountDate> entityCounts;

    public EntityCountDateList() {
        super();
    }

    public EntityCountDateList(String checkTime, List<EntityCountDate> entityCounts) {
        this.checkTime = checkTime;
        this.entityCounts = entityCounts;
    }

    public String getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(String checkTime) {
        this.checkTime = checkTime;
    }

    public List<EntityCountDate> getEntityCounts() {
        return entityCounts;
    }

    public void setEntityCounts(List<EntityCountDate> entityCounts) {
        this.entityCounts = entityCounts;
    }


}

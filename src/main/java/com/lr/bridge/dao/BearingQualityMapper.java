package com.lr.bridge.dao;

import com.lr.bridge.pojo.BearingQuality;

public interface BearingQualityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BearingQuality record);

    int insertSelective(BearingQuality record);

    BearingQuality selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BearingQuality record);

    int updateByPrimaryKey(BearingQuality record);
}
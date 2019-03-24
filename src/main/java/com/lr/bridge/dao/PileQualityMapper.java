package com.lr.bridge.dao;

import com.lr.bridge.pojo.PileQuality;

public interface PileQualityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PileQuality record);

    int insertSelective(PileQuality record);

    PileQuality selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PileQuality record);

    int updateByPrimaryKey(PileQuality record);
}
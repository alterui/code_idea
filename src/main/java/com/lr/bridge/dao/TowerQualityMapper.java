package com.lr.bridge.dao;

import com.lr.bridge.pojo.TowerQuality;

public interface TowerQualityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TowerQuality record);

    int insertSelective(TowerQuality record);

    TowerQuality selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TowerQuality record);

    int updateByPrimaryKey(TowerQuality record);
}
package com.lr.bridge.dao;

import com.lr.bridge.pojo.BeamQuality;

public interface BeamQualityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BeamQuality record);

    int insertSelective(BeamQuality record);

    BeamQuality selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BeamQuality record);

    int updateByPrimaryKey(BeamQuality record);
}
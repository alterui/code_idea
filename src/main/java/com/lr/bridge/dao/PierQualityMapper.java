package com.lr.bridge.dao;

import com.lr.bridge.pojo.PierQuality;

public interface PierQualityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PierQuality record);

    int insertSelective(PierQuality record);

    PierQuality selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PierQuality record);

    int updateByPrimaryKey(PierQuality record);
}
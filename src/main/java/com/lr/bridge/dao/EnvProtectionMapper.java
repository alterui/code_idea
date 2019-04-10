package com.lr.bridge.dao;

import com.lr.bridge.pojo.EnvProtection;

import java.util.List;

public interface EnvProtectionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(EnvProtection record);

    int insertSelective(EnvProtection record);

    EnvProtection selectByPrimaryKey(Integer id);

    List<EnvProtection> selectAll();

    int updateByPrimaryKeySelective(EnvProtection record);

    int updateByPrimaryKey(EnvProtection record);
}
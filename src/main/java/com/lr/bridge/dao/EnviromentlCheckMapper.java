package com.lr.bridge.dao;

import com.lr.bridge.pojo.EnviromentlCheck;

public interface EnviromentlCheckMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(EnviromentlCheck record);

    int insertSelective(EnviromentlCheck record);

    EnviromentlCheck selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EnviromentlCheck record);

    int updateByPrimaryKey(EnviromentlCheck record);
}
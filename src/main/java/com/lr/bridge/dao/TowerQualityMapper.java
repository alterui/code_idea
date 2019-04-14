package com.lr.bridge.dao;

import com.lr.bridge.pojo.TowerQuality;
import com.lr.bridge.pojo.TowerQuality;
import com.lr.bridge.vo.EntityCountDateList;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TowerQualityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TowerQuality record);

    int insertSelective(TowerQuality record);

    TowerQuality selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TowerQuality record);

    int updateByPrimaryKey(TowerQuality record);




    List<TowerQuality> findAll(Integer isQualify);


    int updateByIsQualify(@Param("isQualify") int isQualify, @Param("id") int id);

    List<TowerQuality> selectById();

    List<TowerQuality> selectByHasQuality();

    List<TowerQuality> selectByLikeName(String name);

    List<TowerQuality> selectByLikeNameAndQuality(String name);
    List<TowerQuality> selectByLikeNameAndNotQuality(String name);

    List<EntityCountDateList> getIsQualityCountByDate(@Param("start") String start, @Param("end") String end);

}
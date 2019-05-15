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

    List<TowerQuality> selectByDate(@Param("start") String start, @Param("end") String end);

    List<TowerQuality> selectQualityByDate(@Param("isQualify") int isQualify, @Param("start") String start, @Param("end") String end);

    List<TowerQuality> selectHasQualityByDate(@Param("start") String start, @Param("end") String end);


    int selectCountByDate(@Param("start") String start, @Param("end") String end, @Param("isQualify") int isQualify);

    List<TowerQuality> selectByDateAll(@Param("start") String start,@Param("end") String end);




}
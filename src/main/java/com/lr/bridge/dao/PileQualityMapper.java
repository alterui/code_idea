package com.lr.bridge.dao;

import com.lr.bridge.pojo.PileQuality;
import com.lr.bridge.pojo.PileQuality;
import com.lr.bridge.vo.EntityCountDateList;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PileQualityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PileQuality record);

    int insertSelective(PileQuality record);

    PileQuality selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PileQuality record);

    int updateByPrimaryKey(PileQuality record);




    List<PileQuality> findAll(Integer isQualify);


    int updateByIsQualify(@Param("isQualify") int isQualify, @Param("id") int id);

    List<PileQuality> selectById();

    List<PileQuality> selectByHasQuality();

    List<PileQuality> selectByLikeName(String name);

    List<PileQuality> selectByLikeNameAndQuality(String name);
    List<PileQuality> selectByLikeNameAndNotQuality(String name);

    List<EntityCountDateList> getIsQualityCountByDate(@Param("start") String start, @Param("end") String end);

    List<PileQuality> selectByDate(@Param("start") String start, @Param("end") String end);

    List<PileQuality> selectQualityByDate(@Param("isQualify") int isQualify, @Param("start") String start, @Param("end") String end);

    List<PileQuality> selectHasQualityByDate(@Param("start") String start, @Param("end") String end);



}
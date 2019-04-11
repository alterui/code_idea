package com.lr.bridge.dao;

import com.lr.bridge.pojo.BeamQuality;
import com.lr.bridge.vo.EntityCountDateList;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BeamQualityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BeamQuality record);

    int insertSelective(BeamQuality record);

    BeamQuality selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BeamQuality record);

    int updateByPrimaryKey(BeamQuality record);



    //

    List<BeamQuality> findAll(Integer isQualify);


    int updateByIsQualify(@Param("isQualify") int isQualify, @Param("id") int id);

    List<BeamQuality> selectById();

    List<BeamQuality> selectByHasQuality();

    List<BeamQuality> selectByLikeName(String name);

    List<BeamQuality> selectByLikeNameAndQuality(String name);
    List<BeamQuality> selectByLikeNameAndNotQuality(String name);

    List<EntityCountDateList> getIsQualityCountByDate(@Param("start") String start, @Param("end") String end);

}
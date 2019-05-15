package com.lr.bridge.dao;

import com.lr.bridge.pojo.PierQuality;
import com.lr.bridge.pojo.PierQuality;
import com.lr.bridge.vo.EntityCountDateList;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PierQualityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PierQuality record);

    int insertSelective(PierQuality record);

    PierQuality selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PierQuality record);

    int updateByPrimaryKey(PierQuality record);




    List<PierQuality> findAll(Integer isQualify);


    int updateByIsQualify(@Param("isQualify") int isQualify, @Param("id") int id);

    List<PierQuality> selectById();

    List<PierQuality> selectByHasQuality();

    List<PierQuality> selectByLikeName(String name);

    List<PierQuality> selectByLikeNameAndQuality(String name);
    List<PierQuality> selectByLikeNameAndNotQuality(String name);

    List<EntityCountDateList> getIsQualityCountByDate(@Param("start") String start, @Param("end") String end);

    List<PierQuality> selectByDate(@Param("start") String start, @Param("end") String end);

    List<PierQuality> selectQualityByDate(@Param("isQualify") int isQualify, @Param("start") String start, @Param("end") String end);

    List<PierQuality> selectHasQualityByDate(@Param("start") String start, @Param("end") String end);


    int selectCountByDate(@Param("start") String start, @Param("end") String end, @Param("isQualify") int isQualify);

    List<PierQuality> selectByDateAll(@Param("start") String start,@Param("end") String end);


}
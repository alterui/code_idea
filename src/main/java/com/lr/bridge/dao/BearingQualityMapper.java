package com.lr.bridge.dao;

import com.lr.bridge.pojo.BearingQuality;
import com.lr.bridge.vo.EntityCountDate;
import com.lr.bridge.vo.EntityCountDateList;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Map;

@Repository
public interface BearingQualityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BearingQuality record);

    int insertSelective(BearingQuality record);

    BearingQuality selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BearingQuality record);

    int updateByPrimaryKey(BearingQuality record);

    List<BearingQuality> findAll(Integer isQualify);


    int updateByIsQualify(@Param("isQualify") int isQualify, @Param("id") int id);

    List<BearingQuality> selectById();

    List<BearingQuality> selectByHasQuality();

    List<BearingQuality> selectByLikeName(String name);

    List<BearingQuality> selectByLikeNameAndQuality(String name);
    List<BearingQuality> selectByLikeNameAndNotQuality(String name);

    List<EntityCountDateList> getIsQualityCountByDate(@Param("start") String start,@Param("end") String end);

    List<BearingQuality> selectByDate(@Param("start") String start,@Param("end") String end);

}
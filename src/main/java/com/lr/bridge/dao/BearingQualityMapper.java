package com.lr.bridge.dao;

import com.lr.bridge.pojo.BearingQuality;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

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


}
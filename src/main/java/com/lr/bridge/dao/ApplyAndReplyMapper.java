package com.lr.bridge.dao;

import com.lr.bridge.pojo.ApplyAndReply;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ApplyAndReplyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ApplyAndReply record);

    int insertSelective(ApplyAndReply record);

    ApplyAndReply selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ApplyAndReply record);

    int updateByPrimaryKey(ApplyAndReply record);

    List<ApplyAndReply> selectAll();

    List<ApplyAndReply> selectByDate(@Param("start") String start, @Param("end") String end);

}
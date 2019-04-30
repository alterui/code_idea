package com.lr.bridge.service;

import com.github.pagehelper.PageInfo;
import com.lr.bridge.pojo.ApplyAndReply;


/**
 * Created by ALTERUI on 2019/4/10 20:05
 */
public interface ApplyAndReplyService {
    PageInfo<ApplyAndReply> showAllApplyAndReply(Integer pageIndex,
                                                 Integer pageSize);

    ApplyAndReply selectByPrimaryKey(Integer id);

    int insert(ApplyAndReply record);

    int deleteByPrimaryKey(Integer id);

    int updateByPrimaryKey(ApplyAndReply record);


    PageInfo<ApplyAndReply> selectByDate(String start, String end,Integer pageIndex, Integer pageSize);

}

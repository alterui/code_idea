package com.lr.bridge.service;

import com.github.pagehelper.PageInfo;
import com.lr.bridge.pojo.ApplyAndReply;

import java.util.Date;
import java.util.List;


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


    PageInfo<ApplyAndReply> selectByDate(String start, String end, Integer pageIndex, Integer pageSize);
    PageInfo<ApplyAndReply> selectByAuditDate(String start, String end, Integer pageIndex, Integer pageSize);
    PageInfo<ApplyAndReply> selectByHasAuditDate(String start, String end, Integer pageIndex, Integer pageSize);

    PageInfo<ApplyAndReply> showNotAudit(Integer pageIndex, Integer pageSize);

    PageInfo<ApplyAndReply> showHasAudit(Integer pageIndex,Integer pageSize);

    int updateByViewAndDate(String centerName, String centerView, Date centerReplyTime, Integer id);

    PageInfo<ApplyAndReply> selectByAllFormName(String name,Integer pageIndex,
                                              Integer pageSize);

    PageInfo<ApplyAndReply> selectByAuditFormName(String name,Integer pageIndex,
                                                Integer pageSize);

    PageInfo<ApplyAndReply> selectByHasAuditFormName(String name,Integer pageIndex,
                                                Integer pageSize);


}

package com.lr.bridge.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lr.bridge.dao.ApplyAndReplyMapper;
import com.lr.bridge.pojo.ApplyAndReply;
import com.lr.bridge.service.ApplyAndReplyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by ALTERUI on 2019/4/10 20:06
 */
@Service
public class ApplyAndReplyServiceImpl implements ApplyAndReplyService {

    @Resource
    private ApplyAndReplyMapper applyAndReplyMapper;

    @Override
    public PageInfo<ApplyAndReply> showAllApplyAndReply(Integer pageIndex, Integer pageSize) {
        PageHelper.startPage(pageIndex, pageSize);
        List<ApplyAndReply> articleList = applyAndReplyMapper.selectAll();

        return new PageInfo<>(articleList);
    }

    @Override
    public int insert(ApplyAndReply record) {
        return applyAndReplyMapper.insert(record);
    }

    @Override
    public ApplyAndReply selectByPrimaryKey(Integer id) {
        return applyAndReplyMapper.selectByPrimaryKey(id);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return applyAndReplyMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKey(ApplyAndReply record) {
        return applyAndReplyMapper.updateByPrimaryKey(record);
    }


    @Override
    public PageInfo<ApplyAndReply> selectByDate(String start, String end, Integer pageIndex, Integer pageSize) {
        PageHelper.startPage(pageIndex, pageSize);
        List<ApplyAndReply> ApplyAndReplyList = applyAndReplyMapper.selectByDate(start, end);
        return new PageInfo<ApplyAndReply>(ApplyAndReplyList);

    }


    @Override
    public PageInfo<ApplyAndReply> selectByAuditDate(String start, String end, Integer pageIndex, Integer pageSize) {
        PageHelper.startPage(pageIndex, pageSize);
        List<ApplyAndReply> ApplyAndReplyList = applyAndReplyMapper.selectByAuditDate(start, end);
        return new PageInfo<ApplyAndReply>(ApplyAndReplyList);
    }

    @Override
    public PageInfo<ApplyAndReply> selectByHasAuditDate(String start, String end, Integer pageIndex, Integer pageSize) {
        PageHelper.startPage(pageIndex, pageSize);
        List<ApplyAndReply> ApplyAndReplyList = applyAndReplyMapper.selectByHasAuditDate(start, end);
        return new PageInfo<ApplyAndReply>(ApplyAndReplyList);
    }

    @Override
    public PageInfo<ApplyAndReply> showNotAudit(Integer pageIndex, Integer pageSize) {
        PageHelper.startPage(pageIndex, pageSize);
        List<ApplyAndReply> articleList = applyAndReplyMapper.selectNotAudit();

        return new PageInfo<>(articleList);
    }


    @Override
    public PageInfo<ApplyAndReply> showHasAudit(Integer pageIndex, Integer pageSize) {
        PageHelper.startPage(pageIndex, pageSize);
        List<ApplyAndReply> articleList = applyAndReplyMapper.selectHasAudit();

        return new PageInfo<>(articleList);
    }


    @Override
    public int updateByViewAndDate(String centerName,String centerView, Date centerReplyTime, Integer id) {
        return applyAndReplyMapper.updateByViewAndDate(centerName,centerView, centerReplyTime, id);
    }


    @Override
    public PageInfo<ApplyAndReply> selectByAllFormName(String name, Integer pageIndex, Integer pageSize) {
        PageHelper.startPage(pageIndex, pageSize);
        List<ApplyAndReply> bearingQualityList = applyAndReplyMapper.selectByAllFormName(name);
        return new PageInfo<ApplyAndReply>(bearingQualityList);
    }


    @Override
    public PageInfo<ApplyAndReply> selectByAuditFormName(String name, Integer pageIndex, Integer pageSize) {
        PageHelper.startPage(pageIndex, pageSize);
        List<ApplyAndReply> bearingQualityList = applyAndReplyMapper.selectByAuditFormName(name);
        return new PageInfo<ApplyAndReply>(bearingQualityList);
    }

    @Override
    public PageInfo<ApplyAndReply> selectByHasAuditFormName(String name, Integer pageIndex, Integer pageSize) {
        PageHelper.startPage(pageIndex, pageSize);
        List<ApplyAndReply> bearingQualityList = applyAndReplyMapper.selectByHasAuditFormName(name);
        return new PageInfo<ApplyAndReply>(bearingQualityList);
    }
}

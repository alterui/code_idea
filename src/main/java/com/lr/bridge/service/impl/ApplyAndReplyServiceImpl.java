package com.lr.bridge.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lr.bridge.dao.ApplyAndReplyMapper;
import com.lr.bridge.pojo.ApplyAndReply;
import com.lr.bridge.service.ApplyAndReplyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
    public ApplyAndReply selectByPrimaryKey(Integer id) {
        return applyAndReplyMapper.selectByPrimaryKey(id);
    }

}

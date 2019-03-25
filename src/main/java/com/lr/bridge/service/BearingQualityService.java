package com.lr.bridge.service;

import com.github.pagehelper.PageInfo;
import com.lr.bridge.pojo.BearingQuality;

import java.util.HashMap;

/**
 * Created by ALTERUI on 2019/3/25 16:44
 */
public interface BearingQualityService {


    /**
     * 分页显示
     *
     * @param pageIndex 第几页开始
     * @param pageSize  一页显示多少
     * @return 支座列表
     */
    PageInfo<BearingQuality> pageArticle(Integer pageIndex,
                                         Integer pageSize);
}

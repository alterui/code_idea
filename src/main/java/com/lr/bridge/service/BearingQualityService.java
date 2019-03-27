package com.lr.bridge.service;

import com.github.pagehelper.PageInfo;
import com.lr.bridge.pojo.BearingQuality;

import java.util.HashMap;
import java.util.List;

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


    PageInfo<BearingQuality> showBear(Integer pageIndex,
                                         Integer pageSize);

    int updateByIsQualify(int isQualify, int id);

    List<BearingQuality> getBearingStruId();

    int deleteById(Integer id);

    BearingQuality selectByPrimaryKey(Integer id);

    int insert(BearingQuality record);

    int updateByPrimaryKey(BearingQuality record);
}

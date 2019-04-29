package com.lr.bridge.service;

import com.github.pagehelper.PageInfo;
import com.lr.bridge.pojo.BearingQuality;
import com.lr.bridge.vo.EntityCountDate;
import com.lr.bridge.vo.EntityCountDateList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ALTERUI on 2019/3/25 16:44
 */
public interface BearingQualityService {


    /**
     * 显示待质量验收的
     *
     * @param pageIndex 第几页开始
     * @param pageSize  一页显示多少
     * @return 支座列表
     */
    PageInfo<BearingQuality> showQuality(Integer pageIndex,
                                         Integer pageSize);

    PageInfo<BearingQuality> selectByHasQuality(Integer pageIndex,
                                         Integer pageSize);


    PageInfo<BearingQuality> showBear(Integer pageIndex,
                                         Integer pageSize);

    int updateByIsQualify(int isQualify, int id);

    List<BearingQuality> getBearingStruId();

    int deleteById(Integer id);

    BearingQuality selectByPrimaryKey(Integer id);

    int insert(BearingQuality record);

    int updateByPrimaryKey(BearingQuality record);

    PageInfo<BearingQuality> selectByLikeName(String name,Integer pageIndex,
                                              Integer pageSize);

    PageInfo<BearingQuality> selectByLikeNameAndQuality(String name,Integer pageIndex,
                                              Integer pageSize);

    PageInfo<BearingQuality> selectByLikeNameAndNotQuality(String name,Integer pageIndex,
                                                        Integer pageSize);


    List<EntityCountDateList> getIsQualityCountByDate(String start,String end);

    PageInfo<BearingQuality> selectByDate(String start, String end, Integer pageIndex, Integer pageSize);

    PageInfo<BearingQuality> selectQualityByDate(int isQualify, String start, String end, Integer pageIndex, Integer pageSize);

    PageInfo<BearingQuality> selectHasQualityByDate(String start, String end, Integer pageIndex, Integer pageSize);




}

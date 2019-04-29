package com.lr.bridge.service;

import com.github.pagehelper.PageInfo;
import com.lr.bridge.pojo.TowerQuality;
import com.lr.bridge.vo.EntityCountDateList;

import java.util.List;

/**
 * Created by ALTERUI on 2019/3/25 16:44
 */
public interface TowerQualityService {


    /**
     * 显示待质量验收的
     *
     * @param pageIndex 第几页开始
     * @param pageSize  一页显示多少
     * @return 支座列表
     */
    PageInfo<TowerQuality> showQuality(Integer pageIndex,
                                      Integer pageSize);

    PageInfo<TowerQuality> selectByHasQuality(Integer pageIndex,
                                             Integer pageSize);


    PageInfo<TowerQuality> showTower(Integer pageIndex,
                                   Integer pageSize);

    int updateByIsQualify(int isQualify, int id);

    List<TowerQuality> getTowerStruId();

    int deleteById(Integer id);

    TowerQuality selectByPrimaryKey(Integer id);

    int insert(TowerQuality record);

    int updateByPrimaryKey(TowerQuality record);

    PageInfo<TowerQuality> selectByLikeName(String name, Integer pageIndex,
                                           Integer pageSize);

    PageInfo<TowerQuality> selectByLikeNameAndQuality(String name, Integer pageIndex,
                                                     Integer pageSize);

    PageInfo<TowerQuality> selectByLikeNameAndNotQuality(String name, Integer pageIndex,
                                                        Integer pageSize);


    List<EntityCountDateList> getIsQualityCountByDate(String start, String end);

    PageInfo<TowerQuality> selectByDate(String start, String end, Integer pageIndex, Integer pageSize);

    PageInfo<TowerQuality> selectQualityByDate(int isQualify, String start, String end, Integer pageIndex, Integer pageSize);

    PageInfo<TowerQuality> selectHasQualityByDate(String start, String end, Integer pageIndex, Integer pageSize);




}

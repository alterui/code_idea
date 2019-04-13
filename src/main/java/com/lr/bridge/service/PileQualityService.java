package com.lr.bridge.service;

import com.github.pagehelper.PageInfo;
import com.lr.bridge.pojo.PileQuality;
import com.lr.bridge.vo.EntityCountDateList;

import java.util.List;

/**
 * Created by ALTERUI on 2019/3/25 16:44
 */
public interface PileQualityService {


    /**
     * 显示待质量验收的
     *
     * @param pageIndex 第几页开始
     * @param pageSize  一页显示多少
     * @return 支座列表
     */
    PageInfo<PileQuality> showQuality(Integer pageIndex,
                                      Integer pageSize);

    PageInfo<PileQuality> selectByHasQuality(Integer pageIndex,
                                             Integer pageSize);


    PageInfo<PileQuality> showPile(Integer pageIndex,
                                   Integer pageSize);

    int updateByIsQualify(int isQualify, int id);

    List<PileQuality> getPileStruId();

    int deleteById(Integer id);

    PileQuality selectByPrimaryKey(Integer id);

    int insert(PileQuality record);

    int updateByPrimaryKey(PileQuality record);

    PageInfo<PileQuality> selectByLikeName(String name, Integer pageIndex,
                                           Integer pageSize);

    PageInfo<PileQuality> selectByLikeNameAndQuality(String name, Integer pageIndex,
                                                     Integer pageSize);

    PageInfo<PileQuality> selectByLikeNameAndNotQuality(String name, Integer pageIndex,
                                                        Integer pageSize);


    List<EntityCountDateList> getIsQualityCountByDate(String start, String end);


}

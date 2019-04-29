package com.lr.bridge.service;

import com.github.pagehelper.PageInfo;
import com.lr.bridge.pojo.PierQuality;
import com.lr.bridge.vo.EntityCountDateList;

import java.util.List;

/**
 * Created by ALTERUI on 2019/3/25 16:44
 */
public interface PierQualityService {


    /**
     * 显示待质量验收的
     *
     * @param pageIndex 第几页开始
     * @param pageSize  一页显示多少
     * @return 支座列表
     */
    PageInfo<PierQuality> showQuality(Integer pageIndex,
                                      Integer pageSize);

    PageInfo<PierQuality> selectByHasQuality(Integer pageIndex,
                                             Integer pageSize);


    PageInfo<PierQuality> showPier(Integer pageIndex,
                                   Integer pageSize);

    int updateByIsQualify(int isQualify, int id);

    List<PierQuality> getPierStruId();

    int deleteById(Integer id);

    PierQuality selectByPrimaryKey(Integer id);

    int insert(PierQuality record);

    int updateByPrimaryKey(PierQuality record);

    PageInfo<PierQuality> selectByLikeName(String name, Integer pageIndex,
                                           Integer pageSize);

    PageInfo<PierQuality> selectByLikeNameAndQuality(String name, Integer pageIndex,
                                                     Integer pageSize);

    PageInfo<PierQuality> selectByLikeNameAndNotQuality(String name, Integer pageIndex,
                                                        Integer pageSize);


    List<EntityCountDateList> getIsQualityCountByDate(String start, String end);

    PageInfo<PierQuality> selectByDate(String start, String end,Integer pageIndex, Integer pageSize);

    PageInfo<PierQuality> selectQualityByDate(int isQualify, String start, String end, Integer pageIndex, Integer pageSize);

    PageInfo<PierQuality> selectHasQualityByDate(String start, String end, Integer pageIndex, Integer pageSize);


}

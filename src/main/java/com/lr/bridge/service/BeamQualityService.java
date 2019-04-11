package com.lr.bridge.service;

import com.github.pagehelper.PageInfo;
import com.lr.bridge.pojo.BeamQuality;
import com.lr.bridge.vo.EntityCountDateList;
import java.util.List;

/**
 * Created by ALTERUI on 2019/3/25 16:44
 */
public interface BeamQualityService {


    /**
     * 显示待质量验收的
     *
     * @param pageIndex 第几页开始
     * @param pageSize  一页显示多少
     * @return 支座列表
     */
    PageInfo<BeamQuality> showQuality(Integer pageIndex,
                                      Integer pageSize);

    PageInfo<BeamQuality> selectByHasQuality(Integer pageIndex,
                                                Integer pageSize);


    PageInfo<BeamQuality> showBeam(Integer pageIndex,
                                      Integer pageSize);

    int updateByIsQualify(int isQualify, int id);

    List<BeamQuality> getBeamStruId();

    int deleteById(Integer id);

    BeamQuality selectByPrimaryKey(Integer id);

    int insert(BeamQuality record);

    int updateByPrimaryKey(BeamQuality record);

    PageInfo<BeamQuality> selectByLikeName(String name, Integer pageIndex,
                                              Integer pageSize);

    PageInfo<BeamQuality> selectByLikeNameAndQuality(String name, Integer pageIndex,
                                                        Integer pageSize);

    PageInfo<BeamQuality> selectByLikeNameAndNotQuality(String name, Integer pageIndex,
                                                           Integer pageSize);


    List<EntityCountDateList> getIsQualityCountByDate(String start, String end);


}

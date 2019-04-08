package com.lr.bridge.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lr.bridge.dao.BearingQualityMapper;
import com.lr.bridge.pojo.BearingQuality;
import com.lr.bridge.service.BearingQualityService;
import com.lr.bridge.vo.EntityCountDate;
import com.lr.bridge.vo.EntityCountDateList;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ALTERUI on 2019/3/25 16:52
 */
@Service
public class BearingQualityServiceImpl implements BearingQualityService {



    @Resource
    private BearingQualityMapper bearingQualityMapper;

    /**
     * 显示已经确认
     * @param pageIndex
     * @param pageSize
     * @return
     */
    @Override
    public PageInfo<BearingQuality> selectByHasQuality(Integer pageIndex, Integer pageSize) {
        PageHelper.startPage(pageIndex, pageSize);
        List<BearingQuality> articleList = bearingQualityMapper.selectByHasQuality();

        return new PageInfo<BearingQuality>(articleList);
    }

    @Override
    public PageInfo<BearingQuality> showQuality(Integer pageIndex,
                                                Integer pageSize) {

        PageHelper.startPage(pageIndex, pageSize);
        List<BearingQuality> articleList = bearingQualityMapper.findAll(-1);

        return new PageInfo<BearingQuality>(articleList);


    }

    /**
     * 支座分页显示
     * @param pageIndex
     * @param pageSize
     * @return
     */
    @Override
    public PageInfo<BearingQuality> showBear(Integer pageIndex, Integer pageSize) {
        PageHelper.startPage(pageIndex, pageSize);
        List<BearingQuality> bearingQualityList = bearingQualityMapper.selectById();
        return new PageInfo<BearingQuality>(bearingQualityList);
    }


    @Override
    public List<BearingQuality> getBearingStruId() {
        return bearingQualityMapper.selectById();
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @Override
    public int deleteById(Integer id) {
        return bearingQualityMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateByIsQualify(int isQualify, int id) {
       return bearingQualityMapper.updateByIsQualify(isQualify, id);
    }


    @Override
    public  List<EntityCountDateList> getIsQualityCountByDate() {
        return bearingQualityMapper.getIsQualityCountByDate();
    }

    public BearingQuality selectByPrimaryKey(Integer id){
        return bearingQualityMapper.selectByPrimaryKey(id);
    }

     public int insert(BearingQuality record){
         return bearingQualityMapper.insert(record);
     }

    public int updateByPrimaryKey(BearingQuality record){
        return bearingQualityMapper.updateByPrimaryKey(record);
    }

    public PageInfo<BearingQuality> selectByLikeName(String name, Integer pageIndex, Integer pageSize) {
        PageHelper.startPage(pageIndex, pageSize);
        List<BearingQuality> bearingQualityList = bearingQualityMapper.selectByLikeName(name);
        return new PageInfo<BearingQuality>(bearingQualityList);

    }

    public PageInfo<BearingQuality> selectByLikeNameAndQuality(String name, Integer pageIndex, Integer pageSize) {
        PageHelper.startPage(pageIndex, pageSize);
        List<BearingQuality> bearingQualityList = bearingQualityMapper.selectByLikeNameAndQuality(name);
        return new PageInfo<BearingQuality>(bearingQualityList);

    }


    public PageInfo<BearingQuality> selectByLikeNameAndNotQuality(String name, Integer pageIndex, Integer pageSize) {
        PageHelper.startPage(pageIndex, pageSize);
        List<BearingQuality> bearingQualityList = bearingQualityMapper.selectByLikeNameAndNotQuality(name);
        return new PageInfo<BearingQuality>(bearingQualityList);

    }


}

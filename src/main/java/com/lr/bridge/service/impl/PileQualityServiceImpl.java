package com.lr.bridge.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lr.bridge.dao.PileQualityMapper;
import com.lr.bridge.pojo.PileQuality;
import com.lr.bridge.service.PileQualityService;
import com.lr.bridge.vo.EntityCountDateList;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by ALTERUI on 2019/3/25 16:52
 */
@Service
public class PileQualityServiceImpl implements PileQualityService {



    @Resource
    private PileQualityMapper pileQualityMapper;

    /**
     * 显示已经确认
     * @param pageIndex
     * @param pageSize
     * @return
     */
    @Override
    public PageInfo<PileQuality> selectByHasQuality(Integer pageIndex, Integer pageSize) {
        PageHelper.startPage(pageIndex, pageSize);
        List<PileQuality> articleList = pileQualityMapper.selectByHasQuality();

        return new PageInfo<>(articleList);
    }

    @Override
    public PageInfo<PileQuality> showQuality(Integer pageIndex,
                                                Integer pageSize) {

        PageHelper.startPage(pageIndex, pageSize);
        List<PileQuality> articleList = pileQualityMapper.findAll(-1);

        return new PageInfo<>(articleList);


    }

    /**
     * 支座分页显示
     * @param pageIndex
     * @param pageSize
     * @return
     */
    @Override
    public PageInfo<PileQuality> showPile(Integer pageIndex, Integer pageSize) {
        PageHelper.startPage(pageIndex, pageSize);
        List<PileQuality> pileQualityList = pileQualityMapper.selectById();
        return new PageInfo<PileQuality>(pileQualityList);
    }


    @Override
    public List<PileQuality> getPileStruId() {
        return pileQualityMapper.selectById();
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @Override
    public int deleteById(Integer id) {
        return pileQualityMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateByIsQualify(int isQualify, int id) {
       return pileQualityMapper.updateByIsQualify(isQualify, id);
    }


    @Override
    public  List<EntityCountDateList> getIsQualityCountByDate(String start,String end) {
        return pileQualityMapper.getIsQualityCountByDate(start,end);
    }

    public PileQuality selectByPrimaryKey(Integer id){
        return pileQualityMapper.selectByPrimaryKey(id);
    }

     public int insert(PileQuality record){
         return pileQualityMapper.insert(record);
     }

    public int updateByPrimaryKey(PileQuality record){
        return pileQualityMapper.updateByPrimaryKey(record);
    }

    public PageInfo<PileQuality> selectByLikeName(String name, Integer pageIndex, Integer pageSize) {
        PageHelper.startPage(pageIndex, pageSize);
        List<PileQuality> pileQualityList = pileQualityMapper.selectByLikeName(name);
        return new PageInfo<PileQuality>(pileQualityList);

    }

    public PageInfo<PileQuality> selectByLikeNameAndQuality(String name, Integer pageIndex, Integer pageSize) {
        PageHelper.startPage(pageIndex, pageSize);
        List<PileQuality> pileQualityList = pileQualityMapper.selectByLikeNameAndQuality(name);
        return new PageInfo<PileQuality>(pileQualityList);

    }


    public PageInfo<PileQuality> selectByLikeNameAndNotQuality(String name, Integer pageIndex, Integer pageSize) {
        PageHelper.startPage(pageIndex, pageSize);
        List<PileQuality> pileQualityList = pileQualityMapper.selectByLikeNameAndNotQuality(name);
        return new PageInfo<PileQuality>(pileQualityList);

    }

    @Override
    public PageInfo<PileQuality> selectByDate(String start, String end, Integer pageIndex, Integer pageSize) {
        PageHelper.startPage(pageIndex, pageSize);
        List<PileQuality> bearingQualityList = pileQualityMapper.selectByDate(start, end);
        return new PageInfo<PileQuality>(bearingQualityList);
    }


    @Override
    public PageInfo<PileQuality> selectQualityByDate(int isQualify, String start, String end, Integer pageIndex, Integer pageSize) {
        PageHelper.startPage(pageIndex, pageSize);
        List<PileQuality> bearingQualityList = pileQualityMapper.selectQualityByDate(isQualify, start, end);
        return new PageInfo<PileQuality>(bearingQualityList);
    }


    @Override
    public PageInfo<PileQuality> selectHasQualityByDate( String start, String end, Integer pageIndex, Integer pageSize) {
        PageHelper.startPage(pageIndex, pageSize);
        List<PileQuality> bearingQualityList = pileQualityMapper.selectHasQualityByDate(start, end);
        return new PageInfo<PileQuality>(bearingQualityList);
    }


    @Override
    public int selectCountByDate(String start, String end, int isQualify) {
        return pileQualityMapper.selectCountByDate(start, end, isQualify);
    }

    @Override
    public PageInfo<PileQuality> selectByDateAll(String start, String end, Integer pageIndex, Integer pageSize) {
        PageHelper.startPage(pageIndex, pageSize);
        List<PileQuality> bearingQualityList = pileQualityMapper.selectByDateAll(start, end);
        return new PageInfo<PileQuality>(bearingQualityList);
    }





}

package com.lr.bridge.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lr.bridge.dao.BeamQualityMapper;
import com.lr.bridge.pojo.BeamQuality;
import com.lr.bridge.service.BeamQualityService;
import com.lr.bridge.vo.EntityCountDateList;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

/**
 * Created by ALTERUI on 2019/3/25 16:52
 */
@Service
public class BeamQualityServiceImpl implements BeamQualityService {



    @Resource
    private BeamQualityMapper beamQualityMapper;

    /**
     * 显示已经确认
     * @param pageIndex
     * @param pageSize
     * @return
     */
    @Override
    public PageInfo<BeamQuality> selectByHasQuality(Integer pageIndex, Integer pageSize) {
        PageHelper.startPage(pageIndex, pageSize);
        List<BeamQuality> articleList = beamQualityMapper.selectByHasQuality();

        return new PageInfo<>(articleList);
    }

    @Override
    public PageInfo<BeamQuality> showQuality(Integer pageIndex,
                                                Integer pageSize) {

        PageHelper.startPage(pageIndex, pageSize);
        List<BeamQuality> articleList = beamQualityMapper.findAll(-1);

        return new PageInfo<>(articleList);


    }





    @Override
    public List<BeamQuality> getBeamStruId() {
        return beamQualityMapper.selectById();
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @Override
    public int deleteById(Integer id) {
        return beamQualityMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateByIsQualify(int isQualify, int id) {
       return beamQualityMapper.updateByIsQualify(isQualify, id);
    }


    @Override
    public  List<EntityCountDateList> getIsQualityCountByDate(String start,String end) {
        return beamQualityMapper.getIsQualityCountByDate(start,end);
    }

    public BeamQuality selectByPrimaryKey(Integer id){
        return beamQualityMapper.selectByPrimaryKey(id);
    }

     public int insert(BeamQuality record){
         return beamQualityMapper.insert(record);
     }

    public int updateByPrimaryKey(BeamQuality record){
        return beamQualityMapper.updateByPrimaryKey(record);
    }


    @Override
    public PageInfo<BeamQuality> showBeam(Integer pageIndex, Integer pageSize) {
        PageHelper.startPage(pageIndex, pageSize);
        List<BeamQuality> beamQualityList = beamQualityMapper.selectById();
        return new PageInfo<BeamQuality>(beamQualityList);
    }


    public PageInfo<BeamQuality> selectByLikeName(String name, Integer pageIndex, Integer pageSize) {
        PageHelper.startPage(pageIndex, pageSize);
        List<BeamQuality> beamQualityList = beamQualityMapper.selectByLikeName(name);
        return new PageInfo<BeamQuality>(beamQualityList);

    }

    public PageInfo<BeamQuality> selectByLikeNameAndQuality(String name, Integer pageIndex, Integer pageSize) {
        PageHelper.startPage(pageIndex, pageSize);
        List<BeamQuality> beamQualityList = beamQualityMapper.selectByLikeNameAndQuality(name);
        return new PageInfo<BeamQuality>(beamQualityList);

    }


    public PageInfo<BeamQuality> selectByLikeNameAndNotQuality(String name, Integer pageIndex, Integer pageSize) {
        PageHelper.startPage(pageIndex, pageSize);
        List<BeamQuality> beamQualityList = beamQualityMapper.selectByLikeNameAndNotQuality(name);
        return new PageInfo<BeamQuality>(beamQualityList);

    }

    @Override
    public PageInfo<BeamQuality> selectByDate(String start, String end, Integer pageIndex, Integer pageSize) {
        PageHelper.startPage(pageIndex, pageSize);
        List<BeamQuality> bearingQualityList = beamQualityMapper.selectByDate(start, end);
        return new PageInfo<BeamQuality>(bearingQualityList);
    }


    @Override
    public PageInfo<BeamQuality> selectQualityByDate(int isQualify, String start, String end, Integer pageIndex, Integer pageSize) {
        PageHelper.startPage(pageIndex, pageSize);
        List<BeamQuality> bearingQualityList = beamQualityMapper.selectQualityByDate(isQualify, start, end);
        return new PageInfo<BeamQuality>(bearingQualityList);
    }


    @Override
    public PageInfo<BeamQuality> selectHasQualityByDate( String start, String end, Integer pageIndex, Integer pageSize) {
        PageHelper.startPage(pageIndex, pageSize);
        List<BeamQuality> bearingQualityList = beamQualityMapper.selectHasQualityByDate(start, end);
        return new PageInfo<BeamQuality>(bearingQualityList);
    }


    @Override
    public List<BeamQuality> selectByLikeName(String name) {
        return beamQualityMapper.selectByLikeName(name);
    }


    @Override
    public int selectCountByDate(String start, String end, int isQualify) {
        return beamQualityMapper.selectCountByDate(start, end, isQualify);
    }
}

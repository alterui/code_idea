package com.lr.bridge.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lr.bridge.dao.TowerQualityMapper;
import com.lr.bridge.pojo.TowerQuality;
import com.lr.bridge.service.TowerQualityService;
import com.lr.bridge.vo.EntityCountDateList;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by ALTERUI on 2019/3/25 16:52
 */
@Service
public class TowerQualityServiceImpl implements TowerQualityService {



    @Resource
    private TowerQualityMapper towerQualityMapper;

    /**
     * 显示已经确认
     * @param pageIndex
     * @param pageSize
     * @return
     */
    @Override
    public PageInfo<TowerQuality> selectByHasQuality(Integer pageIndex, Integer pageSize) {
        PageHelper.startPage(pageIndex, pageSize);
        List<TowerQuality> articleList = towerQualityMapper.selectByHasQuality();

        return new PageInfo<>(articleList);
    }

    @Override
    public PageInfo<TowerQuality> showQuality(Integer pageIndex,
                                                Integer pageSize) {

        PageHelper.startPage(pageIndex, pageSize);
        List<TowerQuality> articleList = towerQualityMapper.findAll(-1);

        return new PageInfo<>(articleList);


    }

    /**
     * 支座分页显示
     * @param pageIndex
     * @param pageSize
     * @return
     */
    @Override
    public PageInfo<TowerQuality> showTower(Integer pageIndex, Integer pageSize) {
        PageHelper.startPage(pageIndex, pageSize);
        List<TowerQuality> towerQualityList = towerQualityMapper.selectById();
        return new PageInfo<TowerQuality>(towerQualityList);
    }


    @Override
    public List<TowerQuality> getTowerStruId() {
        return towerQualityMapper.selectById();
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @Override
    public int deleteById(Integer id) {
        return towerQualityMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateByIsQualify(int isQualify, int id) {
       return towerQualityMapper.updateByIsQualify(isQualify, id);
    }


    @Override
    public  List<EntityCountDateList> getIsQualityCountByDate(String start,String end) {
        return towerQualityMapper.getIsQualityCountByDate(start,end);
    }

    public TowerQuality selectByPrimaryKey(Integer id){
        return towerQualityMapper.selectByPrimaryKey(id);
    }

     public int insert(TowerQuality record){
         return towerQualityMapper.insert(record);
     }

    public int updateByPrimaryKey(TowerQuality record){
        return towerQualityMapper.updateByPrimaryKey(record);
    }

    public PageInfo<TowerQuality> selectByLikeName(String name, Integer pageIndex, Integer pageSize) {
        PageHelper.startPage(pageIndex, pageSize);
        List<TowerQuality> towerQualityList = towerQualityMapper.selectByLikeName(name);
        return new PageInfo<TowerQuality>(towerQualityList);

    }

    public PageInfo<TowerQuality> selectByLikeNameAndQuality(String name, Integer pageIndex, Integer pageSize) {
        PageHelper.startPage(pageIndex, pageSize);
        List<TowerQuality> towerQualityList = towerQualityMapper.selectByLikeNameAndQuality(name);
        return new PageInfo<TowerQuality>(towerQualityList);

    }


    public PageInfo<TowerQuality> selectByLikeNameAndNotQuality(String name, Integer pageIndex, Integer pageSize) {
        PageHelper.startPage(pageIndex, pageSize);
        List<TowerQuality> towerQualityList = towerQualityMapper.selectByLikeNameAndNotQuality(name);
        return new PageInfo<TowerQuality>(towerQualityList);

    }


}

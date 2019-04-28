package com.lr.bridge.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lr.bridge.dao.PierQualityMapper;
import com.lr.bridge.pojo.PierQuality;
import com.lr.bridge.service.PierQualityService;
import com.lr.bridge.vo.EntityCountDateList;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by ALTERUI on 2019/3/25 16:52
 */
@Service
public class PierQualityServiceImpl implements PierQualityService {



    @Resource
    private PierQualityMapper pierQualityMapper;

    /**
     * 显示已经确认
     * @param pageIndex
     * @param pageSize
     * @return
     */
    @Override
    public PageInfo<PierQuality> selectByHasQuality(Integer pageIndex, Integer pageSize) {
        PageHelper.startPage(pageIndex, pageSize);
        List<PierQuality> articleList = pierQualityMapper.selectByHasQuality();

        return new PageInfo<>(articleList);
    }

    @Override
    public PageInfo<PierQuality> showQuality(Integer pageIndex,
                                                Integer pageSize) {

        PageHelper.startPage(pageIndex, pageSize);
        List<PierQuality> articleList = pierQualityMapper.findAll(-1);

        return new PageInfo<>(articleList);


    }

    /**
     * 支座分页显示
     * @param pageIndex
     * @param pageSize
     * @return
     */
    @Override
    public PageInfo<PierQuality> showPier(Integer pageIndex, Integer pageSize) {
        PageHelper.startPage(pageIndex, pageSize);
        List<PierQuality> pierQualityList = pierQualityMapper.selectById();
        return new PageInfo<PierQuality>(pierQualityList);
    }


    @Override
    public List<PierQuality> getPierStruId() {
        return pierQualityMapper.selectById();
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @Override
    public int deleteById(Integer id) {
        return pierQualityMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateByIsQualify(int isQualify, int id) {
       return pierQualityMapper.updateByIsQualify(isQualify, id);
    }


    @Override
    public  List<EntityCountDateList> getIsQualityCountByDate(String start,String end) {
        return pierQualityMapper.getIsQualityCountByDate(start,end);
    }

    public PierQuality selectByPrimaryKey(Integer id){
        return pierQualityMapper.selectByPrimaryKey(id);
    }

     public int insert(PierQuality record){
         return pierQualityMapper.insert(record);
     }

    public int updateByPrimaryKey(PierQuality record){
        return pierQualityMapper.updateByPrimaryKey(record);
    }

    public PageInfo<PierQuality> selectByLikeName(String name, Integer pageIndex, Integer pageSize) {
        PageHelper.startPage(pageIndex, pageSize);
        List<PierQuality> pierQualityList = pierQualityMapper.selectByLikeName(name);
        return new PageInfo<PierQuality>(pierQualityList);

    }

    public PageInfo<PierQuality> selectByLikeNameAndQuality(String name, Integer pageIndex, Integer pageSize) {
        PageHelper.startPage(pageIndex, pageSize);
        List<PierQuality> pierQualityList = pierQualityMapper.selectByLikeNameAndQuality(name);
        return new PageInfo<PierQuality>(pierQualityList);

    }


    public PageInfo<PierQuality> selectByLikeNameAndNotQuality(String name, Integer pageIndex, Integer pageSize) {
        PageHelper.startPage(pageIndex, pageSize);
        List<PierQuality> pierQualityList = pierQualityMapper.selectByLikeNameAndNotQuality(name);
        return new PageInfo<PierQuality>(pierQualityList);

    }

    @Override
    public PageInfo<PierQuality> selectByDate(String start, String end, Integer pageIndex, Integer pageSize) {
        PageHelper.startPage(pageIndex, pageSize);
        List<PierQuality> bearingQualityList = pierQualityMapper.selectByDate(start, end);
        return new PageInfo<PierQuality>(bearingQualityList);
    }


}

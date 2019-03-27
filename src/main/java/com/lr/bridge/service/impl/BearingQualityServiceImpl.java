package com.lr.bridge.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lr.bridge.dao.BearingQualityMapper;
import com.lr.bridge.pojo.BearingQuality;
import com.lr.bridge.service.BearingQualityService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by ALTERUI on 2019/3/25 16:52
 */
@Service
public class BearingQualityServiceImpl implements BearingQualityService {



    @Resource
    private BearingQualityMapper bearingQualityMapper;
    @Override
    public PageInfo<BearingQuality> pageArticle(Integer pageIndex,
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


    public BearingQuality selectByPrimaryKey(Integer id){
        return bearingQualityMapper.selectByPrimaryKey(id);
    }

     public int insert(BearingQuality record){
         return bearingQualityMapper.insert(record);
     }

    public int updateByPrimaryKey(BearingQuality record){
        return bearingQualityMapper.updateByPrimaryKey(record);
    }


}

package com.lr.bridge.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lr.bridge.dao.EnvProtectionMapper;
import com.lr.bridge.pojo.EnvProtection;
import com.lr.bridge.service.EnvProtectionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by ALTERUI on 2019/4/9 17:39
 */
@Service
public class EnvProtectionServiceImpl implements EnvProtectionService {

    @Resource
    private EnvProtectionMapper envProtectionMapper;

    /**
     * 得到所有数据
     * @param pageIndex
     * @param pageSize
     * @return
     */
    @Override
    public PageInfo<EnvProtection> showEnvProtection(Integer pageIndex, Integer pageSize) {
        PageHelper.startPage(pageIndex, pageSize);
        List<EnvProtection> envProtectionList = envProtectionMapper.selectAll();
        return new PageInfo<EnvProtection>(envProtectionList);
    }

    public EnvProtection selectByPrimaryKey(Integer id){
        return envProtectionMapper.selectByPrimaryKey(id);
    }

}

package com.lr.bridge.service;

import com.github.pagehelper.PageInfo;
import com.lr.bridge.pojo.BearingQuality;
import com.lr.bridge.pojo.EnvProtection;

/**
 * Created by ALTERUI on 2019/4/9 17:38
 */
public interface EnvProtectionService {

    PageInfo<EnvProtection> showEnvProtection(Integer pageIndex,
                                     Integer pageSize);

    EnvProtection selectByPrimaryKey(Integer id);
}

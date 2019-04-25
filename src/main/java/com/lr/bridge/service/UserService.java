package com.lr.bridge.service;

import com.github.pagehelper.PageInfo;
import com.lr.bridge.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    Map<String, String> register(String userName, String fullName, String password, String repassword);

    User getUser(String userName);
    Map<String,String> login(String userName, String password);

    PageInfo<User> showUser(Integer pageIndex,
                            Integer pageSize);



}

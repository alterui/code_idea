package com.lr.bridge.service;

import com.github.pagehelper.PageInfo;
import com.lr.bridge.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    Map<String, String> register(String userName, String fullName, String password, int permission);


    User getUser(String userName);
    Map<String,String> login(String userName, String password);

    PageInfo<User> showUser(Integer pageIndex, Integer pageSize);

    int deleteByPrimaryKey(Integer id);

    PageInfo<User> selectByLikeName(String name, Integer pageIndex,
                                    Integer pageSize);

    User selectByPrimaryKey(Integer id);


    User selectByUserName(String userName);

    int updateByPrimaryKey(User record);

    int insert(User record);

    User selectByIdAndPwd(int id,  String password);

    int updateByIdAndPwd(int id, String password);



}

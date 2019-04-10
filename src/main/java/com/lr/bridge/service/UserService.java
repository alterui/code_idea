package com.lr.bridge.service;

import com.lr.bridge.pojo.User;

import java.util.Map;

public interface UserService {
    Map<String, String> register(String userName, String fullName, String password, String repassword);

    User getUser(String userName);
    Map<String,String> login(String userName, String password);



}

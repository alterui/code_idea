package com.lr.bridge.service;

import java.util.Map;

public interface UserService {
    Map<String,String> register(String userName, String password,String repassword);
    Map<String,String> login(String userName, String password);



}

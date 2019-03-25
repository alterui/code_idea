package com.lr.bridge.service.impl;

import javax.annotation.Resource;

import com.lr.bridge.dao.UserMapper;
import com.lr.bridge.pojo.User;
import org.springframework.stereotype.Service;

import com.lr.bridge.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Resource
	private UserMapper userMapper;
	
	public User getUser(int id) {
		// TODO Auto-generated method stub
		return userMapper.selectByPrimaryKey(id);
	}

}

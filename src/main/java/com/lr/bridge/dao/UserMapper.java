package com.lr.bridge.dao;

import com.lr.bridge.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User selectByUserName(String userName);

    User selectByIdAndPwd(@Param("id") int id, @Param("password") String password);

    int updateByIdAndPwd(@Param("id") int id, @Param("password") String password);


    List<User> showUserOrAdmin();

    List<User> selectByLikeName(String name);
}
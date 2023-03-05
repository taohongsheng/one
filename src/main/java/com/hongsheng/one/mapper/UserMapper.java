package com.hongsheng.one.mapper;

import com.hongsheng.one.entity.User;

import java.util.List;

public interface UserMapper {
    //登录信息核对
    User getInfo(String name, String password);

    //根据id查询用户信息
    User selectUserById(String id);

    //新建用户
    int insertUser(User user);

    //删除用户
    int deleteUser(String id);

    //修改用户
    int updateUser(User user);

    //查询所有用户
    List<User> getAllUser();

    List<User> findUsersByKeyword(String keyword);

    List<User> namePasswordById(String id);

}

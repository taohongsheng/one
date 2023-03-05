package com.hongsheng.one.service;

import com.hongsheng.one.entity.User;

import java.util.List;

public interface UserService {
    User loginIn(String name, String password);

    User queryUserId(String id);

    int addUser(User user);

    int dropUser(String id);

    int modifyUser(User user);

    List<User> queryAllUser();

    List<User> findUsersByKeyword(String keyword);

    List<User> namePasswordById(String id);

}

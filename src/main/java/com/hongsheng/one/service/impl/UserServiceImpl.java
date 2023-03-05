package com.hongsheng.one.service.impl;

import com.hongsheng.one.entity.User;
import com.hongsheng.one.mapper.UserMapper;
import com.hongsheng.one.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    /**
     * 登录验证
     * @param name
     * @param password
     * @return
     */
    public User loginIn(String name, String password) {
            return userMapper.getInfo(name, password);

    }

    @Override
    public User queryUserId(String id) {
        return userMapper.selectUserById(id);
    }

    @Override
    public int addUser(User user) {
        int aFlag = userMapper.insertUser(user);
        return aFlag;
    }

    @Override
    public int dropUser(String id) {
        int dFlag = userMapper.deleteUser(id);
        return dFlag;
    }

    @Override
    public int modifyUser(User user) {
        int mFlag = userMapper.updateUser(user);
        return mFlag;
    }

    @Override
    public List<User> queryAllUser() {
        return userMapper.getAllUser();
    }

    @Override
    public List<User> findUsersByKeyword(String keyword) {
        List<User> users = userMapper.findUsersByKeyword(keyword);
        return users;

    }

    @Override
    public List<User> namePasswordById(String id) {
        List<User> users=userMapper.namePasswordById(id);
        return users;

    }


}

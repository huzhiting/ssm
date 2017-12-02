package com.uqiauto.service;

import com.github.pagehelper.PageInfo;
import com.uqiauto.pojo.User;

import java.util.List;

public interface UserService {
    public User getUserById(Long userId);

    public PageInfo<User> queryAllUser();

}

package com.miao.blog.service;

import com.miao.blog.entity.User;

public interface UserService {
    User checkUser(String username, String password);
}

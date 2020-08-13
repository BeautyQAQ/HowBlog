package com.liushao.user.service;

import com.liushao.user.dao.UserDao;
import com.liushao.user.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author huangshen
 */
@Service
public class UserService {
    @Autowired
    private UserDao userDao;


    /**
     * 即时通讯登录
     */
    public User login(User user) {
        return userDao.selectOne(user);
    }
}

package com.mai8mai.core.service.impl;

import com.mai8mai.core.dao.UserDao;
import com.mai8mai.core.dao.model.User;
import com.mai8mai.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2016/1/6.
 */
@Transactional(rollbackFor = Throwable.class)
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public boolean create(User user) {
        try {
            userDao.create(user);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean edit(User user) {
        try {
            userDao.edit(user);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public User getUserById(Long id) {
        User user=userDao.find(id);
        return user;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

}

package com.mai8mai.core.service;

import com.mai8mai.core.dao.model.User;

/**
 * Created by Administrator on 2016/1/6.
 */
public interface UserService {
    public boolean create(User user);
    public boolean edit(User user);
    public User getUserById(Long id);
}

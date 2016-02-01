package com.mai8mai.core.dao;

import com.mai8mai.core.dao.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;


@Repository
public class UserDao extends AbstractDao<User> {

    private static final Logger logger = LoggerFactory.getLogger(UserDao.class);

    public UserDao() {
        super(User.class);
    }

}

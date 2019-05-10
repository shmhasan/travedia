package com.mehedi.travedia.dao.auth.impl;

import com.mehedi.travedia.dao.auth.UserDao;
import com.mehedi.travedia.model.auth.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

    @Autowired
    SessionFactory sessionFactory;

    public User getUserbyUsername(String username) {
        User user = sessionFactory.getCurrentSession().get(User.class, username);
        return user;
    }

    @Override
    public void save(User user) {
        sessionFactory.getCurrentSession().save(user);
    }
}

package com.mehedi.travedia.dao.auth.impl;

import com.mehedi.travedia.dao.auth.UserDao;
import com.mehedi.travedia.model.auth.User;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

    @Autowired
    SessionFactory sessionFactory;

    public User getUserbyUsername(String username) {

        Query<User> query = sessionFactory.getCurrentSession()
                .createNamedQuery(User.FIND_BY_USERNAME, User.class)
                .setParameter("username", username);
        User user = query.uniqueResult();

        return user;
    }

    @Override
    public void save(User user) {
        sessionFactory.getCurrentSession().save(user);
    }
}

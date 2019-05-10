package com.mehedi.travedia.dao.auth;

import com.mehedi.travedia.model.auth.User;

public interface UserDao {

    User getUserbyUsername(String username);

    void save(User user);
}

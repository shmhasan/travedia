package com.mehedi.travedia.service.auth.impl;

import com.mehedi.travedia.dao.auth.UserDao;
import com.mehedi.travedia.dto.UserDto;
import com.mehedi.travedia.model.auth.Role;
import com.mehedi.travedia.model.auth.User;
import com.mehedi.travedia.service.auth.UserService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public void save(UserDto userDto) {
        User user = new User();
        user.setActive(true);
        user.setUsername(userDto.getUsername());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setEmail(userDto.getEmail());

        Set<Role> roleSet = new HashSet<Role>();
        roleSet.add(new Role("ROLE_USER"));

        user.setRoles(roleSet);

        userDao.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userDao.getUserbyUsername(s);
        org.springframework.security.core.userdetails.User.UserBuilder builder = null;
        if(user != null) {
            builder = org.springframework.security.core.userdetails.User.withUsername(s);
            builder.password(user.getPassword());
            String[] roles = user.getRoles().stream().map(item -> item.getName()).toArray(String[]::new);

            builder.authorities(roles);

        }else {
            throw new UsernameNotFoundException("Credentials does not match");
        }
        return builder.build();
    }
}

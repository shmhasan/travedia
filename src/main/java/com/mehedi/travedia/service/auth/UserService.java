package com.mehedi.travedia.service.auth;

import com.mehedi.travedia.dto.UserDto;
import com.mehedi.travedia.model.auth.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User findByUsername(String username);

    void save(UserDto userDto) throws Exception;
}

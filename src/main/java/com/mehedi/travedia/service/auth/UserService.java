package com.mehedi.travedia.service.auth;

import com.mehedi.travedia.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    void save(UserDto userDto);
}

package com.mehedi.travedia.web;

import com.mehedi.travedia.dto.UserDto;
import com.mehedi.travedia.service.auth.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AuthenticationController {


    @Autowired
    private UserService userService;

    @RequestMapping(value = "/auth/login", method = RequestMethod.GET)
    public String index() {
        return "auth/index";
    }


    @RequestMapping(value = "/auth/register", method = RequestMethod.GET)
    public String register() {
        return "auth/register";
    }


    @RequestMapping(value = "/auth/register", method = RequestMethod.POST)
    public String registerPost(@ModelAttribute("user") UserDto user, HttpServletRequest request) {

        userService.save(user);

        return "auth/register";
    }
}

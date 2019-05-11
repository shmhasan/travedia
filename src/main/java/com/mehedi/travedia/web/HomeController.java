package com.mehedi.travedia.web;

import com.mehedi.travedia.dto.UserDto;
import com.mehedi.travedia.model.auth.User;
import com.mehedi.travedia.service.auth.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Principal principal, Model uiModel) {
        if(principal != null) {
            uiModel.addAttribute("loggedIn", true);
        }else {
            uiModel.addAttribute("loggedIn", false);
        }

      return "home/index";
    }

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String profile(Principal principal, Model uiModel) {

        User user = userService.findByUsername(principal.getName());
        UserDto userInfo = new UserDto();
        userInfo.setEmail(user.getEmail());
        userInfo.setUsername(user.getUsername());
        userInfo.setFirstname(user.getFirstname());
        userInfo.setLastname(user.getLastname());

        uiModel.addAttribute("profile", userInfo);

        return "profile/index";
    }
}

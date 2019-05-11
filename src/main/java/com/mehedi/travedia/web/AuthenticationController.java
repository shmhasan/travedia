package com.mehedi.travedia.web;

import com.mehedi.travedia.dto.UserDto;
import com.mehedi.travedia.service.auth.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class AuthenticationController {


    @Autowired
    private UserService userService;

    @RequestMapping(value = "/auth/login", method = RequestMethod.GET)
    public String index(Model model, String error, String logout) {

        if (error != null)
            model.addAttribute("errorMsg", "Your username and password are invalid.");

        if (logout != null)
            model.addAttribute("msg", "You have been logged out successfully.");

        return "auth/index";
    }


    @RequestMapping(value = "/auth/register", method = RequestMethod.GET)
    public String register(Model uiModel) {
        uiModel.addAttribute("hasError", false);
        uiModel.addAttribute("user", new UserDto());
        return "auth/register";
    }


    @RequestMapping(value = "/auth/register", method = RequestMethod.POST)
    public String registerPost(@ModelAttribute @Valid UserDto user, BindingResult result, Model uiModel) {

        if(result.hasErrors()) {
            result.getAllErrors();
            uiModel.addAttribute("hasError", true);
            uiModel.addAttribute("errorCount", result.getErrorCount());
            uiModel.addAttribute("user", user);

            return "auth/register";
        }
        try {
            userService.save(user);
        }catch (Exception ex) {
            uiModel.addAttribute("hasError", true);
            return "auth/register";
        }

        return "redirect:/auth/login";
    }
}

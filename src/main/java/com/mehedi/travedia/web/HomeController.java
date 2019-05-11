package com.mehedi.travedia.web;

import com.mehedi.travedia.dto.UserDto;
import com.mehedi.travedia.model.app.Post;
import com.mehedi.travedia.model.auth.User;
import com.mehedi.travedia.service.app.PostService;
import com.mehedi.travedia.service.auth.UserService;
import javafx.geometry.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @Autowired
    private PostService postService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Principal principal, Model uiModel) {

        List<Post> posts = new ArrayList<Post>();
        List<Post> publicPosts = postService.findPublicPosts();

        if(publicPosts != null && publicPosts.size() > 0) {
            posts.addAll(publicPosts);
        }
        if(principal != null) {
            uiModel.addAttribute("loggedIn", true);
            uiModel.addAttribute("loggedInUsername", principal.getName());



        }else {
            uiModel.addAttribute("loggedIn", false);
            uiModel.addAttribute("loggedInUsername", null);
        }

        uiModel.addAttribute("posts", posts);

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
        uiModel.addAttribute("loggedIn", true);
        List<Post> postByAuthor = postService.findPostByAuthor(user);
        uiModel.addAttribute("posts", postByAuthor);

        return "profile/index";
    }
}

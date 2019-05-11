package com.mehedi.travedia.web;

import com.google.gson.Gson;
import com.mehedi.travedia.model.app.Post;
import com.mehedi.travedia.model.auth.User;
import com.mehedi.travedia.service.app.PostService;
import com.mehedi.travedia.service.auth.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;
import java.util.List;

@Controller
public class PostController {

    @Autowired
    PostService postService;

    @Autowired
    UserService userService;

    @RequestMapping(value = "/rest/posts", method = RequestMethod.GET, produces = "application/json")
    public
    @ResponseBody
    String index(Principal principal) {
        User user =  userService.findByUsername(principal.getName());
        List<Post> postByAuthor = postService.findPostByAuthor(user);

        return new Gson().toJson(postByAuthor);
    }
}

package com.mehedi.travedia.web;

import com.google.gson.Gson;
import com.mehedi.travedia.dto.ErrorMessageDto;
import com.mehedi.travedia.dto.PostDto;
import com.mehedi.travedia.dto.ResponseDto;
import com.mehedi.travedia.model.app.Location;
import com.mehedi.travedia.model.app.Post;
import com.mehedi.travedia.model.auth.User;
import com.mehedi.travedia.service.app.LocationService;
import com.mehedi.travedia.service.app.PostService;
import com.mehedi.travedia.service.auth.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.security.Principal;
import java.util.Date;
import java.util.List;

@Controller
public class PostController {

    public static final Logger logger = LoggerFactory.getLogger(PostController.class);

    @Autowired
    PostService postService;

    @Autowired
    UserService userService;

    @Autowired
    LocationService locationService;

    @RequestMapping(value = "/rest/posts", method = RequestMethod.GET, produces = "application/json")
    public
    @ResponseBody
    String index(Principal principal) {
//        User user =  userService.findByUsername(principal.getName());
        List<Post> postByAuthor = postService.findPublicPosts();

        return new Gson().toJson(postByAuthor);
    }

    @RequestMapping(value = "/posts", method = RequestMethod.POST, produces = "application/json")
    public
    @ResponseBody String savePost(Principal principal, @Valid @ModelAttribute PostDto postDto, BindingResult result) {

        User user = userService.findByUsername(principal.getName());


        if(result.hasErrors()) {

            return new Gson().toJson(new ErrorMessageDto(""));
        }

        Location location = locationService.findById(postDto.getLocation());
        Post post = new Post();
        post.setAuthor(user);
        post.setLocation(location);
        post.setPrivacy(postDto.getPrivacy());
        post.setCreatedAt(new Date());
        post.setContent(postDto.getStatus());
        post.setStatus(1);

        postService.save(post);

        return new Gson().toJson(post);
    }


    @RequestMapping(value = "/post/edit", method = RequestMethod.GET, produces = "application/json")
    public String updatePost(Principal principal, HttpServletRequest request, Model uiModel) {
        String postIdStr = request.getParameter("i");
        int postId = 0;
        Post post = null;
        boolean hasError = false;
        if(postIdStr != null && !"".equals(postIdStr)) {
            try {
                postId = Integer.parseInt(postIdStr);
            }catch (Exception ex) {
                hasError = true;
            }

            if(postId > 0) {
                post = postService.findById(postId);
            }else {
                hasError = true;
            }
        }else {
            hasError = true;
        }

        if(hasError) {
            uiModel.addAttribute("error", true);
            uiModel.addAttribute("message", "The post you are looking for is not found");
        }else
        {

            List<Location> locations = locationService.findAll();
            PostDto postDto = new PostDto();
            postDto.setId(post.getId());
            postDto.setLocation(post.getLocation().getId());
            postDto.setPrivacy(post.getPrivacy());
            postDto.setStatus(post.getContent());
            postDto.setLocations(locations);

            uiModel.addAttribute("post", postDto);
            uiModel.addAttribute("locations", locations);
        }

        return "posts/edit";

    }

    @RequestMapping(value = "/post/edit", method = RequestMethod.POST, produces = "application/json")
    public
    @ResponseBody String updatePostPOST(Principal principal, @Valid @ModelAttribute PostDto postDto, BindingResult result) {

        User user = userService.findByUsername(principal.getName());


        if(result.hasErrors()) {

            return new Gson().toJson(new ErrorMessageDto("Could not update post"));
        }


        Post post = postService.findById(postDto.getId());
        if(post != null) {

            post.setPrivacy(postDto.getPrivacy());
            post.setUpdatedAt(new Date());
            post.setContent(postDto.getStatus());

            try{
                postService.update(post);
            }catch (Exception ex) {
                logger.info(ex.getMessage());
                return new Gson().toJson(new ErrorMessageDto(500, "Failed update post"));
            }
        }


        return new Gson().toJson(new ErrorMessageDto(200, "Updated Successfully"));
    }


    @RequestMapping(value = "/posts/delete", method = RequestMethod.DELETE, produces = "application/json")
    public @ResponseBody String deletePost(HttpServletRequest request) {
        String idStr = request.getParameter("id");
        long id = 0;
        boolean hasError = false;
        try {
            id = Long.parseLong(idStr);
        }catch (Exception ex) {
            hasError = true;
        }

        if(!hasError) {
            Post post = postService.findById(id);
            if(post != null) {
                postService.remove(post);
            }

        }else {
            return new Gson().toJson(new ErrorMessageDto(500, "Could not find any post"));
        }

        return new Gson().toJson(new ErrorMessageDto(200, "Post Deleted Successfully"));
    }

}

package com.mehedi.travedia.service.app;

import com.mehedi.travedia.dao.app.PostDao;
import com.mehedi.travedia.model.app.Post;
import com.mehedi.travedia.model.auth.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    PostDao postDao;

    public List<Post> findPostByAuthor(User user) {
        return postDao.findByAuthor(user);
    }

    public List<Post> findPublicPosts() {
        return postDao.findPublicPosts();
    }
}

package com.mehedi.travedia.service.app;

import com.mehedi.travedia.dao.app.PostDao;
import com.mehedi.travedia.model.app.Post;
import com.mehedi.travedia.model.auth.User;
import javafx.geometry.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PostService {

    @Autowired
    PostDao postDao;

    public List<Post> findPostByAuthor(User user) {
        return postDao.findByAuthor(user);
    }

    public List<Post> findPublicPosts() {
        return postDao.findPublicPosts();
    }

    public void save(Post post) {
        postDao.save(post);
    }

    public Post findById(long postId) {
        return postDao.findById(postId);
    }

    public void update(Post post) {
        postDao.update(post);
    }

    public void remove(Post post) {
        postDao.remove(post);
    }
}

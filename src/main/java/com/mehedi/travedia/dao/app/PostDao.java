package com.mehedi.travedia.dao.app;

import com.mehedi.travedia.model.app.Post;
import com.mehedi.travedia.model.auth.User;

import java.util.List;

public interface PostDao {

    List<Post> findAll();

    List<Post> findByAuthor(User user);

    void save(Post post);

    List<Post> findPublicPosts();

    Post findById(long postId);

    void update(Post post);

    void remove(Post post);

}

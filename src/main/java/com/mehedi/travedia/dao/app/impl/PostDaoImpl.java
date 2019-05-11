package com.mehedi.travedia.dao.app.impl;

import com.mehedi.travedia.core.databse.AbstractDaoSupport;
import com.mehedi.travedia.dao.app.PostDao;
import com.mehedi.travedia.model.app.Post;
import com.mehedi.travedia.model.auth.User;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PostDaoImpl extends AbstractDaoSupport<Post> implements PostDao {

    @Override
    public List<Post> findAll() {
        return this.fetchAll();
    }

    @Override
    public List<Post> findByAuthor(User user) {
        return getSession().createNativeQuery("select * from contents where author_id = "+ user.getId()).list();
    }

    @Override
    public void save(Post post) {

    }

    @Override
    public List<Post> findPublicPosts() {
        return null;
    }
}

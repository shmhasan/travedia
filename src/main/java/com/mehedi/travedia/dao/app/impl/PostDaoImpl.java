package com.mehedi.travedia.dao.app.impl;

import com.mehedi.travedia.core.databse.AbstractDaoSupport;
import com.mehedi.travedia.dao.app.PostDao;
import com.mehedi.travedia.model.app.Post;
import com.mehedi.travedia.model.auth.User;
import org.hibernate.Criteria;
import org.hibernate.internal.CriteriaImpl;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class PostDaoImpl extends AbstractDaoSupport<Post> implements PostDao {

    @Override
    public List<Post> findAll() {
        return this.fetchAll();
    }

    @Override
    public List<Post> findByAuthor(User user) {


        return getSession().createQuery("from Post p where p.author.id = "+user.getId()).list();
    }

    @Override
    public void save(Post post) {
        getSession().persist(post);
    }

    @Override
    public List<Post> findPublicPosts() {
        return getSession().createQuery("from Post where privacy = 1 order by createdAt desc").list();
    }

    @Override
    public Post findById(long postId) {
        return findOneById(postId);
    }

    @Override
    public void remove(Post post) {
        delete(post);
    }
}

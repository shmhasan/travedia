package com.mehedi.travedia.core.databse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class AbstractDaoSupport <T extends Serializable>{
    private Class<T> clazz;

    @Autowired
    SessionFactory sessionFactory;

    public AbstractDaoSupport() {
        clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public final void setClazz( Class< T > clazzToSet ){
        this.clazz = clazzToSet;
    }

    public T findOneById(long id) {
        return this.getSession().get(clazz, id);
    }

    public List<T> fetchAll() {
        return this.getSession().createQuery("from "+ clazz.getName()).list();
    }

    public void persist(T object) {
        this.getSession().persist(object);
    }

    public void update(T object) {
        this.getSession().merge(object);
    }

    public void delete(T object) {
        this.getSession().delete(object);
    }

    public void deleteById(long id) {
        T entity = findOneById(id);
        this.getSession().delete(entity);
    }

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }


}

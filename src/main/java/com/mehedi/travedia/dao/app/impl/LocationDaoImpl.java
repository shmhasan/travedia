package com.mehedi.travedia.dao.app.impl;

import com.mehedi.travedia.core.databse.AbstractDaoSupport;
import com.mehedi.travedia.dao.app.LocationDao;
import com.mehedi.travedia.model.app.Location;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class LocationDaoImpl extends AbstractDaoSupport<Location> implements LocationDao {

    public static final Logger logger = LoggerFactory.getLogger(LocationDaoImpl.class);


    @Override
    public Location findById(long id) {

        return findOneById(id);
    }

    @Override
    public List<Location> findAll() {
        return fetchAll();
    }

    @Override
    public void save(Location location) {
        persist(location);
    }
}

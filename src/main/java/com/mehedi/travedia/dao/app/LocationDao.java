package com.mehedi.travedia.dao.app;

import com.mehedi.travedia.model.app.Location;

import java.util.List;

public interface LocationDao {

    Location findById(long id);
    List<Location> findAll();
    void save(Location location);
}

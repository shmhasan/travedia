package com.mehedi.travedia.service.app;

import com.mehedi.travedia.dao.app.LocationDao;
import com.mehedi.travedia.model.app.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {

    @Autowired
    private LocationDao locationDao;

    public List<Location> findAll() {
        return locationDao.findAll();
    }

    public Location findById(long location) {

        return locationDao.findById(location);
    }
}

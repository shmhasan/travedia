package com.mehedi.travedia.web;

import com.google.gson.Gson;
import com.mehedi.travedia.model.app.Location;
import com.mehedi.travedia.service.app.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class LocationController {

    @Autowired
    private LocationService locationService;

    @RequestMapping(value = "/rest/location", produces = "application/json")
    public @ResponseBody
    String getAllLocation() {
        List<Location> all = locationService.findAll();
        Gson gson = new Gson();

        return gson.toJson(all);
    }
}

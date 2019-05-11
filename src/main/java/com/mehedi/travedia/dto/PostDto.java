package com.mehedi.travedia.dto;

import com.mehedi.travedia.model.app.Location;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class PostDto {

    private long id;

    @NotEmpty
    private String status;

    @NotNull
    private long location;

    private List<Location> locations;

    private int privacy;
}

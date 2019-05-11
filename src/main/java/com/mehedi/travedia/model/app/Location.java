package com.mehedi.travedia.model.app;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "location")
@Data
@NamedQueries({
        @NamedQuery(name = Location.FIND_ALL, query = Location.FIND_ALL_QUERY)
})
public class Location implements Serializable {

    public static final String FIND_ALL = "FIND_ALL";
    public static final String FIND_ALL_QUERY = "from Location l";
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "name")
    private String name;


}

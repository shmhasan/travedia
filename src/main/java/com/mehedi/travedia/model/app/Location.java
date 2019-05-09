package com.mehedi.travedia.model.app;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "location")
@Data
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "name")
    private String name;


}

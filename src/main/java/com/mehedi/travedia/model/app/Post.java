package com.mehedi.travedia.model.app;

import com.mehedi.travedia.model.auth.User;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "contents")
@Data
public class Post implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "content")
    private String content;

    @Column(name = "status")
    private int status;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    @Column(name = "privacy")
    private int privacy;

    @OneToOne
    private User author;


    @OneToOne
    private Location location;
}

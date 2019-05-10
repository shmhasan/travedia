package com.mehedi.travedia.model.auth;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "roles")
@Data
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "role_sequence")
    private Long id;

    @Column
    private String name;

    public Role(int i, String role_user) {

    }

    public Role(String role_user) {
        this.name = role_user;
    }
}

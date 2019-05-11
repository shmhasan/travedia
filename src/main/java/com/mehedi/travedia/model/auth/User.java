package com.mehedi.travedia.model.auth;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
@Data
@NamedQueries(
        {
                @NamedQuery(name = User.FIND_BY_USERNAME, query = User.FIND_BY_USERNAME_QUERY),
                @NamedQuery(name = User.FIND_BY_EMAIL, query = User.FIND_BY_EMAIL_QUERY)
        }
)
public class User {

    public final static  String FIND_BY_USERNAME = "FIND_USER_BY_USERNAME";
    final static  String FIND_BY_USERNAME_QUERY = "from User u where u.username = :username";
    public final static  String FIND_BY_EMAIL = "FIND_USER_BY_EMAIL";
    final static  String FIND_BY_EMAIL_QUERY = "from User u where u.email = :email";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column
    private String firstname;

    @Column
    private String lastname;

    @Column
    private String nickname;

    @Column
    private boolean active;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Role> roles;
}

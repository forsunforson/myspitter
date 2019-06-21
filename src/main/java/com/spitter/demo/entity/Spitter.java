package com.spitter.demo.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Spitter implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column
    private String password;

    protected Spitter() {}

    public Spitter(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object that) {
        if (that instanceof Spitter) {
            return ((Spitter) that).getId().equals(id);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return id.intValue();
    }
}

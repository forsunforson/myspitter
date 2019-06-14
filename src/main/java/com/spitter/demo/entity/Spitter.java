package com.spitter.demo.entity;

import java.util.concurrent.atomic.AtomicLong;

public class Spitter {
    private final Long id;
    private final String username;
    private final String password;
    private static AtomicLong idGenerator = new AtomicLong(0);

    public Spitter(String username, String password) {
        this.id = idGenerator.getAndIncrement();
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

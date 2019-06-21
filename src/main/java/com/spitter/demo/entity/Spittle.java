package com.spitter.demo.entity;

import javax.persistence.*;
import java.util.concurrent.atomic.AtomicLong;

@Entity
public class Spittle {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String message;

    private Spittle() {}

    public Spittle(String message) {
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public boolean equals(Object that) {
        if (that == this) {
            return true;
        }
        if (that instanceof Spittle) {
            return ((Spittle) that).getId().equals(this.id);
        }
        return false;
    }

    @Override
    public String toString() {
        return "id:" + id + " message:" + message;
    }
}

package com.spitter.demo.entity;

import java.util.concurrent.atomic.AtomicLong;

public class Spittle {
    private final Long id;
    private final String message;

    private static AtomicLong idGenerator;

    static {
        idGenerator = new AtomicLong(0);
    }

    public Spittle(String message) {
        this.id = idGenerator.getAndIncrement();
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

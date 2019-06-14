package com.spitter.demo.dao;

import com.spitter.demo.entity.Spitter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Component
public class SpitterRepository {
    private Set<Spitter> spitters = new HashSet<>();

    public boolean doRegistration(Spitter spitter) {
        if (spitters.contains(spitter)) {
            return false;
        }
        spitters.add(spitter);
        return true;
    }
}

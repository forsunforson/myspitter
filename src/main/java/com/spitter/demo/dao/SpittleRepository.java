package com.spitter.demo.dao;

import com.spitter.demo.entity.Spittle;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SpittleRepository {

    private ArrayList<Spittle> spittles = new ArrayList<>();

    {
        for(int i = 0; i < 100; i++) {
            spittles.add(new Spittle("this is test message. id = " + i));
        }
    }

    public List<Spittle> findSpittles(Long max, int count) {
        ArrayList<Spittle> list = new ArrayList<>();
        for (int i = 0; i <= max && i < count; i++) {
            list.add(spittles.get(i));
        }
        return list;
    }

    public Spittle findById(Long id) {
        for (Spittle spittle : spittles) {
            if (spittle.getId().equals(id)) {
                return spittle;
            }
        }
        return null;
    }
}

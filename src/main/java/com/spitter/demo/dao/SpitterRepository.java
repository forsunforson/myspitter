package com.spitter.demo.dao;

import com.spitter.demo.entity.Spitter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

@Component
public interface SpitterRepository extends JpaRepository<Spitter, Long> {

    @Query(value = "select id, username, password from Spitter where Spitter.username = ?1", nativeQuery = true)
    Spitter findByUsername(String username);
}

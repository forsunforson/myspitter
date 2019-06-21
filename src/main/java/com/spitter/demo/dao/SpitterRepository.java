package com.spitter.demo.dao;

import com.spitter.demo.entity.Spitter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

/**
 * @author wye
 */
@Component
public interface SpitterRepository extends JpaRepository<Spitter, Long> {

    /**
     * Find spitter by username
     * @param username username of the spitter
     * @return a spitter object
     */
    @Query(value = "select id, username, password from Spitter where Spitter.username = ?1", nativeQuery = true)
    Spitter findByUsername(String username);
}

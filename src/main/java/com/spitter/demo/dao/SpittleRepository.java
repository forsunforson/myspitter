package com.spitter.demo.dao;

import com.spitter.demo.entity.Spittle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author wye
 */
@Component
public interface SpittleRepository extends JpaRepository<Spittle, Long> {

    @Query(value = "select id, message from spittle where spittle.id <= ?1 limit ?2", nativeQuery = true)
    List<Spittle> findSpittles(Long max, int count);
}

package com.mathservice.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mathservice.entities.PersonEntity;

public interface PersonRepository extends JpaRepository<PersonEntity, Long> {

    @Query(value = """
            SELECT *
            FROM people
            WHERE id >= :refId
            ORDER BY id
            LIMIT :size
            """, nativeQuery = true)
    List<PersonEntity> findPeople(
            @Param("refId") long refId,
            @Param("size") int size
    );
}
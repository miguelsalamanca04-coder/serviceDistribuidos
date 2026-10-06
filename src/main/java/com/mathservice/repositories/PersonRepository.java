package com.mathservice.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.mathservice.entities.PersonEntity;

public interface PersonRepository extends JpaRepository<PersonEntity, Long> {

    
}
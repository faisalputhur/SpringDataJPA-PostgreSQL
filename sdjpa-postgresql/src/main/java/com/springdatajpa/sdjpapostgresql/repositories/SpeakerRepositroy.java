package com.springdatajpa.sdjpapostgresql.repositories;


import com.springdatajpa.sdjpapostgresql.models.Speaker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpeakerRepositroy extends JpaRepository<Speaker, Long> {

}


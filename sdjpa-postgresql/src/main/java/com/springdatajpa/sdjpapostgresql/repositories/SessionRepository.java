package com.springdatajpa.sdjpapostgresql.repositories;


import com.springdatajpa.sdjpapostgresql.models.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<Session, Long> {
}

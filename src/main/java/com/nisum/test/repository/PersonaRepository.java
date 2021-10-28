package com.nisum.test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nisum.test.model.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Long> {

	 @Query(value = "SELECT * FROM PERSONA WHERE EMAIL = ?1", nativeQuery = true)
	 List<Persona> findByEmailAddress(String email);
	
}

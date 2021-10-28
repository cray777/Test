package com.nisum.test.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.nisum.test.model.Persona;

public interface PersonaService {

	ResponseEntity<Persona> createPersona(Persona persona);

	Persona updatePersona(Persona persona);

	List<Persona> getAllPersona();

	Persona getPersonaById(Long personaId);

	void deletePersona(Long personaId);
}

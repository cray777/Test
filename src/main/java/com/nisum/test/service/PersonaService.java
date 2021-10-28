package com.nisum.test.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.nisum.test.model.Persona;

public interface PersonaService {

	ResponseEntity<Persona> createPersona(Persona persona);

	ResponseEntity updatePersona(Persona persona);

	List<Persona> getAllPersona();

	ResponseEntity getPersonaById(Long personaId);

	ResponseEntity deletePersona(Long personaId);
}

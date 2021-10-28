package com.nisum.test.service;

import java.util.HashSet;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.nisum.test.model.Persona;
import com.nisum.test.model.Phone;
import com.nisum.test.repository.PersonaRepository;
import com.nisum.test.util.Mensaje;
import com.nisum.test.util.Validaciones;

@Service
@Transactional
public class PersonaServiceImpl implements PersonaService {

	@Autowired
	private PersonaRepository personaRepository;

	@Override
	public ResponseEntity createPersona(Persona persona) {
		Persona newPerona = new Persona();
		Mensaje mensaje = new Mensaje();
		newPerona.setToken(UUID.randomUUID().toString());
		newPerona.setName(persona.getName());
		newPerona.setEmail(persona.getEmail());

		List<Persona> personaDB = this.personaRepository.findByEmailAddress(persona.getEmail());
		Validaciones valida = new Validaciones();
		if (valida.validaPassword(persona.getPassword()) == false) {

			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mensaje.getError(2));
		}

		if (valida.validaEmail(persona.getEmail()) == false) {

			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mensaje.getError(3));
		}

		if (personaDB.size() >= 1) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mensaje.getError(1));
		}

		newPerona.setPassword(persona.getPassword());
		Set<Phone> phones = new HashSet<Phone>();
		for (Phone phone : persona.getPhones()) {
			Phone newPhone = new Phone();
			newPhone.setNumber(phone.getNumber());
			newPhone.setCitycode(phone.getCitycode());
			newPhone.setContrycode(phone.getContrycode());
			phones.add(newPhone);
		}
		newPerona.setPhones(phones);
		return ResponseEntity.ok(personaRepository.save(newPerona));

	}

	@Override
	public ResponseEntity updatePersona(Persona persona) {
		Optional<Persona> personaDB = this.personaRepository.findById(persona.getId());
		Mensaje mensaje = new Mensaje();
		if (personaDB.isPresent() == false) {

			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mensaje.getError(4));
		}

		Persona personaUpdate = personaDB.get();
		personaUpdate.setIsactive(persona.getIsactive());
		personaUpdate.setName(persona.getName());
		personaUpdate.setEmail(persona.getEmail());
		personaUpdate.setPassword(persona.getPassword());
		personaRepository.save(personaUpdate);
		return ResponseEntity.ok(personaRepository.save(personaUpdate));

	}

	@Override
	public List<Persona> getAllPersona() {

		return this.personaRepository.findAll();
	}

	@Override
	public ResponseEntity getPersonaById(Long personaId) {
		Mensaje mensaje = new Mensaje();
		Optional<Persona> personaDB = this.personaRepository.findById(personaId);

		if (personaDB.isPresent() == false) {

			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mensaje.getError(4));
		}

		return ResponseEntity.ok(personaDB.get());
	}

	@Override
	public ResponseEntity deletePersona(Long personaId) {
		Mensaje mensaje = new Mensaje();
		Optional<Persona> personaDB = this.personaRepository.findById(personaId);

		if (personaDB.isPresent() == false) {

			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mensaje.getError(4));

		}

		this.personaRepository.delete(personaDB.get());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mensaje.getError(5));

	}

}

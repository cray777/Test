package com.nisum.test.controller;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.nisum.test.model.Persona;
import com.nisum.test.service.PersonaService;

@RestController
public class PersonaController {
	@Autowired
	private PersonaService personaService;

	@PostMapping("/Persona")
	public ResponseEntity<Persona> createPersona(@RequestBody Persona persona) {

		return this.personaService.createPersona(persona);
	}

	@GetMapping("/Persona")
	public ResponseEntity<List<Persona>> getAllPersona() {
		return ResponseEntity.ok().body(personaService.getAllPersona());
	}

	@GetMapping("/Persona/{id}")
	public ResponseEntity getPersonaById(@PathVariable long id) {
		return ResponseEntity.ok().body(personaService.getPersonaById(id));
	}

	@PutMapping("/Persona/{id}")
	public ResponseEntity updatePersona(@PathVariable long id, @RequestBody Persona persona) {
		persona.setId(id);
		return ResponseEntity.ok().body(this.personaService.updatePersona(persona));

	}

	@DeleteMapping("/Persona/{id}")
	public ResponseEntity deteltePersona(@PathVariable long id) {
		//;
		//return HttpStatus.OK;
		return ResponseEntity.ok().body(this.personaService.deletePersona(id));
	}

}

package com.nisum.test.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;

public class Mensaje {
	
	public Map<String, String> getError(int tipoError) {
		HashMap<String, String> map = new HashMap<>();
	    

		
		if(tipoError==1) {
			map.put("Mesaje: ", "El correo esta registrado");
		    map.put("HttpStatus", HttpStatus.BAD_REQUEST.toString());
		   
		}
		
		if(tipoError==2) {
			map.put("Mesaje: ", "el password debe contener una mayuscula, letras minúsculas, y dos numeros ");
		    map.put("HttpStatus", HttpStatus.BAD_REQUEST.toString());
		   
		}
		if(tipoError==3) {
			map.put("Mesaje: ", "El email ingresado es inválido.");
		    map.put("HttpStatus", HttpStatus.BAD_REQUEST.toString());
		   
		}
		

		return map;
	}
}

package com.nisum.test.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validaciones {

	public boolean  validaPassword(String password) {
	
		boolean retorno=true;
    char clave;
    byte  contNumero = 0, contLetraMay = 0, contLetraMin=0;
    for (byte i = 0; i < password.length(); i++) {
             clave = password.charAt(i);
            String passValue = String.valueOf(clave);
             if (passValue.matches("[A-Z]")) {
                 contLetraMay++;
             } else if (passValue.matches("[a-z]")) {
                 contLetraMin++;
             } else if (passValue.matches("[0-9]")) {
                 contNumero++;
             }
     }
     System.out.println("Cantidad de letras mayusculas:"+contLetraMay);
     System.out.println("Cantidad de letras minusculas:"+contLetraMin);
     System.out.println("Cantidad de numeros:"+contNumero);
      
     if(contLetraMay<=0) {
    	 return false;
     }
     if(contLetraMin<=0) {
    	 return false;
     }
     
     if(contNumero<=1) {
    	 return false;
     }
     
     return retorno;
	}
	
	public boolean validaEmail(String email) {
		
		Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
 
           
 
        Matcher retorno = pattern.matcher(email);
		
        return retorno.find();
        
	}
	
}

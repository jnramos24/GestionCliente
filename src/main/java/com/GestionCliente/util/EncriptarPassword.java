package com.GestionCliente.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

//Archivo de prueba para encriptar manualmente el password.
public class EncriptarPassword {
    
    public static void main(String[] args) {
        String password = "1234";
        System.out.println("password comun: " + password);
        System.out.println("password encriptado: " + encriptarPassword(password));
    }
    
    //Metodo encriptador
    public static String encriptarPassword(String password){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        
        return encoder.encode(password);
    }
}

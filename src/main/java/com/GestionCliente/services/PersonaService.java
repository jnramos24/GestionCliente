package com.GestionCliente.services;

import com.GestionCliente.entidades.Persona;
import java.util.List;


public interface PersonaService {
    
    public List<Persona> listarPersonas();
    
    public void Guardar(Persona persona);
    
    public void eliminarPersona(Persona persona);
    
    public Persona encontrarPersona(Persona persona);
}

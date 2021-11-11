package com.GestionCliente.repositorios;

import com.GestionCliente.entidades.Persona;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PersonaDao extends JpaRepository<Persona, Long> {
    
}

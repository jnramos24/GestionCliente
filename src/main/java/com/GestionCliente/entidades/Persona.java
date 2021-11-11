package com.GestionCliente.entidades;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;


@Data
@Entity
@Table(name = "persona")
public class Persona implements Serializable{
    
    //private static final long serialVersionUID=1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long idPersona;
    
    @NotEmpty(message="El nombre no puede estar vacio")
    private String nombre;
    @NotEmpty(message="El apellido no puede estar vacio")
    private String apellido;
    @NotEmpty(message="El email no puede estar vacio")
    @Email(message="Introduzca un email valido")
    private String email;
    private String telefono;
    

}

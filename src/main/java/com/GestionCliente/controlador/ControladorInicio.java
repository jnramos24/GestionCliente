package com.GestionCliente.controlador;

import com.GestionCliente.entidades.Persona;
import com.GestionCliente.services.PersonaService;
import java.util.List;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@Slf4j
public class ControladorInicio {
    
    @Autowired
    private PersonaService personaService;
    
    @GetMapping("/")
    public String inicio(Model model){
        
        List<Persona> personas = personaService.listarPersonas();
        
        log.info("Conexion con Spring");
        model.addAttribute("personas", personas);
        
        Double saldoTotal = 0D;
        for (Persona persona : personas) {
            saldoTotal += persona.getSaldo();
        }
        model.addAttribute("saldoTotal", saldoTotal);
        model.addAttribute("totalClientes",personas.size());
        return "index";
    }
    
    @GetMapping("/agregar")
    public String agregar(Persona persona){
    return "modificar";
    }
    
    @PostMapping("/guardar")
    public String guardar( @Valid Persona persona, BindingResult error){
        
        if (error.hasErrors()) {
            return "modificar";
        }
        personaService.Guardar(persona);
        return "redirect:/";
    }
    
    @GetMapping("/editar/{idPersona}")
    public String editar(Persona persona, Model model){
        persona = personaService.encontrarPersona(persona);
        model.addAttribute("persona", persona);
        return "modificar";
    }
    
    @GetMapping("/eliminar/{idPersona}")
    public String eliminar(Persona persona){
    personaService.eliminarPersona(persona);
    return "redirect:/";
    }

}

package com.tunombre.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.tunombre.modelos.Artista;
import com.tunombre.servicios.ServicioArtistas;

import jakarta.validation.Valid;

@Controller
public class ControladorArtistas {
	@Autowired
	private ServicioArtistas servicioArtistas;
	
	@GetMapping("/artistas")
	public String desplegarArtistas(Model modelo) {
		modelo.addAttribute("artistas", servicioArtistas.obtenerTodoslosArtistas());
		return "artistas";
	}
	@GetMapping("/artistas/detalle/{idArtista}")
	public String desplegarDetalleArtistas(@PathVariable("idArtista") Long id, Model modelo) {
		modelo.addAttribute("artista", servicioArtistas.obtenerArtistaPorId(id));
		return "detalleArtista";
	}
	
	  @GetMapping("/artistas/formulario/agregar/{idArtista}")
	    public String formularioAgregarArtista(@PathVariable Long idArtista, Model modelo) {
		modelo.addAttribute("artista", new Artista());
	        return "agregarArtista";  
	    }

	    @PostMapping("/artistas/procesa/agregar")
	    public String procesarAgregarArtista(@Valid @ModelAttribute Artista artista, BindingResult validaciones) {
	        if (validaciones.hasErrors()) {
	            return "agregarArtista";  
	        }
	        servicioArtistas.agregarArtista(artista);
	        return "redirect:/artistas";  
	}
	    
}

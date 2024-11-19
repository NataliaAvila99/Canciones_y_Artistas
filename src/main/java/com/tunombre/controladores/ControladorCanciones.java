package com.tunombre.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.tunombre.modelos.Cancion;
import com.tunombre.servicios.ServicioArtistas;
import com.tunombre.servicios.ServiciosCanciones;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;




@Controller
public class ControladorCanciones {
	@Autowired
	private ServicioArtistas servicioArtistas;

	@Autowired
	private ServiciosCanciones servicioCanciones;
	
	@GetMapping("/canciones")
	public String desplegarCanciones(Model modelo) {
		modelo.addAttribute("canciones", servicioCanciones.obtenerTodasLasCanciones());
		return "Canciones";
	}
	
	@GetMapping("/canciones/detalle/{id}")
	public String desplegarDetalleCancion(@PathVariable("id") long id, Model modelo) {
		modelo.addAttribute("cancion", servicioCanciones.obtenerCancionPorId(id));
		return "detalleCancion";
	}

    @GetMapping("/canciones/formulario/agregar/{idCancion}")
    public String formularioAgregarCancion(@PathVariable Long idCancion, Model model) {
        model.addAttribute("cancion", new Cancion());
        model.addAttribute("listaArtistas", servicioArtistas.obtenerTodoslosArtistas());
        return "agregarCancion";  
    }

    @PostMapping("/canciones/procesa/agregar")
    public String procesarAgregarCancion(@Valid @ModelAttribute Cancion cancion, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "agregarCancion";  
        }
        servicioCanciones.agregarCancion(cancion);
        return "redirect:/canciones";  
}
    
    @GetMapping("/canciones/formulario/editar/{idCancion}")
    public String formularioEditarCancion(@PathVariable("idCancion") Long idCancion, Model model) {
        Cancion cancion = servicioCanciones.obtenerCancionPorId(idCancion);
        if (cancion != null) {
            model.addAttribute("cancion", cancion);
            model.addAttribute("listaArtistas", servicioArtistas.obtenerTodoslosArtistas());
            return "editarCancion";
        }
        return "redirect:/canciones";  
    }

    
    @PutMapping("/canciones/procesa/editar/{idCancion}")
    public String procesarEditarCancion(@PathVariable("idCancion") Long idCancion,
                                        @Valid @ModelAttribute("cancion") Cancion cancion,
                                        BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "editarCancion";
        }
        cancion.setId(idCancion);
        servicioCanciones.actualizaCancion(cancion);
        return "redirect:/canciones";
    }

    
    @DeleteMapping("/canciones/eliminar/{idCancion}")
    public String procesarEliminarCancion(@PathVariable("idCancion") Long idCancion) {
    	this.servicioCanciones.eliminaCancion(idCancion);
    	return "redirect:/canciones";
    }
    }

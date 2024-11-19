package com.tunombre.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tunombre.modelos.Cancion;
import com.tunombre.repositorios.RepositorioCanciones;

@Service
public class ServiciosCanciones {

	@Autowired
	private RepositorioCanciones repositorio;
	

    public List<Cancion> obtenerTodasLasCanciones() {
        return (List<Cancion>)repositorio.findAll();
    }

    public Cancion obtenerCancionPorId(Long id) {
       return repositorio.findById(id).orElse(null);
    }
    
    public Cancion agregarCancion(Cancion cancion) {
        return repositorio.save(cancion);
    }
    public Cancion actualizaCancion(Cancion cancion) {
        return repositorio.save(cancion);
    }
    
    public void eliminaCancion(Long idLong) {
    	this.repositorio.deleteById(idLong);
    }
}

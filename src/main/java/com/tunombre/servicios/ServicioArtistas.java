package com.tunombre.servicios;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tunombre.modelos.Artista;
import com.tunombre.repositorios.RepositorioArtista;

@Service
public class ServicioArtistas {
	@Autowired
	private RepositorioArtista repositorioArtista;
	public List<Artista> obtenerTodoslosArtistas(){
		return (List<Artista>)repositorioArtista.findAll();
	}
	public Artista obtenerArtistaPorId(Long id) {
        return repositorioArtista.findById(id).orElse(null);
    }
	  public Artista agregarArtista(Artista artista) {
	        return repositorioArtista.save(artista);
	    }
}

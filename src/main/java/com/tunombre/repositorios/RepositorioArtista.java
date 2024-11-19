package com.tunombre.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tunombre.modelos.Artista;

@Repository
public interface RepositorioArtista extends CrudRepository<Artista , Long> {
	List<Artista> findAll();

}

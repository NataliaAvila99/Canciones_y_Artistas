package com.tunombre.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.tunombre.modelos.Cancion;

@Repository
public interface RepositorioCanciones extends CrudRepository<Cancion , Long> {
	List<Cancion> findAll();

}

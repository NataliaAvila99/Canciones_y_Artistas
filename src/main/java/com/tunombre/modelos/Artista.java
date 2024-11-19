package com.tunombre.modelos;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

@Entity
@Table(name = "artistas")
public class Artista {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String nombre;
	private String apellido;
	private String biografia;
	private LocalDateTime fecha_de_creacion;
	private LocalDateTime fecha_de_actualizacion;
	@OneToMany(mappedBy = "artista")
	private List<Cancion> listaCanciones;

	public Artista(long id, String nombre, String apellido, String biografia, LocalDateTime fecha_de_creacion,
			LocalDateTime fecha_de_actualizacion, List<Cancion> listaCanciones) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.biografia = biografia;
		this.fecha_de_creacion = fecha_de_creacion;
		this.fecha_de_actualizacion = fecha_de_actualizacion;
		this.listaCanciones = listaCanciones;
	}

	public Artista() {

		this.id = 0l;
		this.nombre = "";
		this.apellido = "";
		this.biografia = "";
		this.fecha_de_creacion = LocalDateTime.now();
		this.fecha_de_actualizacion = LocalDateTime.now();
		this.listaCanciones = new ArrayList<>();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getBiografia() {
		return biografia;
	}

	public void setBiografia(String biografia) {
		this.biografia = biografia;
	}

	public LocalDateTime getFecha_de_creacion() {
		return fecha_de_creacion;
	}

	public void setFecha_de_creacion(LocalDateTime fecha_de_creacion) {
		this.fecha_de_creacion = fecha_de_creacion;
	}

	public LocalDateTime getFecha_de_actualizacion() {
		return fecha_de_actualizacion;
	}

	public void setFecha_de_actualizacion(LocalDateTime fecha_de_actualizacion) {
		this.fecha_de_actualizacion = fecha_de_actualizacion;
	}

	public List<Cancion> getListaCanciones() {
		return listaCanciones;
	}

	public void setListaCanciones(List<Cancion> listaCanciones) {
		this.listaCanciones = listaCanciones;
	}

	@PrePersist
	private void onCreate() {
		this.fecha_de_actualizacion = LocalDateTime.now();
		this.fecha_de_creacion = LocalDateTime.now();
	}

	@PreUpdate
	private void onUpdate() {
		this.fecha_de_actualizacion = LocalDateTime.now();
	}

	@Override
	public String toString() {
		return "Artista [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", biografia=" + biografia
				+ ", fecha_de_creacion=" + fecha_de_creacion + ", fecha_de_actualizacion=" + fecha_de_actualizacion
				+ ", listaCanciones=" + listaCanciones + "]";
	}

}

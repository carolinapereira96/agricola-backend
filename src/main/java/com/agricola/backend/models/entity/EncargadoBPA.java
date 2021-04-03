package com.agricola.backend.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="encargados_bpa")
public class EncargadoBPA implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_encargado_bpa")
	private Long idEncargadoBPA;
	
	//length para definir tamaño, updatable para si es actualizable y nullable para ver si acepta null
	@Column(length = 50, nullable = false, updatable = true) 
	private String nombre;
	
	@Column(length = 12, nullable = false, updatable = false)
	private String rut;
	
	@Column(length = 12, nullable = false, updatable = false)
	private String telefono;
	
	@Column(length = 50, nullable = false, updatable = true)
	private String email;
	
	@Column(length = 16, nullable = false, updatable = true)
	private String pass;


	public Long getId_encargado_bpa() {
		return idEncargadoBPA;
	}

	public void setId_encargado_bpa(Long id_encargado_bpa) {
		this.idEncargadoBPA = id_encargado_bpa;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
	
	
	private static final long serialVersionUID = 1L;
}

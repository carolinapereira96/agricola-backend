package com.agricola.backend.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="duenos_campo")
public class DuenoCampo implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_dueno_campo")
	private Long idDuenoCampo;
	
	@Column(length = 50, nullable = false, updatable = true) 
	private String nombre;

	@Column(length = 12, nullable = false, updatable = false)
	private String rut;


	public Long getIdDuenoCampo() {
		return idDuenoCampo;
	}

	public void setIdDuenoCampo(Long idDuenoCampo) {
		this.idDuenoCampo = idDuenoCampo;
	}


	@Column(length = 50, nullable = false, updatable = true)
	private String email;

	@Column(length = 15, nullable = false, updatable = true) 
	private String pass;
	

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












	public String getEmail() {
		return email;
	}







	public void setEmail(String email) {
		this.email = email;
	}







	public String getPassword() {
		return pass;
	}







	public void setPassword(String pass) {
		this.pass = pass;
	}







	private static final long serialVersionUID = 1L;

	 
}

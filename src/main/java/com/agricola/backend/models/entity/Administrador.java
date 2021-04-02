package com.agricola.backend.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="administradores_campo")
public class Administrador  implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_administrador_campo")
	Long idAdministrador;

	private String nombre;
	private String rut;
	private String telefono;
	private String email;
	private String pass;
	
	
	
	public Long getId() {
		return idAdministrador;
	}



	public void setId(Long id) {
		this.idAdministrador = id;
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



	public String getPassword() {
		return pass;
	}



	public void setPassword(String password) {
		this.pass = password;
	}



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; 
}

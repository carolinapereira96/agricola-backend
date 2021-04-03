package com.agricola.backend.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "campos")
public class Campo implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_campo")
	private Long idCampo;

	@Column(length = 35, nullable = false, updatable = true)
	private String nombre;

	@Column(length = 80, nullable = false, updatable = true)
	private String direccion;

	@Column(nullable = false, updatable = true)
	private int hectareas;

	@Column(name = "id_dueno_campo", nullable = false, updatable = true)
	private Long idDuenoCampo;

	@Column(name = "id_administrador_campo", nullable = false, updatable = true)
	private Long idAdministradorCampo;

	
	
	public Long getIdCampo() {
		return idCampo;
	}

	public void setIdCampo(Long idCampo) {
		this.idCampo = idCampo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getHectareas() {
		return hectareas;
	}

	public void setHectareas(int hectareas) {
		this.hectareas = hectareas;
	}

	public Long getIdDuenoCampo() {
		return idDuenoCampo;
	}

	public void setIdDuenoCampo(Long idDuenoCampo) {
		this.idDuenoCampo = idDuenoCampo;
	}

	public Long getIdAdministradorCampo() {
		return idAdministradorCampo;
	}

	public void setIdAdministradorCampo(Long idAdministradorCampo) {
		this.idAdministradorCampo = idAdministradorCampo;
	}

	private static final long serialVersionUID = 1L;

}

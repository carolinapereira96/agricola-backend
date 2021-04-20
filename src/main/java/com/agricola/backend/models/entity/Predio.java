package com.agricola.backend.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "predios")
public class Predio implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_predio")
	private Long idPredio;

	@Column(length = 30, nullable = false, updatable = true)
	private String nombre;

	@Column(nullable = false, updatable = true)
	private int hectareas;

	@Column(name = "id_campo", nullable = false, updatable = true)
	private Long idCampo;

	
	
	public Long getIdPredio() {
		return idPredio;
	}

	public void setIdPredio(Long idPredio) {
		this.idPredio = idPredio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getHectareas() {
		return hectareas;
	}

	public void setHectareas(int hectareas) {
		this.hectareas = hectareas;
	}

	public Long getIdCampo() {
		return idCampo;
	}

	public void setIdCampo(Long idCampo) {
		this.idCampo = idCampo;
	}

	private static final long serialVersionUID = 1L;

}
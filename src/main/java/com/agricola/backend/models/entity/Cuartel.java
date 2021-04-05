package com.agricola.backend.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cuarteles")
public class Cuartel implements Serializable{

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_cuartel")
	private Long idCuartel;
	
	@Column(length = 30, nullable = false, updatable = true) 
	private String nombre;
	
	@Column(nullable = false, updatable = true) 
	private int hectareas;
	
	@Column(name="tipo_uva",length = 25, nullable = false, updatable = true)
	private String tipoUva;
	
	@Column(name="id_encargado_bpa", nullable = false, updatable = true)
	private int idEncargadoBPA;
	
	@Column(name="id_predio", nullable = false, updatable = true)
	private int idPredio;
	
	
	
	
	



	public Long getIdCuartel() {
		return idCuartel;
	}




	public void setIdCuartel(Long idCuartel) {
		this.idCuartel = idCuartel;
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




	public String getTipoUva() {
		return tipoUva;
	}




	public void setTipoUva(String tipoUva) {
		this.tipoUva = tipoUva;
	}




	public int getIdEncargadoBPA() {
		return idEncargadoBPA;
	}




	public void setIdEncargadoBPA(int idEncargadoBPA) {
		this.idEncargadoBPA = idEncargadoBPA;
	}




	public int getIdPredio() {
		return idPredio;
	}




	public void setIdPredio(int idPredio) {
		this.idPredio = idPredio;
	}




	private static final long serialVersionUID = 1L;
}
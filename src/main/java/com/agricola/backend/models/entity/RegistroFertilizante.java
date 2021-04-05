package com.agricola.backend.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="registros_fertilizantes")
public class RegistroFertilizante implements Serializable{

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_registro_fertilizante")
	private Long idRegistro;
	

	@Column(name = "metodo_aplicacion", length = 40, nullable = false, updatable = true)
	private String metodoAplicacion;

	@Column(name = "estado_fenologico", length = 40, nullable = false, updatable = true)
	private String estadoFenologico;
	
	@Temporal(TemporalType.DATE)
	@Column(nullable = false, updatable = true)
	private Date fecha;
	
	@Column(name = "cantidad_Aplicada", nullable = false, updatable = true)
	private double cantidadAplicada;
	
	
	@Column(name = "tipo_maquinaria", length = 25, nullable = false, updatable = true)
	private String tipoMaquinaria;

	@Column(name="id_encargado_bpa",nullable = false, updatable = true)
	private int idEncargadoBPA;

	@Column(name="id_fertilizante",nullable = false, updatable = true)
	private int idFertilizante;
	
	public Long getIdRegistro() {
		return idRegistro;
	}


	public void setIdRegistro(Long idRegistro) {
		this.idRegistro = idRegistro;
	}


	public String getMetodoAplicacion() {
		return metodoAplicacion;
	}


	public void setMetodoAplicacion(String metodoAplicacion) {
		this.metodoAplicacion = metodoAplicacion;
	}


	public String getEstadoFenologico() {
		return estadoFenologico;
	}


	public void setEstadoFenologico(String estadoFenologico) {
		this.estadoFenologico = estadoFenologico;
	}


	public Date getFecha() {
		return fecha;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	public double getCantidadAplicada() {
		return cantidadAplicada;
	}


	public void setCantidadAplicada(double cantidadAplicada) {
		this.cantidadAplicada = cantidadAplicada;
	}


	public String getTipoMaquinaria() {
		return tipoMaquinaria;
	}


	public void setTipoMaquinaria(String tipoMaquinaria) {
		this.tipoMaquinaria = tipoMaquinaria;
	}


	public int getIdEncargadoBPA() {
		return idEncargadoBPA;
	}


	public void setIdEncargadoBPA(int idEncargadoBPA) {
		this.idEncargadoBPA = idEncargadoBPA;
	}


	public int getIdFertilizante() {
		return idFertilizante;
	}


	public void setIdFertilizante(int idFertilizante) {
		this.idFertilizante = idFertilizante;
	}


	
	

	private static final long serialVersionUID = 1L;
}

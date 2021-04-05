package com.agricola.backend.models.services;

import java.util.List;

import com.agricola.backend.models.entity.Administrador;


public interface IAdministradorService {

	public List <Administrador> findAll();
	
	public Administrador save(Administrador adm);

	public void delete(Long id);

	public Administrador findById(Long id);

	
}

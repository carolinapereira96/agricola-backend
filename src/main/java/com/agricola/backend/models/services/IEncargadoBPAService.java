package com.agricola.backend.models.services;

import java.util.List;

import com.agricola.backend.models.entity.EncargadoBPA;

public interface IEncargadoBPAService {
	
	public List <EncargadoBPA> findAll();
	
	public EncargadoBPA save(EncargadoBPA encargadoBPA);
	
	public void delete(Long id);
	
	public EncargadoBPA findById(Long id);

}

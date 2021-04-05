package com.agricola.backend.models.services;

import java.util.List;
import com.agricola.backend.models.entity.DuenoCampo;

public interface IDuenoCampoService {
	

	public List <DuenoCampo> findAll();
	
	public DuenoCampo save(DuenoCampo duenoCampo);

	public void delete(Long id);

	public DuenoCampo findById(Long id);
}

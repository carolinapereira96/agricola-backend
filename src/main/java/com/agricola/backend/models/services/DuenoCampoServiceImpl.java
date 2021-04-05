package com.agricola.backend.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.agricola.backend.models.dao.IDuenoCampoDao;
import com.agricola.backend.models.entity.DuenoCampo;

@Service
public class DuenoCampoServiceImpl implements IDuenoCampoService{

	
	@Autowired
	private IDuenoCampoDao duenoCampoDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<DuenoCampo> findAll() {
		return (List<DuenoCampo>) duenoCampoDao.findAll();
	}

	@Override
	@Transactional
	public DuenoCampo save(DuenoCampo duenoCampo) {
		return duenoCampoDao.save(duenoCampo);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		duenoCampoDao.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public DuenoCampo findById(Long id) {
		return duenoCampoDao.findById(id).orElse(null);
	}
}

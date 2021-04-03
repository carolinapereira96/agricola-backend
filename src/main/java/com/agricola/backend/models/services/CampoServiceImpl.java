package com.agricola.backend.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.agricola.backend.models.dao.ICampoDao;
import com.agricola.backend.models.entity.Campo;

@Service
public class CampoServiceImpl implements ICampoService{
	
	@Autowired
	private ICampoDao campoDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Campo> findAll() {
		// TODO Auto-generated method stub
		return (List<Campo>) campoDao.findAll();
	}

	@Override
	@Transactional
	public Campo save(Campo campo) {
		return campoDao.save(campo);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		campoDao.deleteById(id);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Campo findById(Long id) {
		return campoDao.findById(id).orElse(null);
	}

}

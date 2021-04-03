package com.agricola.backend.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.agricola.backend.models.dao.IEncargadoBPADao;
import com.agricola.backend.models.entity.EncargadoBPA;

@Service
public class EncargadoBPAServiceImpl implements IEncargadoBPAService {

	@Autowired
	private IEncargadoBPADao encargadoBPADao;

	@Override
	@Transactional(readOnly = true)
	public List<EncargadoBPA> findAll() {
		return (List<EncargadoBPA>) encargadoBPADao.findAll();
	}

	@Override
	@Transactional
	public EncargadoBPA save(EncargadoBPA encargadoBPA) {
		return encargadoBPADao.save(encargadoBPA);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		encargadoBPADao.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public EncargadoBPA findById(Long id) {
		return encargadoBPADao.findById(id).orElse(null);
	}

}

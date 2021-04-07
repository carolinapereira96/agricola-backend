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
	public void delete(String run) {
		encargadoBPADao.deleteById(run);
	}

	@Override
	@Transactional(readOnly = true)
	public EncargadoBPA findById(String run) {
		return encargadoBPADao.findById(run).orElse(null);
	}

}

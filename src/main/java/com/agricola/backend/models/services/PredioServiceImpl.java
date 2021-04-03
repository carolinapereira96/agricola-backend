package com.agricola.backend.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.agricola.backend.models.dao.IPredioDao;
import com.agricola.backend.models.entity.Predio;

@Service
public class PredioServiceImpl implements IPredioService {

	@Autowired
	private IPredioDao predioDao;

	@Override
	@Transactional(readOnly = true)
	public List<Predio> findAll() {
		return (List<Predio>) predioDao.findAll();
	}

	@Override
	@Transactional
	public Predio save(Predio predio) {
		return predioDao.save(predio);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		predioDao.deleteById(id);

	}

	@Override
	@Transactional(readOnly = true)
	public Predio findById(Long id) {
		return predioDao.findById(id).orElse(null);
	}

}

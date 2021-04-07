package com.agricola.backend.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.agricola.backend.models.dao.IFitosanitarioDao;
import com.agricola.backend.models.entity.Fitosanitario;

@Service
public class FitosanitarioServiceImpl implements IFitosanitarioService {

	@Autowired
	private IFitosanitarioDao fitosanitarioDao;

	@Override
	@Transactional(readOnly = true)
	public List<Fitosanitario> findAll() {
		return (List<Fitosanitario>) fitosanitarioDao.findAll();
	}

	@Override
	@Transactional
	public Fitosanitario save(Fitosanitario fitosanitario) {
		return fitosanitarioDao.save(fitosanitario);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		fitosanitarioDao.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Fitosanitario findById(Long id) {
		return fitosanitarioDao.findById(id).orElse(null);
	}

}

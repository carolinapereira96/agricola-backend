package com.agricola.backend.models.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.agricola.backend.models.dao.IFertilizanteDao;
import com.agricola.backend.models.entity.Fertilizante;

@Service
public class FertilizanteServiceImpl implements IFertilizanteService{

	@Autowired
	private IFertilizanteDao fertilizanteDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Fertilizante> findAll() {
		return (List<Fertilizante>) fertilizanteDao.findAll();
	}

	@Override
	@Transactional
	public Fertilizante save(Fertilizante fertilizante) {
		return fertilizanteDao.save(fertilizante);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		fertilizanteDao.deleteById(id);

	}

	@Override
	@Transactional(readOnly = true)
	public Fertilizante findById(Long id) {
		return fertilizanteDao.findById(id).orElse(null);
	}



	 
}

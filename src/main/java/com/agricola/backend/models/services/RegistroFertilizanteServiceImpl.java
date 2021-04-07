package com.agricola.backend.models.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.agricola.backend.models.dao.IRegistroFertilizanteDao;
import com.agricola.backend.models.entity.RegistroFertilizante;

@Service
public class RegistroFertilizanteServiceImpl implements IRegistroFertilizanteService{

	
	@Autowired
	private IRegistroFertilizanteDao registroFertilizanteDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<RegistroFertilizante> findAll() {
		return (List<RegistroFertilizante>) registroFertilizanteDao.findAll();
	}

	@Override
	@Transactional
	public RegistroFertilizante save(RegistroFertilizante registro) {
		return registroFertilizanteDao.save(registro);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		registroFertilizanteDao.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public RegistroFertilizante findById(Long id) {
		return registroFertilizanteDao.findById(id).orElse(null);
	}

}

package com.agricola.backend.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.agricola.backend.models.dao.ICuartelDao;
import com.agricola.backend.models.entity.Cuartel;

@Service
public class CuartelServiceImpl implements ICuartelService {

	
	@Autowired
	private ICuartelDao cuartelDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Cuartel> findAll() {
		return (List<Cuartel>) cuartelDao.findAll();
	}

	@Override
	@Transactional
	public Cuartel save(Cuartel cuartel) {
		return cuartelDao.save(cuartel);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		cuartelDao.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Cuartel findById(Long id) {
		return cuartelDao.findById(id).orElse(null);
	}

}

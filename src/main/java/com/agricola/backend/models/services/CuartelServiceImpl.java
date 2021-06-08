package com.agricola.backend.models.services;

import java.util.List;
import java.util.stream.Collectors;
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
		List<Cuartel> list1 = (List<Cuartel>) cuartelDao.findAll();
	    List<Cuartel> listaFiltrada = list1.stream().filter(item->item.isEstado()).collect(Collectors.toList());
	    return listaFiltrada;
	}

	@Override
	@Transactional
	public Cuartel save(Cuartel cuartel) {
		cuartel.setEstado(true);
		return cuartelDao.save(cuartel);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		cuartelDao.findById(id).get().setEstado(false);
	}

	@Override
	@Transactional(readOnly = true)
	public Cuartel findById(Long id) {
		return cuartelDao.findById(id).orElse(null);
	}

	@Override
	public Cuartel findCuartelByNombre(String nombre) {
		// TODO Auto-generated method stub
		return cuartelDao.findCuartelByNombre(nombre);
	}

}

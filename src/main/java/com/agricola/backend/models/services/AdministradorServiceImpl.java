package com.agricola.backend.models.services;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.agricola.backend.models.dao.IAdministradorDao;
import com.agricola.backend.models.entity.Administrador;


@Service
public class AdministradorServiceImpl implements IAdministradorService{

	@Autowired
	private IAdministradorDao administradorDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Administrador> findAll() {
		List<Administrador> list1 = (List<Administrador>) administradorDao.findAll();
	    List<Administrador> listaFiltrada = list1.stream().filter(item->item.isEstado()).collect(Collectors.toList());
	    return listaFiltrada;
	}

	@Override
	@Transactional
	public Administrador save(Administrador administrador) {
		return administradorDao.save(administrador);
	}

	@Override
	@Transactional
	public void delete(String id) {
		 administradorDao.findById(id).get().setEstado(false);
	}

	@Override
	@Transactional(readOnly = true)
	public Administrador findById(String id) {
		return administradorDao.findById(id).orElse(null);
	}

}

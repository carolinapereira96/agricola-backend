package com.agricola.backend.models.services;

import java.util.List;

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
		// TODO Auto-generated method stub
		return (List<Administrador>) administradorDao.findAll();
	}

}

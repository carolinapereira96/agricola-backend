package com.agricola.backend.models.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.agricola.backend.models.dao.ICampoDao;
import com.agricola.backend.models.entity.Campo;

@Service
public class CampoServiceImpl implements ICampoService{
	
	@Autowired
	private ICampoDao campoDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Campo> findAll() {
		
		List<Campo> listCampos = (List<Campo>) campoDao.findAll();
		List<Campo> listCamposFiltrada = new ArrayList<Campo>();
		
		for(int i=0; i < listCampos.size(); i++) {
			if(listCampos.get(i).isEstado()) {
				listCamposFiltrada.add(listCampos.get(i));
			}
		}		
		return listCamposFiltrada;
	}

	@Override
	@Transactional
	public Campo save(Campo campo) {
		return campoDao.save(campo);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		campoDao.findById(id).orElse(null).setEstado(false);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Campo findById(Long id) {
		return campoDao.findById(id).orElse(null);
	}

}

 package com.agricola.backend.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.agricola.backend.models.entity.Administrador;

public interface IAdministradorDao extends CrudRepository<Administrador,String> {

}

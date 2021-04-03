package com.agricola.backend.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.agricola.backend.models.entity.Predio;

public interface IPredioDao extends CrudRepository<Predio, Long>{

}

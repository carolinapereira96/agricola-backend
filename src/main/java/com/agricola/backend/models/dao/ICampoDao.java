package com.agricola.backend.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.agricola.backend.models.entity.Campo;

public interface ICampoDao extends CrudRepository<Campo, Long>{

}

package com.agricola.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agricola.backend.models.entity.Administrador;
import com.agricola.backend.models.services.IAdministradorService;

@RestController
@RequestMapping("/api")
public class AdministradorRestController {

	 @Autowired
	 private IAdministradorService administradorService;
	 
	 @GetMapping("/administradores")
	 public List <Administrador> index() {
		return administradorService.findAll();
	}
}

package com.agricola.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.agricola.backend.models.entity.DuenoCampo;
import com.agricola.backend.models.services.IDuenoCampoService;

@RestController
@RequestMapping("/api")
public class DuenoCampoRestController {

	
	@Autowired
	 private IDuenoCampoService duenoCampoService;
	
	 
	 
	 @GetMapping("/duenos")
	 public List<DuenoCampo> listarDuenos() {
		return duenoCampoService.findAll();
	}
	 
	 @GetMapping("/duenos/{id}")
	 public DuenoCampo buscarDueno(@PathVariable Long id) {
			return duenoCampoService.findById(id);
     }
 
    @PostMapping("/duenos") 
	@ResponseStatus(HttpStatus.CREATED)
	public DuenoCampo crearDueno(@RequestBody DuenoCampo dueno) {
		return duenoCampoService.save(dueno);
	}

	@PutMapping("/duenos/{id}") 
	@ResponseStatus(HttpStatus.CREATED) 
	public DuenoCampo actualizarDueno(@RequestBody DuenoCampo dueno, @PathVariable Long id) {

		DuenoCampo duenoActual = duenoCampoService.findById(id);
		duenoActual.setNombre(dueno.getNombre());
		duenoActual.setRut(dueno.getRut());
		duenoActual.setEmail(dueno.getEmail());
		duenoActual.setPassword(dueno.getPassword());
		return duenoCampoService.save(duenoActual);
	}

	@DeleteMapping("/duenos/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT) 
	public void eliminarDueno(@PathVariable Long id) {
		duenoCampoService.delete(id);
	}
 
}

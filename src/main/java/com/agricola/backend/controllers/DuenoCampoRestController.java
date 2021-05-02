package com.agricola.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
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

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class DuenoCampoRestController {

	
	@Autowired
	 private IDuenoCampoService duenoCampoService;
	 
	 @GetMapping("/duenos")
	 public List<DuenoCampo> listarDuenos() {
		return duenoCampoService.findAll();
	}
	 
	 @GetMapping("/duenos/{run}")
	 public DuenoCampo buscarDueno(@PathVariable String run) {
			return duenoCampoService.findById(run);
     }
 
    @PostMapping("/duenos") 
	@ResponseStatus(HttpStatus.CREATED)
	public DuenoCampo crearDueno(@RequestBody DuenoCampo dueno) {

		return duenoCampoService.save(dueno);
	}

	@PutMapping("/duenos/{run}") 
	@ResponseStatus(HttpStatus.CREATED) 
	public DuenoCampo actualizarDueno(@RequestBody DuenoCampo dueno, @PathVariable String run) {

		DuenoCampo duenoActual = duenoCampoService.findById(run);
		duenoActual.setNombre(dueno.getNombre());
		duenoActual.setEmail(dueno.getEmail());
		duenoActual.setPassword(dueno.getPassword());
		return duenoCampoService.save(duenoActual);
	}

	@DeleteMapping("/duenos/{run}")
	@ResponseStatus(HttpStatus.NO_CONTENT) 
	public void eliminarDueno(@PathVariable String run) {
		duenoCampoService.delete(run);
	}
 
}

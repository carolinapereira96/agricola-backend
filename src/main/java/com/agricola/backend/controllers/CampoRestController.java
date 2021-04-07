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

import com.agricola.backend.models.entity.Campo;
import com.agricola.backend.models.services.ICampoService;

@RestController
@RequestMapping("/api")
public class CampoRestController {
	
	@Autowired
	private ICampoService campoService;

	@GetMapping("/campos") // okei
	public List<Campo> listaCampos() {
		return campoService.findAll();
	}
	
	@GetMapping("/campos/{id}") // okei
	public Campo buscarCampo(@PathVariable Long id) {
		return campoService.findById(id);
	}

	@PostMapping("/campos") // okei
	@ResponseStatus(HttpStatus.CREATED)
	public Campo crearCampo(@RequestBody Campo campo) {
		return campoService.save(campo);
	}

	@PutMapping("/campos/{id}") 
	@ResponseStatus(HttpStatus.CREATED) // okei
	public Campo actualizarCampo(@RequestBody Campo campo, @PathVariable Long id) {

		Campo campoActual = campoService.findById(id);

		campoActual.setNombre(campo.getNombre());
		campoActual.setDireccion(campo.getDireccion());
		campoActual.setHectareas(campo.getHectareas());

		return campoService.save(campoActual);

	}

	@DeleteMapping("/campos/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT) // okei
	public void eliminarCampo(@PathVariable Long id) {

		campoService.delete(id);
	}
}

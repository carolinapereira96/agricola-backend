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

import com.agricola.backend.models.entity.Predio;
import com.agricola.backend.models.services.IPredioService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class PredioRestController {
	

	@Autowired
	private IPredioService predioService;

	@GetMapping("/predios") // okei
	public List<Predio> listaPredios() {
		return predioService.findAll();
	}
	
	@GetMapping("/predios/{id}") // okei
	public Predio buscarPredio(@PathVariable Long id) {
		return predioService.findById(id);
	}

	@PostMapping("/predios") // okei
	@ResponseStatus(HttpStatus.CREATED)
	public Predio crearFitosanitario(@RequestBody Predio predio) {
		return predioService.save(predio);
	}

	@PutMapping("/predios/{id}") // okei
	@ResponseStatus(HttpStatus.CREATED) 
	public Predio actualizarPredio(@RequestBody Predio predio, @PathVariable Long id) {

		Predio predioActual = predioService.findById(id);

		predioActual.setNombre(predio.getNombre());
		predioActual.setHectareas(predio.getHectareas());

		return predioService.save(predioActual);

	}

	@DeleteMapping("/predios/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT) // okei
	public void eliminarPredio(@PathVariable Long id) {

		predioService.delete(id);
	}

}

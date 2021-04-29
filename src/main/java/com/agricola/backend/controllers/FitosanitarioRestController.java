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

import com.agricola.backend.models.entity.Fitosanitario;
import com.agricola.backend.models.services.IFitosanitarioService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class FitosanitarioRestController {
	
	@Autowired
	private IFitosanitarioService fitosanitarioService;

	@GetMapping("/fitosanitarios") // okei
	public List<Fitosanitario> listaFitosanitarios() {
		return fitosanitarioService.findAll();
	}
	
	@GetMapping("/fitosanitarios/{id}") // okei
	public Fitosanitario buscarFitosanitarioById(@PathVariable Long id) {
		return fitosanitarioService.findById(id);
	}

	@PostMapping("/fitosanitarios")
	@ResponseStatus(HttpStatus.CREATED) // okei
	public Fitosanitario crearFitosanitario(@RequestBody Fitosanitario fitosanitario) {
		return fitosanitarioService.save(fitosanitario);
	}

	@PutMapping("/fitosanitarios/{id}")
	@ResponseStatus(HttpStatus.CREATED) // okei
	public Fitosanitario actualizarFitosanitario(@RequestBody Fitosanitario fitosanitario, @PathVariable Long id) {

		Fitosanitario fitosanitarioActual = fitosanitarioService.findById(id);

		fitosanitarioActual.setNombreComercial(fitosanitario.getNombreComercial());
		fitosanitarioActual.setObjetivo(fitosanitario.getObjetivo());
		fitosanitarioActual.setIngredienteActivo(fitosanitario.getIngredienteActivo());
		fitosanitarioActual.setMojamiento(fitosanitario.getMojamiento());
		fitosanitarioActual.setCarencia(fitosanitario.getCarencia());

		return fitosanitarioService.save(fitosanitarioActual);

	}

	@DeleteMapping("/fitosanitarios/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT) // okei
	public void eliminarFitosanitario(@PathVariable Long id) {

		fitosanitarioService.delete(id);
	}

}

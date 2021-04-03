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
import com.agricola.backend.models.entity.EncargadoBPA;
import com.agricola.backend.models.services.IEncargadoBPAService;

@RestController
@RequestMapping("/api")
public class EncargadoBPARestController {

	@Autowired
	private IEncargadoBPAService encargadoBPAService;

	@GetMapping("/encargadosBPA") // okei
	public List<EncargadoBPA> listaEncargadosBPA() {
		return encargadoBPAService.findAll();
	}

	@GetMapping("/encargadosBPA/{id}") // okei
	public EncargadoBPA buscarEncargadoBPAById(@PathVariable Long id) {
		return encargadoBPAService.findById(id);
	}

	@PostMapping("/encargadosBPA")
	@ResponseStatus(HttpStatus.CREATED) // okei
	public EncargadoBPA crearEncargadoBPA(@RequestBody EncargadoBPA encargadoBPA) {
		return encargadoBPAService.save(encargadoBPA);
	}

	@PutMapping("/encargadosBPA/{id}")
	@ResponseStatus(HttpStatus.CREATED) // okei
	public EncargadoBPA actualizarEncargadoBPA(@RequestBody EncargadoBPA encargadoBPA, @PathVariable Long id) {

		EncargadoBPA encargadoBPAActual = encargadoBPAService.findById(id);

		encargadoBPAActual.setNombre(encargadoBPA.getNombre());
		encargadoBPAActual.setRut(encargadoBPA.getRut());
		encargadoBPAActual.setTelefono(encargadoBPA.getTelefono());
		encargadoBPAActual.setEmail(encargadoBPA.getEmail());
		encargadoBPAActual.setPass(encargadoBPA.getPass());

		return encargadoBPAService.save(encargadoBPAActual);

	}

	@DeleteMapping("/encargadosBPA/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT) // okei
	public void eliminarEncargadoBPA(@PathVariable Long id) {

		encargadoBPAService.delete(id);
	}
}

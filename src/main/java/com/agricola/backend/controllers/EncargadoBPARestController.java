package com.agricola.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
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
import com.agricola.backend.models.entity.EncargadoBPA;
import com.agricola.backend.models.services.IEncargadoBPAService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class EncargadoBPARestController {

	@Autowired
	private IEncargadoBPAService encargadoBPAService;

	@Secured({ "ROLE_ADMIN", "ROLE_ADMINCAMPO", "ROLE_DUENO" })
	@GetMapping("/encargadosBPA") // okei
	public List<EncargadoBPA> listaEncargadosBPA() {
		return encargadoBPAService.findAll();
	}

	@Secured({ "ROLE_ADMIN", "ROLE_DUENO" })
	@GetMapping("/encargadosBPA/{run}") // okei
	public EncargadoBPA buscarEncargadoBPAById(@PathVariable String run) {
		return encargadoBPAService.findById(run);
	}

	@Secured({ "ROLE_ADMIN", "ROLE_DUENO" })
	@PostMapping("/encargadosBPA")
	@ResponseStatus(HttpStatus.CREATED) // okei
	public EncargadoBPA crearEncargadoBPA(@RequestBody EncargadoBPA encargadoBPA) {
		return encargadoBPAService.save(encargadoBPA);
	}

	@Secured({ "ROLE_ADMIN", "ROLE_DUENO" })
	@PutMapping("/encargadosBPA/{run}")
	@ResponseStatus(HttpStatus.CREATED) // okei
	public EncargadoBPA actualizarEncargadoBPA(@RequestBody EncargadoBPA encargadoBPA, @PathVariable String run) {

		EncargadoBPA encargadoBPAActual = encargadoBPAService.findById(run);

		encargadoBPAActual.setNombre(encargadoBPA.getNombre());
		encargadoBPAActual.setTelefono(encargadoBPA.getTelefono());
		encargadoBPAActual.setEmail(encargadoBPA.getEmail());
		encargadoBPAActual.setPass(encargadoBPA.getPass());

		return encargadoBPAService.save(encargadoBPAActual);

	}

	@Secured({ "ROLE_ADMIN", "ROLE_DUENO" })
	@DeleteMapping("/encargadosBPA/{run}")
	@ResponseStatus(HttpStatus.NO_CONTENT) // okei
	public void eliminarEncargadoBPA(@PathVariable String run) {

		encargadoBPAService.delete(run);
	}
}

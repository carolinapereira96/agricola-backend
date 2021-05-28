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
import com.agricola.backend.models.entity.Cuartel;
import com.agricola.backend.models.services.ICuartelService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class CuartelRestController {

	@Autowired
	private ICuartelService cuartelService;

	@Secured({ "ROLE_ADMIN", "ROLE_ADMINCAMPO", "ROLE_DUENO" })
	@GetMapping("/cuarteles")
	public List<Cuartel> listarCuarteles() {
		return cuartelService.findAll();
	}

	@Secured({ "ROLE_ADMIN", "ROLE_ADMINCAMPO", "ROLE_DUENO" })
	@GetMapping("/cuarteles/{id}")
	public Cuartel buscarCuarteles(@PathVariable Long id) {
		return cuartelService.findById(id);
	}

	@Secured({ "ROLE_ADMIN", "ROLE_ADMINCAMPO", "ROLE_DUENO" })
	@PostMapping("/cuarteles")
	@ResponseStatus(HttpStatus.CREATED)
	public Cuartel crearCuartel(@RequestBody Cuartel cuartel) {
		return cuartelService.save(cuartel);
	}

	@Secured({ "ROLE_ADMIN", "ROLE_ADMINCAMPO", "ROLE_DUENO" })
	@PutMapping("/cuarteles/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Cuartel actualizarcuartel(@RequestBody Cuartel cuartel, @PathVariable Long id) {

		Cuartel cuartelActual = cuartelService.findById(id);
		cuartelActual.setNombre(cuartel.getNombre());
		cuartelActual.setHectareas(cuartel.getHectareas());
		cuartelActual.setTipoUva(cuartel.getTipoUva());

		return cuartelService.save(cuartelActual);
	}

	@Secured({ "ROLE_ADMIN", "ROLE_ADMINCAMPO", "ROLE_DUENO" })
	@DeleteMapping("/cuarteles/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void eliminarCuartel(@PathVariable Long id) {
		cuartelService.delete(id);
	}

}

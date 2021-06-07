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

import com.agricola.backend.models.entity.RegistroFitosanitario;
import com.agricola.backend.models.services.IRegistroFitosanitarioService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class RegistroFitosanitarioRestController {

	@Autowired
	private IRegistroFitosanitarioService registroFitosanitarioService;

	@Secured({ "ROLE_ADMIN", "ROLE_ENCARGADOBPA","ROLE_ADMINCAMPO", "ROLE_DUENO" })
	@GetMapping("/registrosFitosanitarios") // okei
	public List<RegistroFitosanitario> listaFitosanitarios() {
		return registroFitosanitarioService.findAll();
	}

	@Secured({ "ROLE_ADMIN", "ROLE_ENCARGADOBPA","ROLE_ADMINCAMPO", "ROLE_DUENO" })
	@GetMapping("/registrosFitosanitarios/{id}") // okei
	public RegistroFitosanitario buscarRegistroFitosanitarioById(@PathVariable Long id) {
		return registroFitosanitarioService.findById(id);
	}

	@Secured({ "ROLE_ADMIN", "ROLE_ENCARGADOBPA" })
	@PostMapping("/registrosFitosanitarios")
	@ResponseStatus(HttpStatus.CREATED) // okei
	public RegistroFitosanitario crearRegistroFitosanitario(@RequestBody RegistroFitosanitario registroFitosanitario) {
		return registroFitosanitarioService.save(registroFitosanitario);
	}

	@Secured({ "ROLE_ADMIN", "ROLE_ENCARGADOBPA" })
	@PutMapping("/registrosFitosanitarios/{id}")
	@ResponseStatus(HttpStatus.CREATED) // okei
	public RegistroFitosanitario actualizarFitosanitario(@RequestBody RegistroFitosanitario registroFitosanitario,
			@PathVariable Long id) {

		RegistroFitosanitario registroFitosanitarioActual = registroFitosanitarioService.findById(id);

		registroFitosanitarioActual.setTipoMaquinaria(registroFitosanitario.getTipoMaquinaria());
		registroFitosanitarioActual.setEstadoFenologico(registroFitosanitario.getEstadoFenologico());
		registroFitosanitarioActual.setDosis(registroFitosanitario.getDosis());
		registroFitosanitarioActual.setFecha(registroFitosanitario.getFecha());
		registroFitosanitarioActual.setHoraTermino(registroFitosanitario.getHoraTermino());
		registroFitosanitarioActual.setCondicionesMetereologicas(registroFitosanitario.getCondicionesMetereologicas());

		return registroFitosanitarioService.save(registroFitosanitarioActual);

	}

	@Secured({ "ROLE_ADMIN", "ROLE_ENCARGADOBPA" })
	@DeleteMapping("/registrosFitosanitarios/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT) // okei
	public void eliminarRegistroFitosanitario(@PathVariable Long id) {

		registroFitosanitarioService.delete(id);
	}

}

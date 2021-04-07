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

import com.agricola.backend.models.entity.RegistroFitosanitario;
import com.agricola.backend.models.services.IRegistroFitosanitarioService;

@RestController
@RequestMapping("/api")
public class RegistroFitosanitarioRestController {
	
	@Autowired
	private IRegistroFitosanitarioService registroFitosanitarioService;

	@GetMapping("/registrosFitosanitarios") // okei
	public List<RegistroFitosanitario> listaFitosanitarios() {
		return registroFitosanitarioService.findAll();
	}
	
	@GetMapping("/registrosFitosanitarios/{id}") // okei
	public RegistroFitosanitario buscarRegistroFitosanitarioById(@PathVariable String run) {
		return registroFitosanitarioService.findById(run);
	}

	@PostMapping("/registrosFitosanitarios")
	@ResponseStatus(HttpStatus.CREATED) // okei
	public RegistroFitosanitario crearRegistroFitosanitario(@RequestBody RegistroFitosanitario registroFitosanitario) {
		return registroFitosanitarioService.save(registroFitosanitario);
	}

	@PutMapping("/registrosFitosanitarios/{id}")
	@ResponseStatus(HttpStatus.CREATED)  // okei
	public RegistroFitosanitario actualizarFitosanitario(@RequestBody RegistroFitosanitario registroFitosanitario, @PathVariable String run) {

		RegistroFitosanitario registroFitosanitarioActual = registroFitosanitarioService.findById(run);

		registroFitosanitarioActual.setTipoMaquinaria(registroFitosanitario.getTipoMaquinaria());
		registroFitosanitarioActual.setEstadoFenologico(registroFitosanitario.getEstadoFenologico());
		registroFitosanitarioActual.setDosis(registroFitosanitario.getDosis());
		registroFitosanitarioActual.setFecha(registroFitosanitario.getFecha());
		registroFitosanitarioActual.setHoraTermino(registroFitosanitario.getHoraTermino());
		registroFitosanitarioActual.setCondicionesMetereologicas(registroFitosanitario.getCondicionesMetereologicas());
		

		return registroFitosanitarioService.save(registroFitosanitarioActual);

	}

	@DeleteMapping("/registrosFitosanitarios/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT) // okei
	public void eliminarRegistroFitosanitario(@PathVariable String run) {

		registroFitosanitarioService.delete(run);
	}

}

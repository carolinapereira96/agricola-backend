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

import com.agricola.backend.models.entity.RegistroFertilizante;
import com.agricola.backend.models.services.IRegistroFertilizanteService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class RegistroFertilizanteRestController {

	@Autowired
	private IRegistroFertilizanteService registroFertilizanteService;

	@Secured({ "ROLE_ADMIN", "ROLE_ENCARGADOBPA", "ROLE_DUENO","ROLE_ADMINCAMPO" })
	@GetMapping("/registrosFertilizantes")
	public List<RegistroFertilizante> listarRegistrosFertilizantes() {

		return registroFertilizanteService.findAll();
	}

	@Secured({ "ROLE_ADMIN", "ROLE_ENCARGADOBPA" ,"ROLE_ADMINCAMPO", "ROLE_DUENO"})
	@GetMapping("/registrosFertilizantes/{id}")
	public RegistroFertilizante buscarRegistro(@PathVariable Long id) {
		return registroFertilizanteService.findById(id);
	}

	@Secured({ "ROLE_ADMIN", "ROLE_ENCARGADOBPA" })
	@PostMapping("/registrosFertilizantes")
	@ResponseStatus(HttpStatus.CREATED)
	public RegistroFertilizante crearRegsitro(@RequestBody RegistroFertilizante registro) {
		return registroFertilizanteService.save(registro);
	}

	@Secured({ "ROLE_ADMIN", "ROLE_ENCARGADOBPA" })
	@PutMapping("/registrosFertilizantes/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public RegistroFertilizante actualizarRegistro(@RequestBody RegistroFertilizante registro, @PathVariable Long id) {

		RegistroFertilizante registroActual = registroFertilizanteService.findById(id);
		registroActual.setMetodoAplicacion(registro.getMetodoAplicacion());
		registroActual.setEstadoFenologico(registro.getEstadoFenologico());
		registroActual.setFecha(registro.getFecha());
		registroActual.setCantidadAplicada(registro.getCantidadAplicada());
		registroActual.setTipoMaquinaria(registro.getTipoMaquinaria());
		return registroFertilizanteService.save(registroActual);
	}

	@Secured({ "ROLE_ADMIN", "ROLE_ENCARGADOBPA" })
	@DeleteMapping("/registrosFertilizantes/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void eliminarRegistro(@PathVariable Long id) {
		registroFertilizanteService.delete(id);
	}
}

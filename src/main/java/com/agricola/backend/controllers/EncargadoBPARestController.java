package com.agricola.backend.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
	@GetMapping("/encargadosBPA") 
	public List<EncargadoBPA> listaEncargadosBPA() {
		return encargadoBPAService.findAll();
	}

	@Secured({ "ROLE_ADMIN", "ROLE_DUENO" })
	@GetMapping("/encargadosBPA/{run}") 
	public ResponseEntity<?> buscarEncargadoBPAById(@PathVariable String run) {

		EncargadoBPA encargado = null;
		Map<String, Object> response = new HashMap<>();

		try {
			encargado = encargadoBPAService.findById(run);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		if (encargado == null) {
			response.put("mensaje", "El Encargado BPA con RUN : ".concat(run.concat(" no existe en la base de datos")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<EncargadoBPA>(encargado, HttpStatus.OK);
	}

	@Secured({ "ROLE_ADMIN", "ROLE_DUENO" })
	@PostMapping("/encargadosBPA")
	public ResponseEntity<?> crearEncargadoBPA(@RequestBody EncargadoBPA encargadoBPA) {

		Map<String, Object> response = new HashMap<>();

		if (encargadoBPAService.findEncargadoByRun(encargadoBPA.getRun()) != null) {
			response.put("mensaje", "Error, el rut ya existe");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_ACCEPTABLE);
		}

		if (encargadoBPAService.findEncargadoByTelefono(encargadoBPA.getTelefono()) != null) {
			response.put("mensaje", "Error, el telefono ya existe");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_ACCEPTABLE);
		}

		if (encargadoBPAService.findEncargadoByEmail(encargadoBPA.getEmail()) != null) {
			response.put("mensaje", "Error, el email ya existe");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_ACCEPTABLE);
		}

		EncargadoBPA encargado = null;
		try {
			encargado = encargadoBPAService.save(encargadoBPA);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al guardar el Encargado BPA");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El encargado ha sido creado con éxito!!");
		response.put("encargado", encargado);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

	@Secured({ "ROLE_ADMIN", "ROLE_DUENO" })
	@PutMapping("/encargadosBPA/{run}")
	public ResponseEntity<?> actualizarEncargadoBPA(@RequestBody EncargadoBPA encargadoBPA, @PathVariable String run) {

		Map<String, Object> response = new HashMap<>();

		EncargadoBPA encargadoBPAActual = encargadoBPAService.findById(run);

		EncargadoBPA encargadoActualizado = null;

		if (!encargadoBPAActual.getTelefono().trim().equalsIgnoreCase(encargadoBPA.getTelefono().trim())) {

			if (encargadoBPAService.findEncargadoByTelefono(encargadoBPA.getTelefono().trim()) != null) {
				response.put("mensaje", "Error, el telefono ya existe");
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_ACCEPTABLE);
			}
		}

		if (!encargadoBPAActual.getEmail().trim().equalsIgnoreCase(encargadoBPA.getEmail().trim())) {

			System.out.println("entre al primer if");
			System.out.println(encargadoBPAService.findEncargadoByEmail("natalia_urra@gmail.com"));

			if (encargadoBPAService.findEncargadoByEmail(encargadoBPA.getEmail().trim()) != null) {
				System.out.println("entre al segundo if");
				response.put("mensaje", "Error, el email ya existe");
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_ACCEPTABLE);
			}
		}

		encargadoBPAActual.setNombre(encargadoBPA.getNombre());
		encargadoBPAActual.setTelefono(encargadoBPA.getTelefono());
		encargadoBPAActual.setEmail(encargadoBPA.getEmail());
		encargadoBPAActual.setPass(encargadoBPA.getPass());

		try {
			encargadoActualizado = encargadoBPAService.save(encargadoBPAActual);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al actualizar al Encargado BPA en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "El encargado ha sido actualizado con éxito!!");
		response.put("encargado", encargadoActualizado);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);

	}

	@Secured({ "ROLE_ADMIN", "ROLE_DUENO" })
	@DeleteMapping("/encargadosBPA/{run}")
	public ResponseEntity<?> eliminarEncargadoBPA(@PathVariable String run) {
		Map<String, Object> response = new HashMap<>();

		if (encargadoBPAService.findEncargadoByRun(run) == null) {
			response.put("mensaje", "Error, el encargado a eliminar no existe en la base de datos");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		try {
			encargadoBPAService.delete(run);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al eliminar al Encargado BPA en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El encargado fue eliminado con éxito");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
}

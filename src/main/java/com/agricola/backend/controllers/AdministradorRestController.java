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

import com.agricola.backend.models.entity.Administrador;
import com.agricola.backend.models.services.IAdministradorService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class AdministradorRestController {

		 @Autowired
		 private IAdministradorService administradorService;
		 
		
		
		 @GetMapping("/administradores")
		 public List <Administrador> listarAdministradores() {
           return administradorService.findAll();
		}
		
		 @GetMapping("/administradores/{run}")
		 public Administrador buscarAdministrador(@PathVariable String run) {
				return administradorService.findById(run);
	     }
	 
	    @PostMapping("/administradores") 
		@ResponseStatus(HttpStatus.CREATED)
		public Administrador crearAdministrador(@RequestBody Administrador adm) {
	    
			return administradorService.save(adm);
		}

		@PutMapping("/administradores/{run}") 
		@ResponseStatus(HttpStatus.CREATED) 
		public Administrador actualizarAdministrador(@RequestBody Administrador adm, @PathVariable String run) {

			Administrador administradorActual = administradorService.findById(run);
			administradorActual.setNombre(adm.getNombre());
			administradorActual.setTelefono(adm.getTelefono());
			administradorActual.setEmail(adm.getEmail());
			administradorActual.setPassword(adm.getPassword());
			return administradorService.save(administradorActual);
		}

		@DeleteMapping("/administradores/{run}")
		@ResponseStatus(HttpStatus.NO_CONTENT) 
		public void eliminarAdministrador(@PathVariable String run) {
			administradorService.delete(run);
		}
	 
}

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
import com.agricola.backend.models.entity.Fertilizante;
import com.agricola.backend.models.services.IFertilizanteService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class FertilizanteRestController {

		@Autowired
		 private IFertilizanteService fertilizanteService;
		
		 @GetMapping("/fertilizantes")
		 public List <Fertilizante> listarFertilizantes() {
			return fertilizanteService.findAll();
		}
		 
		 @GetMapping("/fertilizantes/{id}")
		 public Fertilizante buscarFertilizante(@PathVariable Long id) {
				return fertilizanteService.findById(id);
	     }
		 
	    @PostMapping("/fertilizantes") 
		@ResponseStatus(HttpStatus.CREATED)
		public Fertilizante crearFertilizante(@RequestBody Fertilizante fertilizante) {
			return fertilizanteService.save(fertilizante);
		}

		@PutMapping("/fertilizantes/{id}") 
		@ResponseStatus(HttpStatus.CREATED) 
		public Fertilizante actualizarFertilizante(@RequestBody Fertilizante fertilizante, @PathVariable Long id) {

			Fertilizante fertilizanteActual = fertilizanteService.findById(id);
			fertilizanteActual.setNombreComercial(fertilizante.getNombreComercial());
			fertilizanteActual.setConcentracion(fertilizante.getConcentracion());
			fertilizanteActual.setTipo(fertilizante.getTipo());
			fertilizanteActual.setVariedad(fertilizante.getVariedad());
			
			return fertilizanteService.save(fertilizanteActual);
		}

		@DeleteMapping("/fertilizantes/{id}")
		@ResponseStatus(HttpStatus.NO_CONTENT) 
		public void eliminarFertilizante(@PathVariable Long id) {
			fertilizanteService.delete(id);
		}
	 
	
	
}

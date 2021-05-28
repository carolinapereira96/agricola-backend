package com.agricola.backend.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
import com.agricola.backend.models.entity.Role;
import com.agricola.backend.models.entity.Usuario;
import com.agricola.backend.models.services.IEncargadoBPAService;
import com.agricola.backend.models.services.IRoleService;
import com.agricola.backend.models.services.IUsuarioService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class EncargadoBPARestController {

	
	@Autowired
	private IRoleService roleService;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private IUsuarioService userService;
	
	@Autowired
	private IEncargadoBPAService encargadoBPAService;

	@Secured({ "ROLE_ADMIN", "ROLE_ADMINCAMPO", "ROLE_DUENO" })
	@GetMapping("/encargadosBPA") 
	public List<EncargadoBPA> listaEncargadosBPA() {
		return encargadoBPAService.findAll();
	}

	@Secured({ "ROLE_ADMIN", "ROLE_DUENO" })
	@GetMapping("/encargadosBPA/{run}") 
	public EncargadoBPA buscarEncargadoBPAById(@PathVariable String run) {
		return encargadoBPAService.findById(run);
	}

	@Secured({ "ROLE_ADMIN", "ROLE_DUENO" })
	@PostMapping("/encargadosBPA")
	@ResponseStatus(HttpStatus.CREATED) 
	public EncargadoBPA crearEncargadoBPA(@RequestBody EncargadoBPA encargadoBPA) {
		List<Role> list1 = (List<Role>) roleService.findAll();
	    List<Role> listaFiltrada = list1.stream().filter(item->item.getNombre().equalsIgnoreCase("ROLE_ENCARGADOBPA")).collect(Collectors.toList());
        Usuario user = new Usuario();
        user.setUsername(encargadoBPA.getRun());
        user.setNombre(encargadoBPA.getNombre());
        user.setEnabled(true);
        user.setEmail(encargadoBPA.getEmail());
        user.setPassword(passwordEncoder.encode(encargadoBPA.getPass()));
        user.setRoles(listaFiltrada);
        userService.save(user);
		return encargadoBPAService.save(encargadoBPA);
	}

	@Secured({ "ROLE_ADMIN", "ROLE_DUENO" })
	@PutMapping("/encargadosBPA/{run}")
	@ResponseStatus(HttpStatus.CREATED) 
	public EncargadoBPA actualizarEncargadoBPA(@RequestBody EncargadoBPA encargadoBPA, @PathVariable String run) {

		EncargadoBPA encargadoBPAActual = encargadoBPAService.findById(run);

		encargadoBPAActual.setNombre(encargadoBPA.getNombre());
		encargadoBPAActual.setTelefono(encargadoBPA.getTelefono());
		encargadoBPAActual.setEmail(encargadoBPA.getEmail());
		encargadoBPAActual.setPass(encargadoBPA.getPass());
		Usuario user = userService.findByUsername(encargadoBPA.getRun());
		user.setEmail(encargadoBPA.getEmail());
		user.setNombre(encargadoBPA.getNombre());
		user.setPassword(passwordEncoder.encode(encargadoBPA.getPass()));
		return encargadoBPAService.save(encargadoBPAActual);

	}

	@Secured({ "ROLE_ADMIN", "ROLE_DUENO" })
	@DeleteMapping("/encargadosBPA/{run}")
	@ResponseStatus(HttpStatus.NO_CONTENT) 
	public void eliminarEncargadoBPA(@PathVariable String run) {
		userService.findByUsername(run).setEnabled(false);
		encargadoBPAService.delete(run);
	}
}

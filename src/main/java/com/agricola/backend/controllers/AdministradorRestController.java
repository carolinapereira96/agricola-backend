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
import com.agricola.backend.models.entity.Administrador;
import com.agricola.backend.models.entity.Role;
import com.agricola.backend.models.entity.Usuario;
import com.agricola.backend.models.services.IAdministradorService;
import com.agricola.backend.models.services.IRoleService;
import com.agricola.backend.models.services.IUsuarioService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class AdministradorRestController {

	@Autowired
	private IRoleService roleService;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private IUsuarioService userService;

	
	@Autowired
	private IAdministradorService administradorService;

	@Secured({ "ROLE_ADMIN", "ROLE_DUENO" })
	@GetMapping("/administradores")
	public List<Administrador> listarAdministradores() {
		return administradorService.findAll();
	}

	@Secured({ "ROLE_ADMIN", "ROLE_DUENO" })
	@GetMapping("/administradores/{run}")
	public Administrador buscarAdministrador(@PathVariable String run) {
		return administradorService.findById(run);
	}

	@Secured({ "ROLE_ADMIN", "ROLE_DUENO" })
	@PostMapping("/administradores")
	@ResponseStatus(HttpStatus.CREATED)
	public Administrador crearAdministrador(@RequestBody Administrador adm) {
		List<Role> list1 = (List<Role>) roleService.findAll();
	    List<Role> listaFiltrada = list1.stream().filter(item->item.getNombre().equalsIgnoreCase("ROLE_ADMINCAMPO")).collect(Collectors.toList());
        Usuario user = new Usuario();
        user.setUsername(adm.getRun());
        user.setNombre(adm.getNombre());
        user.setEnabled(true);
        user.setEmail(adm.getEmail());
        user.setPassword(passwordEncoder.encode(adm.getPassword()));
        user.setRoles(listaFiltrada);
        userService.save(user);
		return administradorService.save(adm);
	}

	@Secured({ "ROLE_ADMIN", "ROLE_DUENO" })
	@PutMapping("/administradores/{run}")
	@ResponseStatus(HttpStatus.CREATED)
	public Administrador actualizarAdministrador(@RequestBody Administrador adm, @PathVariable String run) {
		Administrador administradorActual = administradorService.findById(run);
		administradorActual.setNombre(adm.getNombre());
		administradorActual.setTelefono(adm.getTelefono());
		administradorActual.setEmail(adm.getEmail());
		administradorActual.setPassword(adm.getPassword());
		Usuario user = userService.findByUsername(adm.getRun());
		user.setEmail(adm.getEmail());
		user.setNombre(adm.getNombre());
		user.setPassword(passwordEncoder.encode(adm.getPassword()));
		return administradorService.save(administradorActual);
	}

	@Secured({ "ROLE_ADMIN", "ROLE_DUENO" })
	@DeleteMapping("/administradores/{run}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void eliminarAdministrador(@PathVariable String run) {
		userService.findByUsername(run).setEnabled(false); // desactiva los permisos para inicar sesión
	   // userService.delete(userService.findByUsername(run)); // elimina por completo de la autenticación al usuario excepto en la tabla de la entidad en este caso administrador, solo la setea
		administradorService.delete(run); // eliminado de forma lógica
	}

}

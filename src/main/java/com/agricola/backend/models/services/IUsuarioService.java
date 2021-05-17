package com.agricola.backend.models.services;

import com.agricola.backend.models.entity.Usuario;

public interface IUsuarioService {

	 public Usuario findByUsername(String username);
}

package com.certant.pokedex2.converters;

import org.springframework.stereotype.Component;

import com.certant.pokedex2.entities.Usuario;
import com.certant.pokedex2.models.UsuarioModel;

@Component("usuarioConverter")
public class UsuarioConverter {
	
	public UsuarioModel entityToModel(Usuario usuario) {
		if(usuario==null)return null;
		return new UsuarioModel(usuario.getIdUsuario(),usuario.getNombre());
	}
	
	public Usuario modelToEntity(UsuarioModel usuario) {
		if(usuario==null)return null;
		return new Usuario(usuario.getIdUsuario(),usuario.getNombre());
	}

}

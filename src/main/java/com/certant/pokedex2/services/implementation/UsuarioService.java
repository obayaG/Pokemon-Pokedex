package com.certant.pokedex2.services.implementation;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.certant.pokedex2.entities.Usuario;
import com.certant.pokedex2.repositories.IUsuarioRepository;
import com.certant.pokedex2.services.IUsuarioService;

@Service("usuarioService")
public class UsuarioService implements IUsuarioService{
	
	@Autowired
	@Qualifier("usuarioRepository")
	private IUsuarioRepository usuarioRepository;
	
	
	public Set<Usuario> traerUsuarios(){
		return usuarioRepository.traerUsuarios();
	}

}

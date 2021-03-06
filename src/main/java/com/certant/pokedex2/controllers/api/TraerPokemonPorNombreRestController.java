package com.certant.pokedex2.controllers.api;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.certant.pokedex2.converters.PokemonUsuarioConverter;
import com.certant.pokedex2.entities.PokemonUsuario;
import com.certant.pokedex2.entities.Usuario;
import com.certant.pokedex2.services.IPokemonUsuarioService;
import com.certant.pokedex2.services.IUsuarioService;
import com.fasterxml.jackson.databind.node.ObjectNode;

@Controller
@RequestMapping("/api/traerPokemonPorNombre")
public class TraerPokemonPorNombreRestController {
	
	@Autowired
	@Qualifier("pokemonUsuarioService")
	private IPokemonUsuarioService pokemonUsuarioService;
	
	@Autowired
	@Qualifier("pokemonUsuarioConverter")
	private PokemonUsuarioConverter pokemonUsuarioConverter;
	
	@Autowired
	@Qualifier("usuarioService")
	private IUsuarioService usuarioService;
	
	
	@PostMapping("/mostrar")
	@ResponseBody
	public PokemonUsuario traerPokemonPorNombre(@RequestBody ObjectNode o) throws Exception {
		PokemonUsuario p= pokemonUsuarioConverter.modelToEntity(pokemonUsuarioService.traerPokemonUsuario(o.get("nombrePokemon").asText(), o.get("nombreUsuario").asText()));
		return p;
	}
	

	@PostMapping("/traerUsuarios")
	@ResponseBody
	public Set<Usuario> traerUsuarios(){
		return usuarioService.traerUsuarios();
	}
	
	
	
}

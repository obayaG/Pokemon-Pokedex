package com.certant.pokedex2.controllers.api;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.certant.pokedex2.converters.PokemonUsuarioConverter;
import com.certant.pokedex2.entities.PokemonUsuario;
import com.certant.pokedex2.services.IPokemonUsuarioService;
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
	
	
	@PostMapping("/mostrar")
	@ResponseBody
	public PokemonUsuario traerPokemonPorNombre(@RequestBody ObjectNode o) throws Exception {
		PokemonUsuario p= pokemonUsuarioConverter.modelToEntity(pokemonUsuarioService.traerPokemonUsuario(o.get("nombrePokemon").asText(), o.get("nombreUsuario").asText()));
		return p;
	}
	

}

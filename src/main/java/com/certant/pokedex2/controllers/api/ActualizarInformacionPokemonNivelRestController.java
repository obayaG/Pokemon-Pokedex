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
import com.certant.pokedex2.services.IPokemonUsuarioService;
import com.fasterxml.jackson.databind.node.ObjectNode;

@Controller
@RequestMapping("/api/actualizarInformacionPokemonNivel")
public class ActualizarInformacionPokemonNivelRestController {
	
	@Autowired
	@Qualifier("pokemonUsuarioService")
	private IPokemonUsuarioService pokemonUsuarioService;
	
	@Autowired
	@Qualifier("pokemonUsuarioConverter")
	private PokemonUsuarioConverter pokemonUsuarioConverter;
	
	@PostMapping("/mostrarPokemon")
	@ResponseBody
	public Set<PokemonUsuario> traerTodosLosPokemonesDelUsuario(@RequestBody ObjectNode o) throws Exception {
		return pokemonUsuarioService.traerListaPokemones(o.get("nombreUsuario").asText());
	}
	
	@PostMapping("/cambiarNivel")
	@ResponseBody
	public void actualizarInformacionPokemonNivel(@RequestBody ObjectNode o) throws Exception {
		pokemonUsuarioService.actualizarNivelPokemon(o.get("nombrePokemon").asText(), o.get("nivel").asInt(), o.get("nombreUsuario").asText());
	}
	
	

}

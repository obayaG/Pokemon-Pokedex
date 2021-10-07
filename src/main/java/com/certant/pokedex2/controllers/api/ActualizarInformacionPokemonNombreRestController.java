package com.certant.pokedex2.controllers.api;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.certant.pokedex2.converters.PokemonDatoConverter;
import com.certant.pokedex2.entities.PokemonDato;
import com.certant.pokedex2.services.IPokemonDatoService;
import com.fasterxml.jackson.databind.node.ObjectNode;

@Controller
@RequestMapping("/api/actualizarInformacionPokemonNombre")
public class ActualizarInformacionPokemonNombreRestController {
	
	@Autowired
	@Qualifier("pokemonDatoService")
	private IPokemonDatoService pokemonDatoService;
	
	@Autowired
	@Qualifier("pokemonDatoConverter")
	private PokemonDatoConverter pokemonDatoConverter;
	
	
	
	@PostMapping("/mostrarPokemon")
	@ResponseBody
	public PokemonDato traerPokemonPorNombre(@RequestBody ObjectNode o) throws Exception {
		return  pokemonDatoConverter.modelToEntity(pokemonDatoService.traerPokemonDato(o.get("nombrePokemon").asText()));
	}
	
	@PostMapping("/cambiar")
	@ResponseBody
	public void actualizarNombrePokemon(@RequestBody ObjectNode o) throws Exception {
		pokemonDatoService.actualizarNombrePokemon(o.get("nombrePokemon").asText(), o.get("nuevoNombrePokemon").asText());
	}
	
	
	

}

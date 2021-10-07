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
@RequestMapping("/api/traerInformacionPokemonNombre")
public class TraerInformacionPokemonNombreRestController {

	@Autowired	
	@Qualifier("pokemonDatoService")
	private IPokemonDatoService pokemonDatoService;
	
	@Autowired
	@Qualifier("pokemonDatoConverter")
	private PokemonDatoConverter pokemonDatoConverter;
	

	
	@PostMapping("/mostrar")
	@ResponseBody
	public PokemonDato traerInformacionPokemonNombre(@RequestBody ObjectNode o) throws Exception {
		return pokemonDatoConverter.modelToEntity(pokemonDatoService.traerPokemonDato(o.get("nombrePokemon").asText()));
	}
	
	
	
}

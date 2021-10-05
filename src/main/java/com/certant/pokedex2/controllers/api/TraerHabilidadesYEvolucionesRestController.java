package com.certant.pokedex2.controllers.api;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.certant.pokedex2.entities.PokemonDato;
import com.certant.pokedex2.services.IPokemonDatoService;
import com.fasterxml.jackson.databind.node.ObjectNode;

@Controller
@RequestMapping("/api/traerHabilidadesYEvoluciones")
public class TraerHabilidadesYEvolucionesRestController {
	
	@Autowired	
	@Qualifier("pokemonDatoService")
	private IPokemonDatoService pokemonDatoService;
	
	
	@PostMapping("/mostrar")
	@ResponseBody
	public Set<PokemonDato> traerHabilidadesYEvoluciones(@RequestBody ObjectNode o) {
		return pokemonDatoService.traerListaPokemonesHabilidadEvolucion(o.get("nombrePokemon").asText());
	}
	

}

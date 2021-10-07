package com.certant.pokedex2.controllers.api;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.certant.pokedex2.converters.PokemonDatoConverter;
import com.certant.pokedex2.entities.PokemonDato;
import com.certant.pokedex2.entities.Tipo;
import com.certant.pokedex2.services.IPokemonDatoService;
import com.certant.pokedex2.services.IPokemonUsuarioService;
import com.certant.pokedex2.services.ITipoService;
import com.fasterxml.jackson.databind.node.ObjectNode;

@Controller
@RequestMapping("/api/actualizarInformacionPokemonTipo")
public class ActualizarInformacionPokemonTipoRestController {

	@Autowired	
	@Qualifier("pokemonDatoService")
	private IPokemonDatoService pokemonDatoService;
	
	@Autowired
	@Qualifier("pokemonUsuarioService")
	private IPokemonUsuarioService pokemonUsuarioService;
	
	@Autowired
	@Qualifier("pokemonDatoConverter")
	private PokemonDatoConverter pokemonDatoConverter;
	
	@Autowired
	@Qualifier("tipoService")
	private ITipoService tipoService;
	
	@PostMapping("/mostrarPokemon")
	@ResponseBody
	public PokemonDato traerPokemonPorNombre(@RequestBody ObjectNode o) throws Exception {
		return pokemonDatoConverter.modelToEntity(pokemonDatoService.traerPokemonDato(o.get("nombrePokemon").asText()));
	}
	
	@PostMapping("/mostrar")
	@ResponseBody
	public void actualizarInformacionPokemonTipo(@RequestBody ObjectNode o) throws Exception {
		pokemonDatoService.actualizarTipoPokemon(o.get("nombrePokemon").asText(), o.get("tipo1").asText(),o.get("tipo2").asText());
	}
	
	@PostMapping("/traerTipos")
	@ResponseBody
	public Set<Tipo> traerTipos(){
		return tipoService.traerTipos();
	}
	
	
}

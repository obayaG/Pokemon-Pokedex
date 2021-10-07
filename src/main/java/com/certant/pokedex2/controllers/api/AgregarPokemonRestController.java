package com.certant.pokedex2.controllers.api;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.certant.pokedex2.entities.Habilidad;
import com.certant.pokedex2.entities.PokemonRaza;
import com.certant.pokedex2.entities.Tipo;
import com.certant.pokedex2.services.IPokemonDatoService;
import com.certant.pokedex2.services.IPokemonRazaService;
import com.certant.pokedex2.services.ITipoService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;



@Controller
@RequestMapping("/api/agregarPokemon")
public class AgregarPokemonRestController {
	
	@Autowired
	@Qualifier("pokemonDatoService")
	private IPokemonDatoService pokemonDatoService;
	
	
	@Autowired
	@Qualifier("tipoService")
	private ITipoService tipoService;
	
	
	@Autowired
	@Qualifier("pokemonRazaService")
	private IPokemonRazaService pokemonRazaService;
	
	
	@PostMapping("/traerTipo")
	@ResponseBody
	private Set<Tipo> traerTipos() {
		return tipoService.traerTipos();
	}
	
	@PostMapping("/traerPokemonRaza")
	@ResponseBody
	private Set<PokemonRaza> traerPokemonRaza(){
		return pokemonRazaService.traerTodosPokemonRaza();
	}
	
	@PostMapping("/agregar")
	@ResponseBody
	private void agregarPokemon(@RequestBody ObjectNode o) throws Exception {
		Set<Habilidad> habilidades = new HashSet<Habilidad>();
		JsonNode listaNode = o.get("habilidades");
		for (JsonNode l : listaNode) {
			habilidades.add(new Habilidad(l.asText()));
		}
		pokemonDatoService.agregar(o.get("nombrePokemon").asText(), o.get("nivelSiguienteEvolucion").asInt(),
				o.get("ordenEvolucion").asInt(), o.get("tipo1").asText(), o.get("tipo2").asText(),
				o.get("pokemonRaza").asInt(), habilidades);
	}
	

}

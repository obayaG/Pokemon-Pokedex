package com.certant.pokedex2.controllers.api;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.certant.pokedex2.entities.PokemonDato;
import com.certant.pokedex2.services.IPokemonDatoService;

@Controller
@RequestMapping("/api/traerTodos")
public class TraerTodoRestController {
	
	
	@Autowired	
	@Qualifier("pokemonDatoService")
	private IPokemonDatoService pokemonDatoService;
	
	
	
	@GetMapping("/mostrar") 
	@ResponseBody
	public Set<PokemonDato> traerTodosLosPokemones() {
		return pokemonDatoService.traerTodosLosPokemones();	
	}

}

package com.certant.pokedex2.services.implementation;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.certant.pokedex2.entities.PokemonRaza;
import com.certant.pokedex2.repositories.IPokemonRazaRepository;
import com.certant.pokedex2.services.IPokemonRazaService;

@Service("pokemonRazaService")
public class PokemonRazaService implements IPokemonRazaService {
	
	@Autowired
	@Qualifier("pokemonRazaRepository")
	private IPokemonRazaRepository pokemonRazaRepository;

	@Override
	public Set<PokemonRaza> traerTodosPokemonRaza() {	
		return pokemonRazaRepository.traerPokemonRaza();
	}

}

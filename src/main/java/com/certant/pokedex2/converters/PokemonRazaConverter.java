package com.certant.pokedex2.converters;

import org.springframework.stereotype.Component;
import com.certant.pokedex2.entities.PokemonRaza;
import com.certant.pokedex2.models.PokemonRazaModel;

@Component("pokemonRazaConverter")
public class PokemonRazaConverter {
	
	
	public PokemonRazaModel entityToModel(PokemonRaza pokemonRaza) {
		if(pokemonRaza==null)return null;
		return new PokemonRazaModel(pokemonRaza.getIdPokemonRaza());
	}
	
	
	public PokemonRaza modelToEntity(PokemonRazaModel pokemonRaza) {
		if(pokemonRaza==null)return null;
		return new PokemonRaza(pokemonRaza.getIdPokemonRaza());
	}

}

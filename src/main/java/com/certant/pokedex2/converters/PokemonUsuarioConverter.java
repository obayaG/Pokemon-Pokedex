package com.certant.pokedex2.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import com.certant.pokedex2.entities.PokemonUsuario;
import com.certant.pokedex2.models.PokemonUsuarioModel;

@Component("pokemonUsuarioConverter")
public class PokemonUsuarioConverter {
	
	
	@Autowired
	@Qualifier("usuarioConverter")
	private UsuarioConverter usuarioConverter;
	
	@Autowired
	@Qualifier("pokemonDatoConverter")
	private PokemonDatoConverter pokemonDatoConverter;
	
	
	
	public PokemonUsuarioModel entityToModel(PokemonUsuario pokemonUsuario) {
		if (pokemonUsuario == null)return null;	
		return new PokemonUsuarioModel(pokemonUsuario.getIdPokemon(), pokemonUsuario.getNivel(),
				usuarioConverter.entityToModel(pokemonUsuario.getUsuario()),
				pokemonDatoConverter.entityToModel(pokemonUsuario.getPokemonDato()));
	}
	
	public PokemonUsuario modelToEntity(PokemonUsuarioModel pokemonUsuario) {
		if (pokemonUsuario == null)return null;
		return new PokemonUsuario(pokemonUsuario.getIdPokemon(), pokemonUsuario.getNivel(),
				usuarioConverter.modelToEntity(pokemonUsuario.getUsuario()),
				pokemonDatoConverter.modelToEntity(pokemonUsuario.getPokemonDato()));
	}

}

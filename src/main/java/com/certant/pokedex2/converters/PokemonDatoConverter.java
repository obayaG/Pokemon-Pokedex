package com.certant.pokedex2.converters;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.certant.pokedex2.entities.Habilidad;
import com.certant.pokedex2.entities.PokemonDato;
import com.certant.pokedex2.models.HabilidadModel;
import com.certant.pokedex2.models.PokemonDatoModel;

@Component("pokemonDatoConverter")
public class PokemonDatoConverter {
	
	@Autowired
	@Qualifier("pokemonRazaConverter")
	private PokemonRazaConverter pokemonRazaConverter;
	
	@Autowired
	@Qualifier("habilidadConverter")
	private HabilidadConverter habilidadConverter;
	
	@Autowired
	@Qualifier("tipoConverter")
	private TipoConverter tipoConverter;
	
	public PokemonDatoModel entityToModel(PokemonDato pokemonDato) {
		if (pokemonDato == null)return null;
		Set<Habilidad> lista=pokemonDato.getHabilidades();
		Set<HabilidadModel> listaModel= new HashSet<HabilidadModel>();
		for (Habilidad h : lista) {
			if (!lista.isEmpty()) {
				listaModel.add(habilidadConverter.entityToModel(h));
			}
		}
		return new PokemonDatoModel(pokemonDato.getIdPokemonDato(), pokemonDato.getNombrePokemon(),
				tipoConverter.entityToModel(pokemonDato.getTipo1()),
				tipoConverter.entityToModel(pokemonDato.getTipo2()), pokemonDato.getNivelSiguienteEvolucion(),
				pokemonDato.getOrdenEvolucion(), pokemonRazaConverter.entityToModel(pokemonDato.getPokemonRaza()),
				listaModel);
	}
	
	public PokemonDato modelToEntity(PokemonDatoModel pokemonDato) {
		if(pokemonDato ==null)return null;
		Set<HabilidadModel> lista=pokemonDato.getHabilidades();
		Set<Habilidad> listaEntity= new HashSet<Habilidad>();
		for(HabilidadModel h: lista) {
			if (!lista.isEmpty()) {
				listaEntity.add(habilidadConverter.modelToEntity(h));
			}
		}
		return new PokemonDato(pokemonDato.getIdPokemonDato(), pokemonDato.getNombrePokemon(),
				tipoConverter.modelToEntity(pokemonDato.getTipo1()),
				tipoConverter.modelToEntity(pokemonDato.getTipo2()), pokemonDato.getNivelSiguienteEvolucion(),
				pokemonDato.getOrdenEvolucion(), pokemonRazaConverter.modelToEntity(pokemonDato.getPokemonRaza()),
				listaEntity);
	}

}

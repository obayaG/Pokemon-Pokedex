package com.certant.pokedex2.services.implementation;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.certant.pokedex2.converters.PokemonUsuarioConverter;
import com.certant.pokedex2.entities.PokemonDato;
import com.certant.pokedex2.entities.PokemonUsuario;
import com.certant.pokedex2.models.PokemonUsuarioModel;
import com.certant.pokedex2.repositories.IPokemonDatoRepository;
import com.certant.pokedex2.repositories.IPokemonUsuarioRepository;
import com.certant.pokedex2.services.IPokemonUsuarioService;

@Service("pokemonUsuarioService")
public class PokemonUsuarioService implements IPokemonUsuarioService{

	@Autowired
	@Qualifier("pokemonUsuarioConverter")
	private PokemonUsuarioConverter pokemonUsuarioConverter;
	
	@Autowired
	@Qualifier("pokemonUsuarioRepository")
	private IPokemonUsuarioRepository pokemonUsuarioRepository;
	
	@Autowired
	@Qualifier("pokemonDatoRepository")
	private IPokemonDatoRepository pokemonDatoRepository;
	
	@Override
	public PokemonUsuarioModel traerPokemonUsuario(String nombre, String nombreUsuario) throws Exception {
		PokemonUsuarioModel p=pokemonUsuarioConverter.entityToModel(pokemonUsuarioRepository.traerPokemonUsuario(nombre, nombreUsuario));
		if(p==null) throw new Exception("No existe pokemon de ese usuario");
		return p;
	}

	@Override
	public List<PokemonUsuario> traerListaPokemones(String nombre) throws Exception { //nombre del usuario
		List<PokemonUsuario> lista= pokemonUsuarioRepository.traerListaPokemones(nombre);
		if(lista.isEmpty())throw new Exception("El usuario no tiene pokemones");
		return lista;
	}

	@Override
	public void actualizarNivelPokemon(String nombreABuscar, int nivel, String nombreUsuario) {
		List<PokemonUsuario> lista=pokemonUsuarioRepository.traerListaPokemones(nombreUsuario);
		PokemonUsuario dato = null;
		PokemonDato d2 = null;
		PokemonDato pRaza=null;
		if (!lista.isEmpty()) {
			for (PokemonUsuario u : lista) {
				if (u.getPokemonDato().getNombrePokemon().equalsIgnoreCase(nombreABuscar)) {
					dato = u;
					System.out.println("\n datos antes \n"+dato);
				}
			}
			pRaza=pokemonDatoRepository.traerPokemonDato(nombreABuscar);
			if(pRaza!=null) {
				Set<PokemonDato> listaPokeRaza = pokemonDatoRepository.traerListaPokemones(pRaza.getPokemonRaza().getIdPokemonRaza());
				if (!listaPokeRaza.isEmpty()) {
					for (PokemonDato d : listaPokeRaza) {
						if (d.getNivelSiguienteEvolucion() == nivel && listaPokeRaza.size() > 1 && d.getOrdenEvolucion() != listaPokeRaza.size()) {
							d2 = pokemonDatoRepository.traerSiguienteEvolucion(pRaza.getPokemonRaza().getIdPokemonRaza(),d.getOrdenEvolucion()+1);
							dato.setPokemonDato(d2);
						}
					}

				}
			}		
		}
		dato.setNivel(nivel);
		pokemonUsuarioRepository.save(dato);
		System.out.println("\n datos despues \n"+dato);
		
	}


}

package com.certant.pokedex2.services;


import java.util.Set;

import com.certant.pokedex2.entities.Habilidad;
import com.certant.pokedex2.entities.PokemonDato;
import com.certant.pokedex2.models.PokemonDatoModel;

public interface IPokemonDatoService {
	
	
	public  PokemonDato agregar(String nombre, int nivelSiguienteEvolucion, int ordenEvolucion, String tipo1, String tipo2,int pokemonRaza, Set<Habilidad> habilidades) throws Exception;
	
	public  PokemonDatoModel traerPokemonDato(String nombre);
	
	public Set<PokemonDato> traerListaPokemonesHabilidadEvolucion(String nombre);
	
	public Set<PokemonDato> traerTodosLosPokemones();
	
	public void actualizarNombrePokemon(String nombreABuscar,String nuevoNombreDeseado) throws Exception;
	
	public void actualizarTipoPokemon(String nombreABuscar,String tipo1, String tipo2) throws Exception;

}

package com.certant.pokedex2.services;


import java.util.Set;

import com.certant.pokedex2.entities.PokemonUsuario;
import com.certant.pokedex2.models.PokemonUsuarioModel;

public interface IPokemonUsuarioService {
	
	
	public PokemonUsuarioModel traerPokemonUsuario(String nombre,String nombreUsuario)throws Exception;
	
	public Set<PokemonUsuario> traerListaPokemones(String nombre)throws Exception;
	
	public void actualizarNivelPokemon(String nombreABuscar,int nivel,String nombreUsuario) throws Exception;
	

}

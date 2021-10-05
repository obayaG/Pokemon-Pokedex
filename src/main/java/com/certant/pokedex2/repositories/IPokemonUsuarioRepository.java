package com.certant.pokedex2.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.certant.pokedex2.entities.PokemonUsuario;

@Repository ("pokemonUsuarioRepository")
public interface IPokemonUsuarioRepository extends JpaRepository<PokemonUsuario, Serializable>{
	
	@Query("Select p from PokemonUsuario p join fetch p.usuario u join fetch p.pokemonDato d join fetch d.tipo1 join fetch d.tipo2 join fetch d.pokemonRaza join fetch d.habilidades where d.nombrePokemon=(:nombrePokemon) and u.nombre=(:nombreUsuario)")
	public abstract PokemonUsuario traerPokemonUsuario(String nombrePokemon,String nombreUsuario);
	
	@Query("Select u from PokemonUsuario  u join fetch u.usuario a join fetch u.pokemonDato d join fetch d.tipo1 join fetch d.tipo2 join fetch d.pokemonRaza r join fetch d.habilidades where a.nombre=(:nombreUsuario)")
	public abstract List<PokemonUsuario> traerListaPokemones(String nombreUsuario);
	

	
}

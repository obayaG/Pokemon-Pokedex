package com.certant.pokedex2.repositories;

import java.io.Serializable;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.certant.pokedex2.entities.PokemonDato;

@Repository ("pokemonDatoRepository")
public interface IPokemonDatoRepository extends JpaRepository<PokemonDato, Serializable>{
	
	
	@Query("Select d from PokemonDato d join fetch d.pokemonRaza join fetch d.tipo1 join fetch d.tipo2 join fetch d.habilidades join fetch d.pokemonRaza")
	public abstract Set<PokemonDato> traerTodosLosPokemones();
	
	@Query("Select p from PokemonDato p join fetch p.tipo1 join fetch p.tipo2 join fetch p.pokemonRaza join fetch p.habilidades where p.nombrePokemon=(:nombre)")
	public abstract PokemonDato traerPokemonDato(String nombre);
	
	@Query("Select d from PokemonDato d join fetch d.tipo1 join fetch d.tipo2 join fetch d.pokemonRaza r join fetch d.habilidades where r.idPokemonRaza=(:idPokemonRaza)") 
	public abstract Set<PokemonDato> traerListaPokemones(int idPokemonRaza);
	
	@Query("Select p from PokemonDato p join fetch p.tipo1 join fetch p.tipo2 join fetch p.pokemonRaza join fetch p.habilidades where p.nombrePokemon=(:nombrePokemon)")
	public abstract PokemonDato traerTodoPokemon(String nombrePokemon);
	
	
	@Query("Select d from PokemonDato d join fetch d.tipo1 join fetch d.tipo2 join fetch d.habilidades join fetch d.pokemonRaza r where r.idPokemonRaza=(:idPokemonRaza) and d.ordenEvolucion=(:ordenEvolucion)")
	public abstract PokemonDato traerSiguienteEvolucion(int idPokemonRaza,int ordenEvolucion);
	
	
	
}

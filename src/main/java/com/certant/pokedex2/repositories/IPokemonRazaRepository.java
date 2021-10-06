package com.certant.pokedex2.repositories;

import java.io.Serializable;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.certant.pokedex2.entities.PokemonRaza;


@Repository ("pokemonRazaRepository")
public interface IPokemonRazaRepository extends JpaRepository<PokemonRaza, Serializable>{
	
	@Query("Select p from PokemonRaza p")
	public abstract Set<PokemonRaza> traerPokemonRaza();

}

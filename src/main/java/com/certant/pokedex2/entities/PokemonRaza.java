package com.certant.pokedex2.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="POKEMONRAZA")
public class PokemonRaza {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IDPOKEMONRAZA")
	private int idPokemonRaza;

	
	
	
	public PokemonRaza() {
		super();
	}




	public PokemonRaza(int idPokemonRaza) {
		super();
		this.idPokemonRaza = idPokemonRaza;
	}




	public int getIdPokemonRaza() {
		return idPokemonRaza;
	}



	public void setIdPokemonRaza(int idPokemonRaza) {
		this.idPokemonRaza = idPokemonRaza;
	}




	@Override
	public String toString() {
		return "PokemonRaza [idPokemonRaza=" + idPokemonRaza + "]";
	}







	

}


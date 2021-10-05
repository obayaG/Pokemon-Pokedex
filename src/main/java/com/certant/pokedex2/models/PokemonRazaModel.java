package com.certant.pokedex2.models;


public class PokemonRazaModel {
	
	private int idPokemonRaza;

	
	
	
	public PokemonRazaModel() {
		super();
	}




	public PokemonRazaModel(int idPokemonRaza) {
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
		return "PokemonRazaModel [idPokemonRaza=" + idPokemonRaza + "]";
	}







	

}

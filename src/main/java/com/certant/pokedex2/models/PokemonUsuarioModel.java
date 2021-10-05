package com.certant.pokedex2.models;


public class PokemonUsuarioModel {
	
	private int idPokemon;
	private int nivel;
	private UsuarioModel usuario;
	private PokemonDatoModel pokemonDato;
	
	public PokemonUsuarioModel() {
		super();
	}

	

	public PokemonUsuarioModel(int idPokemon, int nivel, UsuarioModel usuario, PokemonDatoModel pokemonDato) {
		super();
		this.idPokemon = idPokemon;
		this.nivel = nivel;
		this.usuario = usuario;
		this.pokemonDato = pokemonDato;
	}



	public PokemonUsuarioModel(int nivel, UsuarioModel usuario, PokemonDatoModel pokemonDato) {
		super();
		this.nivel = nivel;
		this.usuario = usuario;
		this.pokemonDato = pokemonDato;
	}



	public int getIdPokemon() {
		return idPokemon;
	}

	protected void setIdPokemon(int idPokemon) {
		this.idPokemon = idPokemon;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public PokemonDatoModel getPokemonDato() {
		return pokemonDato;
	}

	public void setPokemonDato(PokemonDatoModel pokemonDato) {
		this.pokemonDato = pokemonDato;
	}
	
	

	public UsuarioModel getUsuario() {
		return usuario;
	}



	public void setUsuario(UsuarioModel usuario) {
		this.usuario = usuario;
	}


/*
	@Override
	public String toString() {
		return "PokemonUsuario [nivel=" + nivel + "]";
	}

*/
/*
	@Override
	public String toString() {
		return "PokemonUsuario [nivel=" + nivel + ", usuario=" + usuario + "]";
	}
*/


	@Override
	public String toString() {
		return "PokemonUsuarioModel [nivel=" + nivel + ", usuario=" + usuario + ", pokemonDato=" + pokemonDato + "]";
	}




	
	
	

}

package com.certant.pokedex2.models;


import java.util.Set;

public class PokemonDatoModel {
	
	private int idPokemonDato;
	private String nombrePokemon;
	private TipoModel tipo1;
	private TipoModel tipo2;
	private int nivelSiguienteEvolucion;
	private int ordenEvolucion;
	private PokemonRazaModel pokemonRaza;
	private Set<HabilidadModel> habilidades;
	
	
	
	public PokemonDatoModel() {
		super();
	}

	


	public PokemonDatoModel(int idPokemonDato, String nombrePokemon, TipoModel tipo1, TipoModel tipo2, int nivelSiguienteEvolucion,
			int ordenEvolucion, PokemonRazaModel pokemonRaza, Set<HabilidadModel> habilidades) {
		super();
		this.idPokemonDato = idPokemonDato;
		this.nombrePokemon = nombrePokemon;
		this.tipo1 = tipo1;
		this.tipo2 = tipo2;
		this.nivelSiguienteEvolucion = nivelSiguienteEvolucion;
		this.ordenEvolucion = ordenEvolucion;
		this.pokemonRaza = pokemonRaza;
		this.habilidades = habilidades;
	}




	public PokemonDatoModel(String nombrePokemon, TipoModel tipo1, TipoModel tipo2, int nivelSiguienteEvolucion, int ordenEvolucion,
			PokemonRazaModel pokemonRaza, Set<HabilidadModel> habilidades) {
		super();
		this.nombrePokemon = nombrePokemon;
		this.tipo1 = tipo1;
		this.tipo2 = tipo2;
		this.nivelSiguienteEvolucion = nivelSiguienteEvolucion;
		this.ordenEvolucion = ordenEvolucion;
		this.pokemonRaza = pokemonRaza;
		this.habilidades = habilidades;
	}


	public int getIdPokemonDato() {
		return idPokemonDato;
	}




	public void setIdPokemonDato(int idPokemonDato) {
		this.idPokemonDato = idPokemonDato;
	}









	public String getNombrePokemon() {
		return nombrePokemon;
	}



	public void setNombrePokemon(String nombrePokemon) {
		this.nombrePokemon = nombrePokemon;
	}



	public TipoModel getTipo1() {
		return tipo1;
	}



	public void setTipo1(TipoModel tipo1) {
		this.tipo1 = tipo1;
	}



	public TipoModel getTipo2() {
		return tipo2;
	}



	public void setTipo2(TipoModel tipo2) {
		this.tipo2 = tipo2;
	}



	public int getNivelSiguienteEvolucion() {
		return nivelSiguienteEvolucion;
	}



	public void setNivelSiguienteEvolucion(int nivelSiguienteEvolucion) {
		this.nivelSiguienteEvolucion = nivelSiguienteEvolucion;
	}



	public int getOrdenEvolucion() {
		return ordenEvolucion;
	}



	public void setOrdenEvolucion(int ordenEvolucion) {
		this.ordenEvolucion = ordenEvolucion;
	}



	public Set<HabilidadModel> getHabilidades() {
		return habilidades;
	}



	public void setHabilidades(Set<HabilidadModel> habilidades) {
		this.habilidades = habilidades;
	}




	public PokemonRazaModel getPokemonRaza() {
		return pokemonRaza;
	}




	public void setPokemonRaza(PokemonRazaModel pokemonRaza) {
		this.pokemonRaza = pokemonRaza;
	}









	@Override
	public String toString() {
		return "PokemonDatoModel [nombrePokemon=" + nombrePokemon + ", tipo1=" + tipo1 + ", tipo2=" + tipo2
				+ ", nivelSiguienteEvolucion=" + nivelSiguienteEvolucion + ", ordenEvolucion=" + ordenEvolucion
				+ ", pokemonRaza=" + pokemonRaza + ", habilidades=" + habilidades + "]\n";
	}




	

	
	



	





	
	
	
	
	

}

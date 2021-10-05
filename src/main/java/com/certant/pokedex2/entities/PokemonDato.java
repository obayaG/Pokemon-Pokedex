package com.certant.pokedex2.entities;


import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

@Entity
@Table(name="POKEMONDATO")
public class PokemonDato {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IDPOKEMONDATO")
	private int idPokemonDato;
	
	@Column(name="NOMBREPOKEMON")
	private String nombrePokemon;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="IDTIPO1")
	private Tipo tipo1;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="IDTIPO2")
	private Tipo tipo2;
	
	@Column(name="NIVELSIGUIENTEEVOLUCION")
	private int nivelSiguienteEvolucion;
	
	@Column(name="ORDENEVOLUCION")
	private int ordenEvolucion;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="IDPOKEMONRAZA")
	private PokemonRaza pokemonRaza;
	
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="IDPOKEMONDATO")
	@OrderBy("idHabilidad ASC")
	private Set<Habilidad> habilidades;
	
	
	
	public PokemonDato() {
		super();
	}

	


	public PokemonDato(int idPokemonDato, String nombrePokemon, Tipo tipo1, Tipo tipo2, int nivelSiguienteEvolucion,
			int ordenEvolucion, PokemonRaza pokemonRaza, Set<Habilidad> habilidades) {
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




	public PokemonDato(String nombrePokemon, Tipo tipo1, Tipo tipo2, int nivelSiguienteEvolucion, int ordenEvolucion,
			PokemonRaza pokemonRaza, Set<Habilidad> habilidades) {
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



	public Tipo getTipo1() {
		return tipo1;
	}



	public void setTipo1(Tipo tipo1) {
		this.tipo1 = tipo1;
	}



	public Tipo getTipo2() {
		return tipo2;
	}



	public void setTipo2(Tipo tipo2) {
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



	public Set<Habilidad> getHabilidades() {
		return habilidades;
	}



	public void setHabilidades(Set<Habilidad> habilidades) {
		this.habilidades = habilidades;
	}




	public PokemonRaza getPokemonRaza() {
		return pokemonRaza;
	}




	public void setPokemonRaza(PokemonRaza pokemonRaza) {
		this.pokemonRaza = pokemonRaza;
	}









	@Override
	public String toString() {
		return "PokemonDato [nombrePokemon=" + nombrePokemon + ", tipo1=" + tipo1 + ", tipo2=" + tipo2
				+ ", nivelSiguienteEvolucion=" + nivelSiguienteEvolucion + ", ordenEvolucion=" + ordenEvolucion
				+ ", pokemonRaza=" + pokemonRaza + ", habilidades=" + habilidades + "]\n";
	}




	

	
	



	





	
	
	
	
	

}

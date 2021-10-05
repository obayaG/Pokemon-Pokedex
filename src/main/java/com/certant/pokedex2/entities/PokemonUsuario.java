package com.certant.pokedex2.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="POKEMONUSUARIO")
public class PokemonUsuario {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IDPOKEMONUSUARIO")
	private int idPokemon;
	
	private int nivel;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="IDUSUARIO")
	private Usuario usuario;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="IDPOKEMONDATO")
	private PokemonDato pokemonDato;
	
	public PokemonUsuario() {
		super();
	}

	

	public PokemonUsuario(int idPokemon, int nivel, Usuario usuario, PokemonDato pokemonDato) {
		super();
		this.idPokemon = idPokemon;
		this.nivel = nivel;
		this.usuario = usuario;
		this.pokemonDato = pokemonDato;
	}



	public PokemonUsuario(int nivel, Usuario usuario, PokemonDato pokemonDato) {
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

	public PokemonDato getPokemonDato() {
		return pokemonDato;
	}

	public void setPokemonDato(PokemonDato pokemonDato) {
		this.pokemonDato = pokemonDato;
	}
	
	

	public Usuario getUsuario() {
		return usuario;
	}



	public void setUsuario(Usuario usuario) {
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
		return "PokemonUsuario [nivel=" + nivel + ", usuario=" + usuario + ", pokemonDato=" + pokemonDato + "]";
	}




	
	
	

}


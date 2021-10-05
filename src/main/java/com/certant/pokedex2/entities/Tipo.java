package com.certant.pokedex2.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tipo {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IDTIPO")
	private int idTipo;
	
	private String tipo;
	
	
	
	public Tipo() {
		super();
	}


	

	public Tipo(int idTipo, String tipo) {
		super();
		this.idTipo = idTipo;
		this.tipo = tipo;
	}




	public Tipo(String tipo) {
		super();
		this.tipo = tipo;
	}



	public int getIdTipo() {
		return idTipo;
	}



	protected void setIdTipo(int idTipo) {
		this.idTipo = idTipo;
	}




	public String getTipo() {
		return tipo;
	}




	public void setTipo(String tipo) {
		if(tipo==null){
			tipo="no tiene";
		}
		else this.tipo = tipo;
	}


	@Override
	public String toString() {
		return "Tipo [tipo=" + tipo + "]";
	}





	
	
	
	
}

package com.certant.pokedex2.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Habilidad {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IDHABILIDAD")
	private int idHabilidad;
	
	
	private String habilidad;
	
	public Habilidad() {
		super();
	}
	
	
	

	public Habilidad(int idHabilidad, String habilidad) {
		super();
		this.idHabilidad = idHabilidad;
		this.habilidad = habilidad;
	}




	public Habilidad(String habilidad) {
		super();
		this.habilidad = habilidad;
	}



	public int getIdHabilidad() {
		return idHabilidad;
	}

	protected void setIdHabilidad(int idHabilidad) {
		this.idHabilidad = idHabilidad;
	}

	public String getHabilidad() {
		return habilidad;
	}

	public void setHabilidad(String habilidad) {
		this.habilidad = habilidad;
	}

	@Override
	public String toString() {
		return "Habilidad [habilidad=" + habilidad + "] \n";
	}
	
}

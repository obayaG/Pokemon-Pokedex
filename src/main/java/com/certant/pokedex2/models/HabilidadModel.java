package com.certant.pokedex2.models;


public class HabilidadModel {
	
	private int idHabilidad;
	private String habilidad;
	
	public HabilidadModel() {
		super();
	}
	
	

	public HabilidadModel(int idHabilidad, String habilidad) {
		super();
		this.idHabilidad = idHabilidad;
		this.habilidad = habilidad;
	}



	public HabilidadModel(String habilidad) {
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
		return "HabilidadModel [habilidad=" + habilidad + "] \n";
	}
	
	

}

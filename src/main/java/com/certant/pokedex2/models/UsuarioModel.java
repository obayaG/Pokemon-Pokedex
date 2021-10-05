package com.certant.pokedex2.models;


public class UsuarioModel {
	
	private int idUsuario;
	private String nombre;
	
	
	
	public UsuarioModel() {
		super();
	}

	

	public UsuarioModel(int idUsuario, String nombre) {
		super();
		this.idUsuario = idUsuario;
		this.nombre = nombre;
	}



	public UsuarioModel(String nombre) {
		super();
		this.nombre = nombre;
		
	}


	public int getIdUsuario() {
		return idUsuario;
	}


	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	@Override
	public String toString() {
		return "UsuarioModel [nombre=" + nombre + "]";
	}




	
	

}

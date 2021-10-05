package com.certant.pokedex2.models;


public class TipoModel {

	private int idTipo;
	private String tipo;
	
	
	
	public TipoModel() {
		super();
	}

	


	public TipoModel(int idTipo, String tipo) {
		super();
		this.idTipo = idTipo;
		this.tipo = tipo;
	}




	public TipoModel(String tipo) {
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
		return "TipoModel [tipo=" + tipo + "]";
	}





	
	
	
	
}

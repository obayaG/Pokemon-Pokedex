package com.certant.pokedex2.converters;

import org.springframework.stereotype.Component;

import com.certant.pokedex2.entities.Tipo;
import com.certant.pokedex2.models.TipoModel;

@Component("tipoConverter")
public class TipoConverter {
	
	public TipoModel entityToModel(Tipo tipo) {
		if(tipo==null)return null;
		return new TipoModel(tipo.getIdTipo(),tipo.getTipo());
	}
	
	public Tipo modelToEntity(TipoModel tipo) {
		if(tipo==null)return null;
		return new Tipo(tipo.getIdTipo(),tipo.getTipo());
	}

}

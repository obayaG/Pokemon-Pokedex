package com.certant.pokedex2.services.implementation;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.certant.pokedex2.entities.Tipo;
import com.certant.pokedex2.repositories.ITipoRepository;
import com.certant.pokedex2.services.ITipoService;

@Service("tipoService")
public class TipoService implements ITipoService{

	@Autowired
	@Qualifier("tipoRepository")
	private ITipoRepository tipoRepository;
	
	
	public Set<Tipo> traerTipos() {
		return tipoRepository.traerTipos();
	}

}

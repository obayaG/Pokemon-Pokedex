package com.certant.pokedex2.repositories;

import java.io.Serializable;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.certant.pokedex2.entities.Tipo;

@Repository ("tipoRepository")
public interface ITipoRepository extends JpaRepository<Tipo, Serializable> {
	
	@Query("Select t from Tipo t where t.tipo=(:tipo)")
	public abstract Tipo traerTipo(String tipo);
	
	@Query("Select t from Tipo t")
	public abstract Set<Tipo> traerTipos();

}

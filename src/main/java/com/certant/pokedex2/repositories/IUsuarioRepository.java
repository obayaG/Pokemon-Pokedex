package com.certant.pokedex2.repositories;

import java.io.Serializable;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.certant.pokedex2.entities.Usuario;

@Repository ("usuarioRepository")
public interface IUsuarioRepository extends JpaRepository<Usuario, Serializable>{
	
	@Query("Select u from Usuario u")
	public abstract Set<Usuario> traerUsuarios();

}

package com.certant.pokedex2.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import com.certant.pokedex2.services.IPokemonDatoService;
import com.certant.pokedex2.services.IPokemonUsuarioService;

@SpringBootTest
public class Test2 {

	@Autowired	
	@Qualifier("pokemonDatoService")
	private IPokemonDatoService pokemonDatoService;
	
	@Autowired	
	@Qualifier("pokemonUsuarioService")
	private IPokemonUsuarioService pokemonUsuarioService;
	

	@Test
	 void testTraerHabilidadesYEvoluciones() {
		String nombre2="Pidgeotto";
		try {
			System.out.println(" \n\n Test- Traer Habilidades y evoluciones del pokemon de nombre="+nombre2+" \n \n"+ pokemonDatoService.traerListaPokemonesHabilidadEvolucion(nombre2));
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
	@Test
	void testTraerEvolucionesYInformacion() {
		String nombre3="Charizard";
		try {
			System.out.println(" \n\n Test-Traer evoluciones del pokemon y informacion; del pokemon de nombre="+nombre3+" \n \n"+ pokemonUsuarioService.traerPokemonUsuario(nombre3, "Juan"));

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	
}

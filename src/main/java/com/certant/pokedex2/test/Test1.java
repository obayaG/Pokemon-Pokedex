package com.certant.pokedex2.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;
import com.certant.pokedex2.services.IPokemonDatoService;
import com.certant.pokedex2.services.IPokemonUsuarioService;

@SpringBootTest
public class Test1 {
	

	@Autowired	
	@Qualifier("pokemonDatoService")
	private IPokemonDatoService pokemonDatoService;
	
	
	@Autowired	
	@Qualifier("pokemonUsuarioService")
	private IPokemonUsuarioService pokemonUsuarioService;
	
	
	
	 @Test
	  void testTraerTodosLosPokemon() {
		try{
			System.out.println("\n Test casos de uso \n\n Test-Traer todos los pokemon \n \n"+pokemonDatoService.traerTodosLosPokemones());
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	 
	@Test
	void testTraerNombreTipoYNivel() throws Exception {
		String nombre="Raichu";
		try {
			System.out.println(" \n\n Test-Traer pokemon de nombre -" + nombre+ "- con su respectivo nombre,tipo y nivel \n \n" + pokemonUsuarioService.traerPokemonUsuario(nombre, "Ana"));

		} catch (Exception e) {
			System.out.println(e);
		}

	}
	
	
}

package com.certant.pokedex2.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;
import com.certant.pokedex2.services.IPokemonDatoService;
import com.certant.pokedex2.services.IPokemonUsuarioService;

@SpringBootTest
public class Test3 {
	
	@Autowired	
	@Qualifier("pokemonDatoService")
	private IPokemonDatoService pokemonDatoService;
	
	@Autowired	
	@Qualifier("pokemonUsuarioService")
	private IPokemonUsuarioService pokemonUsuarioService;
	/*
	@Test 
	void testActualizarInformacionDelPokemonTipo(){
		try{
			System.out.println(" \n\n Test-Actualizar informacion del Pokemon (tipo) \n \n");
			pokemonDatoService.actualizarTipoPokemon("Pichu", "fuego", "no tiene segundo tipo");
			

		}
		catch(Exception e){
			System.out.println(e);
		}
		
	}
	*/
	
	@Test 
	public void testActualizarInformacionDelPokemonNivel(){
		try{
			System.out.println(" \n\n Test-Actualizar informacion del Pokemon (nivel)  ,si me paso del nivel se convierte en la evolucion\n \n");
			pokemonUsuarioService.actualizarNivelPokemon("Pikachu",22, "Ash");
			
		}
		catch(Exception e){
			System.out.println(e);
		}
		
	}

}

package com.certant.pokedex2.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

import com.certant.pokedex2.entities.Habilidad;
import com.certant.pokedex2.services.IPokemonDatoService;
import com.certant.pokedex2.services.IPokemonUsuarioService;

@SpringBootTest
public class Test4 {

	@Autowired	
	@Qualifier("pokemonDatoService")
	private IPokemonDatoService pokemonDatoService;
	
	@Autowired	
	@Qualifier("pokemonUsuarioService")
	private IPokemonUsuarioService pokemonUsuarioService;
	
	
	@Test
	void testAgregarYTraerNuevoPokemon(){
		//para el test 4 agregar pokemon nuevo 
		String nombre4="Absol";
		int nivelSE= 10 ;   //nivel siguiente evolucion
		int ordenE=1;		//orden evolucion
		String tipo1="siniestro";
		String tipo2="no tiene segundo tipo";
		int pokeRaza=7;	//identificador unico de la raza
		Habilidad habilidad1= new Habilidad("ataqueAbsol");
		Habilidad habilidad2= new Habilidad("ataqueAbsol2");
		Set<Habilidad> habilidades=  new HashSet<Habilidad>();
		habilidades.add(habilidad1);
		habilidades.add(habilidad2);
		
		try {
			System.out.println(" \n Test agregar pokemon: "+pokemonDatoService.agregar(nombre4, nivelSE, ordenE, tipo1, tipo2, pokeRaza, habilidades));
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
	
	@Test 
	void testActualizarInformacionDelPokemonNombre(){
		try{
			System.out.println(" \n\n Test-Actualizar informacion del Pokemon (nombre) \n \n");
			pokemonDatoService.actualizarNombrePokemon("Pichu","Pichus");

		}
		catch(Exception e){
			System.out.println(e);
		}
		
	}
	
}

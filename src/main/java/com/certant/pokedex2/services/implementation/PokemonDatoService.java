package com.certant.pokedex2.services.implementation;


import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.certant.pokedex2.converters.PokemonDatoConverter;
import com.certant.pokedex2.entities.Habilidad;
import com.certant.pokedex2.entities.PokemonDato;
import com.certant.pokedex2.entities.PokemonRaza;
import com.certant.pokedex2.entities.Tipo;
import com.certant.pokedex2.models.PokemonDatoModel;
import com.certant.pokedex2.repositories.IPokemonDatoRepository;
import com.certant.pokedex2.repositories.ITipoRepository;
import com.certant.pokedex2.services.IPokemonDatoService;

@Service("pokemonDatoService")
public class PokemonDatoService implements IPokemonDatoService{
	
	
	@Autowired
	@Qualifier("pokemonDatoRepository")
	private IPokemonDatoRepository pokemonDatoRepository;
	
	@Autowired
	@Qualifier("tipoRepository")
	private ITipoRepository tipoRepository;
	
	@Autowired
	@Qualifier("pokemonDatoConverter")
	private PokemonDatoConverter pokemonDatoConverter;
	
	@Override
	public Set<PokemonDato> traerTodosLosPokemones() {
		return pokemonDatoRepository.traerTodosLosPokemones();
	}

	@Override
	public PokemonDato agregar(String nombre, int nivelSiguienteEvolucion, int ordenEvolucion, String tipo1, String tipo2,
			int pokemonRaza, Set<Habilidad> habilidades) throws Exception{
		if(pokemonDatoRepository.traerPokemonDato(nombre)!=null)throw new Exception("Ya existe pokemon con nombre="+nombre+ " ,en la bdd, por favor ingrese nuevos datos en el setUp()");
		Tipo tipo1ABuscar= tipoRepository.traerTipo(tipo1);
		Tipo tipo2ABuscar= tipoRepository.traerTipo(tipo2);
		if(tipo1ABuscar==null) throw new Exception("No existe tipo= "+tipo1);
		if(tipo2ABuscar==null) throw new Exception("No existe tipo= "+tipo2);
		PokemonRaza pokemonRazaAAgregar= new PokemonRaza(pokemonRaza);
		PokemonDato p= new PokemonDato(nombre,tipo1ABuscar,tipo2ABuscar,nivelSiguienteEvolucion,ordenEvolucion,pokemonRazaAAgregar,habilidades);
		pokemonDatoRepository.save(p);
		return p;
	}
	

	@Override
	public PokemonDatoModel traerPokemonDato(String nombre) {
		PokemonDatoModel pokemon=pokemonDatoConverter.entityToModel(pokemonDatoRepository.traerPokemonDato(nombre));
		return pokemon;
	}

	@Override
	public Set<PokemonDato> traerListaPokemonesHabilidadEvolucion(String nombre) {
		PokemonDato p=pokemonDatoRepository.traerPokemonDato(nombre);
		int idPokemonRaza=p.getPokemonRaza().getIdPokemonRaza();
		return pokemonDatoRepository.traerListaPokemones(idPokemonRaza);
	}

	
	@Override
	public void actualizarNombrePokemon(String nombreABuscar, String nuevoNombreDeseado) throws Exception {
		PokemonDato anterior=pokemonDatoRepository.traerPokemonDato(nombreABuscar);
		if(anterior==null) throw new Exception("No existe pokemon usuario con nombre= "+nombreABuscar);
		PokemonDato existeNuevo= pokemonDatoRepository.traerPokemonDato(nuevoNombreDeseado);
		if(existeNuevo!=null) throw new Exception("Ya existe pokemon con nombre= "+nuevoNombreDeseado);
		System.out.println("\n nombre viejo \n"+anterior);
		anterior.setNombrePokemon(nuevoNombreDeseado);
		pokemonDatoRepository.save(anterior);
		PokemonDato nuevo=pokemonDatoRepository.traerPokemonDato(nuevoNombreDeseado);
		System.out.println("\n nombre nuevo \n"+nuevo);
	}

	@Override
	public void actualizarTipoPokemon(String nombreABuscar, String tipo1, String tipo2) throws Exception{
		PokemonDato p=pokemonDatoRepository.traerPokemonDato(nombreABuscar);
		Tipo t1=tipoRepository.traerTipo(tipo1);
		Tipo t2=tipoRepository.traerTipo(tipo2);
		if(p==null) throw new Exception("No existe pokemon usuario con nombre "+nombreABuscar);
		if(t1==null) throw new Exception("Error no existe tipo="+tipo1);
		if(t2==null) throw new Exception("Error no existe tipo="+tipo2);
		System.out.println("\n infopokemon antes\n"+p);
		p.setTipo1(t1);
		p.setTipo2(t2);
		pokemonDatoRepository.save(p);
		PokemonDato nuevo=pokemonDatoRepository.traerPokemonDato(nombreABuscar);
		System.out.println("\n infopokemon despues\n"+nuevo);	
	}

	
	

}

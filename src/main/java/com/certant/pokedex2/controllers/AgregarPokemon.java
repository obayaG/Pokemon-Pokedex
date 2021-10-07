package com.certant.pokedex2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.certant.pokedex2.helpers.ViewRouteHelper;

@Controller
@RequestMapping("/api/agregarPokemon")
public class AgregarPokemon {

	@GetMapping("/mostrar")  //se accede al metodo por una peticion GET
	public String index() {
		return ViewRouteHelper.AGREGARPOKEMON;
	}
}

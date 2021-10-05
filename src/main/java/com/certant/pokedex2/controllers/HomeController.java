package com.certant.pokedex2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.certant.pokedex2.helpers.ViewRouteHelper;

@Controller            //usado para indicar que es un componente controller
@RequestMapping("/")  // para especificar que ruta se va a acceder a los métodos, por medio de requests.
public class HomeController {

	/*
	@GetMapping("")  //se accede al metodo por una peticion GET
	public String index() {
		return "home/inicio.html";
	}
	*/

	@GetMapping("")  //se accede al metodo por una peticion GET
	public String index() {
		return ViewRouteHelper.INICIO;
	}
}

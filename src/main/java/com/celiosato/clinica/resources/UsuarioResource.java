package com.celiosato.clinica.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/exames")
public class UsuarioResource {
	
	@RequestMapping(method = RequestMethod.GET)
	public String listar() {
		return "Ate aqui funciona";
	}

}

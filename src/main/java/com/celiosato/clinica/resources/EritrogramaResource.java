package com.celiosato.clinica.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.celiosato.clinica.domain.Eritrograma;
import com.celiosato.clinica.services.EritrogramaService;

@RestController
@RequestMapping(value = "/exames")
public class EritrogramaResource {
	
	@Autowired
	private EritrogramaService eritrogramaService;

//Busca por um usuario
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Eritrograma>find(@PathVariable Integer id){
		Eritrograma eritrograma = eritrogramaService.find(id);
		return ResponseEntity.ok().body(eritrograma);
	}

}

package com.celiosato.clinica.resources;

import java.io.ByteArrayInputStream;
import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.celiosato.clinica.domain.Eritrograma;
import com.celiosato.clinica.domain.Usuario;
import com.celiosato.clinica.pdf.PDFGenerator;
import com.celiosato.clinica.services.EritrogramaService;
import com.celiosato.clinica.services.UsuarioService;

@RestController
@RequestMapping(value = "/exames")
public class EritrogramaResource {

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private EritrogramaService eritrogramaService;

//Busca por um exame e exibir em PDF
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<InputStreamResource> find(@PathVariable Integer id) {
		Usuario usuario = usuarioService.find(id);
		Eritrograma eritrograma = eritrogramaService.find(id);

		ByteArrayInputStream bis = PDFGenerator.usuarioPDFReport(usuario, eritrograma);

		HttpHeaders headers = new HttpHeaders();
		//Carrega o pdf na mesma Pagina
		//headers.add("Content-Disposition", "Inline; filename=clientes.pdf"); //
		headers.add("Content-Disposition", "attachment; filename=Usuario.pdf"); // Faz o download do PDF

		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
				.body(new InputStreamResource(bis));
	}
	
//Listar todos os exames
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Eritrograma>> findAll() {
		List<Eritrograma> list = eritrogramaService.findAll();
		return ResponseEntity.ok().body(list);
	}

//Inserir um exame
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> Insert(@RequestBody Eritrograma obj) {
		obj = eritrogramaService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
//Alterar um exame 
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Eritrograma obj, @PathVariable Integer id){
		obj.setId(id);
		obj = eritrogramaService.update(obj);
		return ResponseEntity.noContent().build();
	}
	
//Deletar um usuario
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		eritrogramaService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	
	
	

}

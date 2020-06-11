package com.celiosato.clinica.resources;

import java.io.ByteArrayInputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

//Busca por um usuario
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<InputStreamResource> find(@PathVariable Integer id) {
		Usuario usuario = usuarioService.find(id);
		Eritrograma eritrograma = eritrogramaService.find(id);
		
		
		ByteArrayInputStream bis = PDFGenerator.usuarioPDFReport(usuario, eritrograma);
			
		HttpHeaders headers = new HttpHeaders();
		//headers.add("Content-Disposition", "Inline; filename=clientes.pdf"); // Carrega o pdf na mesma Pagina
		headers.add("Content-Disposition", "attachment; filename=Usuario.pdf"); // Faz o download do PDF

		return ResponseEntity	
				.ok()
				.headers(headers)
				.contentType(MediaType.APPLICATION_PDF)
				.body(new InputStreamResource(bis));	
	}

}

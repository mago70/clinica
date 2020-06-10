package com.celiosato.clinica.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.celiosato.clinica.domain.Eritrograma;
import com.celiosato.clinica.domain.Usuario;
import com.celiosato.clinica.repositories.EritrogramaRepository;
import com.celiosato.clinica.services.exceptions.ObjectNotFoundException;

@Service
public class EritrogramaService {

	@Autowired
	private EritrogramaRepository eritrogramaRepository;

// Buscar um unico exame por id
	public Eritrograma find(Integer id) {
		Optional<Eritrograma> obj = eritrogramaRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Exame não encontrado, por favor confira os dados: " + id + ", Tipo: " + Usuario.class.getName()));
	}

}

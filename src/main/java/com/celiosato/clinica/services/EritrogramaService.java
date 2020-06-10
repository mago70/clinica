package com.celiosato.clinica.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.celiosato.clinica.domain.Eritrograma;
import com.celiosato.clinica.repositories.EritrogramaRepository;

@Service
public class EritrogramaService {
	
	@Autowired
	private EritrogramaRepository eritrogramaRepository;
	
// Buscar um unico exame por id
	public Eritrograma find(Integer id) {
		Optional<Eritrograma> obj = eritrogramaRepository.findById(id);
		return obj.orElse(null);
	}

}

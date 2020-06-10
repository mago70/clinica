package com.celiosato.clinica.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.celiosato.clinica.domain.Usuario;
import com.celiosato.clinica.repositories.UsuarioRepository;
import com.celiosato.clinica.services.exceptions.ObjectNotFoundException;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

//Buscar um unico Paciente por ID(ADMIN)
	public Usuario find(Integer id) {
		Optional<Usuario> obj = usuarioRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Usuario não encontrado, por favor confira os dados: " + id + ", Tipo: " + Usuario.class.getName()));
	}

}

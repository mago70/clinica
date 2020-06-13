package com.celiosato.clinica.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.celiosato.clinica.domain.Usuario;
import com.celiosato.clinica.repositories.UsuarioRepository;
import com.celiosato.clinica.services.exceptions.DataIntegrityException;
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
	
//Listar todos os usuarios
	public List<Usuario> findAll() {
		return usuarioRepository.findAll();
	}

//Inserir um usuario
	public Usuario insert(Usuario obj) {
		obj.setId(null);
		return usuarioRepository.save(obj);
	}
	
//Deletar um usuario
	public void delete(Integer id) {
		find(id);
		try {
			usuarioRepository.deleteById(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possivel excluir um usuario que possui exames!");
		}
		
	}
	
//Buscar Usuario com paginação(ADMIN)
	public Page<Usuario> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return usuarioRepository.findAll(pageRequest);	
	}

}

package com.celiosato.clinica.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.celiosato.clinica.domain.Eritrograma;

@Repository

public interface EritrogramaRepository extends JpaRepository<Eritrograma, Integer>{
	
	@Query("SELECT obj FROM Eritrograma obj WHERE obj.usuario.id = :id")
	
	Optional<Eritrograma> findById(@Param("id") Integer id);
	
}

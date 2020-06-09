package com.celiosato.clinica.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.celiosato.clinica.domain.Eritrograma;

@Repository
public interface EritrogramaRepository extends JpaRepository<Eritrograma, Integer>{

}

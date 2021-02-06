package com.rogui.contadigial.repositorys;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rogui.contadigial.domain.DocumentoRepresentante;

@Repository
public interface DocumentoRepresentanteRepository extends JpaRepository<DocumentoRepresentante, Integer> {

	Optional<DocumentoRepresentante> findByNro(String nro); 
	
}
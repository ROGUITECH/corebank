package com.rogui.contadigial.repositorys;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.rogui.contadigial.domain.Documento;

@Repository
public interface DocumentoRepository extends JpaRepository<Documento, Integer> {

	Optional<Documento> findByNro(String nro);

}
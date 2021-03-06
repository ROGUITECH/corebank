package com.rogui.contadigial.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rogui.contadigial.domain.CadastroPrincipal;

@Repository
public interface CadastroPrincipalRepository extends JpaRepository<CadastroPrincipal, Integer> {

	// public CadastroPrincipal findByNroConta (DadosConta nroConta);

	@Query("Select c from cadastro_principal c WHERE c.dadosConta.nroConta = :nroConta")
	public CadastroPrincipal findByNroConta(@Param("nroConta") String nroConta);

}

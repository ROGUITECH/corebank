package com.rogui.contadigial.repositorys;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rogui.contadigial.domain.DadosConta;

@Repository
public interface DadosContaRepository extends JpaRepository<DadosConta, String> {

	public Optional<DadosConta> findByNroConta(String nroConta);

	public Optional<DadosConta> findByCpfCnpj(String cpfCnpj);

}

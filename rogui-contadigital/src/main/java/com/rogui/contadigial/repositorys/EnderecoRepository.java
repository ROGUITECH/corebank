package com.rogui.contadigial.repositorys;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rogui.contadigial.domain.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

	Optional<Endereco> findById(Long id);

	Optional<Endereco> fidByCEP(String cep);

	Optional<Endereco> finByRua(String rua);

}

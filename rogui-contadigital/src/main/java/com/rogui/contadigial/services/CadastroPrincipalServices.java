package com.rogui.contadigial.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rogui.contadigial.domain.CadastroPrincipal;
import com.rogui.contadigial.dto.CadastroPrincipalVO;
import com.rogui.contadigial.repositorys.CadastroPrincipalRepository;

@Service
public class CadastroPrincipalServices {
	
	@Autowired
	CadastroPrincipalRepository repository;
	
	public CadastroPrincipalVO findByNroConta(String nroConta) {
		return repository.findByNroConta(nroConta);
	}
	
	public CadastroPrincipalVO findByNome(String nome) {
		return repository.findByNome(nome);
	}
	
	public CadastroPrincipalVO save(CadastroPrincipal cadastro) {
		return CadastroPrincipalVO.consumeDTO(repository.save(cadastro));
	}
	
	public CadastroPrincipalVO update(CadastroPrincipal cadastro) {
		return CadastroPrincipalVO.consumeDTO(repository.save(cadastro));
	}
}
package com.rogui.contadigial.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rogui.contadigial.domain.CadastroPrincipal;
import com.rogui.contadigial.dto.CadastroPrincipalVO;
import com.rogui.contadigial.repositorys.CadastroPrincipalRepository;

@Service
public class CadastroPrincipalServices {
	
	@Autowired
	CadastroPrincipalRepository repository;
	
	public CadastroPrincipal findByNroConta(String nroConta) {
		return repository.findByNroConta(nroConta);
	}
	
	
	public CadastroPrincipalVO save(CadastroPrincipal cadastro) {
		return CadastroPrincipalVO.consumeDTO(repository.save(cadastro));
	}
	
	public CadastroPrincipalVO update(CadastroPrincipal cadastro) {
		return CadastroPrincipalVO.consumeDTO(repository.save(cadastro));
	}
	
	public void delete(CadastroPrincipal cadastro) {
		repository.delete(cadastro);
	}


	public Optional<CadastroPrincipal> findById(Integer id) {
		
		return repository.findById(id);
	
	}
}

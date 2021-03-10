package com.rogui.contadigial.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rogui.contadigial.domain.CadastroPrincipal;
import com.rogui.contadigial.dto.CadastroPrincipalVO;
import com.rogui.contadigial.exceptions.ResourceNotFoundException;
import com.rogui.contadigial.repositorys.CadastroPrincipalRepository;

@Service
public class CadastroPrincipalServices {
	
	@Autowired
	CadastroPrincipalRepository repository;
	
	public CadastroPrincipalVO findByNroConta(String nroConta) {
		CadastroPrincipal cadastro = repository.findByNroConta(nroConta);
		return CadastroPrincipalVO.consumeDTO(cadastro);
	}
	
	
	public CadastroPrincipalVO save(CadastroPrincipal cadastro) {
		return CadastroPrincipalVO.consumeDTO(repository.save(cadastro));
	}
	
	public CadastroPrincipalVO update(CadastroPrincipal cadastro, Integer id) {
		return CadastroPrincipalVO.consumeDTO(repository.save(cadastro));
	}
	
	public void delete(Integer id) {
		repository.deleteById(id);
	}


	public CadastroPrincipalVO findById(Integer id) {
		CadastroPrincipal cadastro = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Registro nao encontrado"));
		return CadastroPrincipalVO.consumeDTO(cadastro);
	
	}
}


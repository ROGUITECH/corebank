package com.rogui.contadigial.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.rogui.contadigial.dto.CadastroPrincipalVO;
import com.rogui.contadigial.repositorys.CadastroPrincipalRepository;

public class CadastroPrincipalServices {
	
	@Autowired
	CadastroPrincipalRepository repository;
	
	public CadastroPrincipalVO findByNroConta(String nroConta) {
		return null;
		
		
		
	}

}

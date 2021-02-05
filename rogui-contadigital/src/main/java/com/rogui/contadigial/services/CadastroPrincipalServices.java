package com.rogui.contadigial.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

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
	
	public CadastroPrincipal update(CadastroPrincipal cadastro, Integer id) throws Exception {
		Assert.notNull(id,"Não foi possível atualizar o cadastro!");
		
		Optional<CadastroPrincipal> optional = findById(id);
		if (optional.isPresent()) {
			CadastroPrincipal cp = optional.get();
			cp.setNome(cadastro.getNome());
			cp.setDtNascimento(cadastro.getDtNascimento());
			cp.setEmail(cadastro.getEmail());
			cp.setTpPessoa(cadastro.getTpPessoa());
			cp.setDadosConta(cadastro.getDadosConta());
			
			repository.save(cadastro);
			
			return cp;
			
		}else {
			throw new Exception("Não foi possipvel atualizar o cadastro!");
		}
	}
	
	public void delete(Integer id) {
		Optional<CadastroPrincipal> cad = findById(id);
		if (cad.isPresent()) {
		repository.deleteById(id);
		}
	}


	public Optional<CadastroPrincipal> findById(Integer id) {
		
		return repository.findById(id);
	
	}
}


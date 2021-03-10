package com.rogui.contadigial.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rogui.contadigial.domain.Endereco;
import com.rogui.contadigial.dto.EnderecoVO;
import com.rogui.contadigial.exceptions.ResourceNotFoundException;
import com.rogui.contadigial.repositorys.EnderecoRepository;

@Service
public class EnderecoServices {
	@Autowired
	EnderecoRepository endRep;
	
	public EnderecoVO findById(Long id){
		Endereco end = endRep.findById(id).orElseThrow(() -> new ResourceNotFoundException("Registro nao encontrado"));
		return EnderecoVO.consumeDTO(end);
	}
	
	
	public EnderecoVO salvaEnd(Endereco end) {
		return EnderecoVO.consumeDTO(endRep.save(end));
	}
	
	public EnderecoVO update(Endereco end, Long id) {
		return EnderecoVO.consumeDTO(endRep.save(end));
	}
	
	public void delete(Long id) {
		endRep.deleteById(id);
	}
}

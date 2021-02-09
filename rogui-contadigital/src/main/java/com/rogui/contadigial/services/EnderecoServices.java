package com.rogui.contadigial.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.rogui.contadigial.domain.Endereco;
import com.rogui.contadigial.dto.EnderecoVO;
import com.rogui.contadigial.repositorys.EnderecoRepository;

@Service
public class EnderecoServices {
	@Autowired
	EnderecoRepository endRep;
	
	public Optional<Endereco> findById(Long id){
		return endRep.findById(id);
	}
	
	public Optional<Endereco> findByCEP(String cep){
		return endRep.fidByCEP(cep);
	}
	
	public Optional<Endereco> findByRua(String rua){
		return endRep.finByRua(rua);
	}
	
	public EnderecoVO salvaEnd(Endereco end) {
		return EnderecoVO.consumeDTO(endRep.save(end));
	}
	
	public Endereco update(Endereco end, Long id) throws Exception {
		Assert.notNull(id,"Não foi possível atualizar o endereço cadastrado!");
		
		Optional<Endereco> optional = findById(id);
		if (optional.isPresent()) {
			Endereco endereco = optional.get();
			endereco.setRua(end.getRua());
			endereco.setNro(end.getNro());
			endereco.setComplemento(end.getComplemento());
			endereco.setTpEndereco(end.getTpEndereco());
			endereco.setCidade(end.getCidade());
			endereco.setUf(end.getUf());
			endereco.setCep(end.getCep());
			endereco.setCadastro(end.getCadastro());
			endRep.save(end);
			
			return endereco;
			
		}else {
			throw new Exception("Não foi possipvel atualizar o enderecço cadastrado!");
		}
	}
	
	public void delete(Long id) {
		Optional<Endereco> doc = findById(id);
		if (doc.isPresent()) {
		endRep.deleteById(id);
		}
	}
}

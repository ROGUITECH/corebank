package com.rogui.contadigial.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rogui.contadigial.domain.DadosConta;
import com.rogui.contadigial.dto.DadosContaVO;
import com.rogui.contadigial.enums.EnumStatusConta;
import com.rogui.contadigial.exceptions.ResourceNotFoundException;
import com.rogui.contadigial.repositorys.DadosContaRepository;

@Service
public class DadosContaServices {

	@Autowired
	DadosContaRepository rep;

	public DadosContaVO findByNroConta(String nroConta) {

		DadosConta dados = rep.findByNroConta(nroConta)
				.orElseThrow(() -> new ResourceNotFoundException("Registro nao encontrado"));
		return DadosContaVO.consumeDTO(dados);

	}

	public DadosContaVO findByCpfCnpj(String cpfCnpj) {
		DadosConta dados = rep.findByCpfCnpj(cpfCnpj)
				.orElseThrow(() -> new ResourceNotFoundException("Registro nao encontrado"));
		return DadosContaVO.consumeDTO(dados);

	}

	public DadosContaVO save(DadosConta dados) {
		return DadosContaVO.consumeDTO(rep.save(dados));
	}

	public void delete(String nroConta) {
		rep.deleteById(nroConta);
	}

	public DadosContaVO update(DadosConta dados) {
		return DadosContaVO.consumeDTO(rep.save(dados));

	}

	public DadosContaVO ativarConta(String nroConta) {
		DadosConta conta = rep.findByNroConta(nroConta).get();
		conta.setStatus(EnumStatusConta.ATIVO);
		return DadosContaVO.consumeDTO(rep.save(conta));
	}

	public DadosContaVO bloquearConta(String nroConta) {
		DadosConta conta = rep.findByNroConta(nroConta).get();
		conta.setStatus(EnumStatusConta.BLOQUEADO);
		return DadosContaVO.consumeDTO(rep.save(conta));
	}

	public DadosContaVO encerradoConta(String nroConta) {
		DadosConta conta = rep.findByNroConta(nroConta).get();
		conta.setStatus(EnumStatusConta.ENCERRADO);
		return DadosContaVO.consumeDTO(rep.save(conta));
	}
}

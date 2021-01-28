package com.rogui.contadigial.dto;

import java.util.Date;


import java.util.List;

import com.rogui.contadigial.domain.CadastroPrincipal;
import com.rogui.contadigial.domain.DadosConta;
import com.rogui.contadigial.domain.Documento;
import com.rogui.contadigial.domain.Endereco;
import com.rogui.contadigial.domain.RepresentanteLegal;
import com.rogui.contadigial.domain.Telefone;
import com.rogui.contadigial.enums.EnumPessoa;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CadastroPrincipalVO {
	
	private EnumPessoa tpPessoa;
	private String nome;
	private Date dtNascimento;
	private String email;
	private DadosConta dadosConta;
	private List<Telefone> fones;
	private List<Endereco> enderecos;
	private List<Documento> documentos;
	private List<RepresentanteLegal> representantes;
	
	public static CadastroPrincipalVO consumeDTO (CadastroPrincipal cadastro) {
		return CadastroPrincipalVO.builder().
				tpPessoa(cadastro.getTpPessoa()).
				nome(cadastro.getNome()).
				dtNascimento(cadastro.getDtNascimento()).
				email(cadastro.getEmail()).
				dadosConta(cadastro.getDadosConta()).
				fones(cadastro.getFones()).
				enderecos(cadastro.getEnderecos()).
				documentos(cadastro.getDocumentos()).
				representantes(cadastro.getRepresentantes()).
				build();
	}
	
	public static CadastroPrincipal consumeEntity (CadastroPrincipalVO vo) {
		return CadastroPrincipal.builder().
				tpPessoa(vo.getTpPessoa()).
				nome(vo.getNome()).
				dtNascimento(vo.getDtNascimento()).
				email(vo.getEmail()).
				dadosConta(vo.getDadosConta()).
				fones(vo.getFones()).
				enderecos(vo.getEnderecos()).
				documentos(vo.getDocumentos()).
				representantes(vo.getRepresentantes()).
				build();
	}
}

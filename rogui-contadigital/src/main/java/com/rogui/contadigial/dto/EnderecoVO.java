package com.rogui.contadigial.dto;

import com.rogui.contadigial.domain.CadastroPrincipal;

import com.rogui.contadigial.domain.Endereco;
import com.rogui.contadigial.enums.EnumEndereco;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EnderecoVO {
	
	private Long id;
	private EnumEndereco tpEndereco;
	private String rua;
	private Integer nro;
	private String complemento;
	private String distrito;
	private String cep;
	private String cidade;
	private String uf;
	private CadastroPrincipal cadastro;
	
	public static EnderecoVO consumeDTO(Endereco end) {
		return EnderecoVO.builder().
				id(end.getId()).
				tpEndereco(end.getTpEndereco()).
				rua(end.getRua()).
				nro(end.getNro()).complemento(end.getComplemento()).
				distrito(end.getDistrito()).
				cep(end.getCep()).
				cidade(end.getCidade()).
				uf(end.getUf()).
				cadastro(end.getCadastro()).
				build();
	}
	
	public static Endereco consumeEntity(EnderecoVO endVO) {
		return Endereco.builder().
				id(endVO.getId()).
				tpEndereco(endVO.getTpEndereco()).
				rua(endVO.getRua()).
				nro(endVO.getNro()).
				complemento(endVO.getComplemento()).
				distrito(endVO.getDistrito()).
				cep(endVO.getCep()).
				cidade(endVO.getCidade()).
				uf(endVO.getUf()).
				cadastro(endVO.getCadastro()).
				build();

	}
}

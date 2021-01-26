package com.rogui.contadigial.dto;

import java.util.Date;


import com.fasterxml.jackson.annotation.JsonAlias;
import com.rogui.contadigial.domain.DadosConta;
import com.rogui.contadigial.enums.EnumStatusConta;

//import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DadosContaVO {
	
	//@ApiModelProperty(value = "Nro da conta digital")
	private String nroConta;
	//@ApiModelProperty(value = "Dígito da conta digital")
	private Integer div;
	//@ApiModelProperty(value = "Código da agência")
	private String agencia;
	private EnumStatusConta status;
	private String nroContaParceiro;
	private Date dtAbertura;
	private Date dtEncerramento;
	private String cpfCnpj;
	

	public static DadosContaVO consumeDTO(DadosConta conta) {
		return DadosContaVO.builder()
				.nroConta(conta.getNroConta())
				.div(conta.getDiv())
				.cpfCnpj(conta.getCpfCnpj())
				.status(conta.getStatus())
				.dtAbertura(conta.getDtAbertura())
				.dtEncerramento(conta.getDtEncerramento())
				.status(conta.getStatus())
				.build();
		
	}
	
	public static DadosConta consumeEntity(DadosContaVO vo)	{
		return DadosConta.builder()
				.nroConta(vo.getNroConta())
				.div(vo.getDiv())
				.cpfCnpj(vo.getCpfCnpj())
				.status(vo.getStatus())
				.dtAbertura(vo.getDtAbertura())
				.dtEncerramento(vo.getDtEncerramento())
				.status(vo.getStatus())
				.build();
	}
}

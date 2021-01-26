package com.rogui.contadigial.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.rogui.contadigial.enums.EnumStatusConta;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
@Entity(name = "dados_conta")
public class DadosConta implements Serializable {

	private static final long serialVersionUID = 1L;

	@EqualsAndHashCode.Include
	@Id
	@Column(name = "nro_conta", unique = true, nullable = true, length = 50)
	private String nroConta;

	@Column(name = "digito_verificacao", length = 1)
	private Integer div;
	@Column(name = "agencia", length = 6)
	private String agencia;
	@Column(name = "status", length = 10)
	@Enumerated(EnumType.STRING)
	private EnumStatusConta status;
	@Column(name = "nro_conta_parceiro", length = 25)
	private String nroContaParceiro;
	@Column(name = "dt_abertura")
	@Temporal(TemporalType.DATE)
	private Date dtAbertura;
	@Column(name = "dt_encerramento")
	@Temporal(TemporalType.DATE)
	private Date dtEncerramento;
	@EqualsAndHashCode.Include
	@Column(name = "cpf_cnpj", length = 14)
	private String cpfCnpj;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "nro_conta")
	private List<CadastroPrincipal> cadastros;

}

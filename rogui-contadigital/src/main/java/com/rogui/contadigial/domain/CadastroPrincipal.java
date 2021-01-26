package com.rogui.contadigial.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.rogui.contadigial.enums.EnumPessoa;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "cadastro_principal")
public class CadastroPrincipal implements Serializable {

	private static final long serialVersionUID = 1L;

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cadastro", nullable = false, updatable = false)
	private Integer id;

	@Column(name = "tipo_pessoa", length = 15)
	@Enumerated(EnumType.STRING)
	private EnumPessoa tpPessoa;
	@Column(name = "nome", length = 50)
	private String nome;
	@Column(name = "dt_nascimento", length = 20)
	@Temporal(TemporalType.DATE)
	private Date dtNascimento;
	@Column(name = "email", length = 50)
	private String email;

	@ManyToOne
	@JoinColumn(name = "nro_conta")
	private DadosConta dadosConta;

	@OneToMany
	@JoinColumn(name = "id_cadastro")
	private List<Telefone> fones;

	@OneToMany
	@JoinColumn(name = "id_cadastro")
	private List<Endereco> enderecos;

	@OneToMany
	@JoinColumn(name = "id_cadastro")
	private List<Documento> documentos;
	
	@OneToMany
	@JoinColumn(name = "id_cadastro")
	private List<RepresentanteLegal> representantes;
	

}

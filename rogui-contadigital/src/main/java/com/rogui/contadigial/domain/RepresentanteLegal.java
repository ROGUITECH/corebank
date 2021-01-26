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

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
@Entity(name = "representante_legal")
public class RepresentanteLegal implements Serializable {

	private static final long serialVersionUID = 1L;

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_representante", nullable = false, updatable = false)
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
	@JoinColumn(name = "id_cadastro")
	private CadastroPrincipal cadastro;

	@OneToMany
	@JoinColumn(name = "id_representante")
	private List<TelefoneRepresentante> fones;

	@OneToMany
	@JoinColumn(name = "id_representante")
	private List<EnderecoRepresentante> enderecos;

	@OneToMany
	@JoinColumn(name = "id_representante")
	private List<DocumentoRepresentante> documentos;

}

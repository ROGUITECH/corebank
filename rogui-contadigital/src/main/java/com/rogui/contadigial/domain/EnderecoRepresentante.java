package com.rogui.contadigial.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.rogui.contadigial.enums.EnumEndereco;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
@Builder
@Entity(name = "endereco_representante")
public class EnderecoRepresentante implements Serializable {

	private static final long serialVersionUID = 1L;

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_endereco", nullable = false, updatable = false)
	private Long id;

	@Column(name = "tp_endereco", length = 15)
	@Enumerated(EnumType.STRING)
	private EnumEndereco tpEndereco;
	@Column(name = "rua", length = 50)
	private String rua;
	@Column(name = "nro")
	private Integer nro;
	@Column(name = "complemento", length = 50)
	private String complemento;
	@Column(name = "distrito", length = 25)
	private String distrito;
	@Column(name = "cep", length = 10)
	private String cep;
	@Column(name = "cidade", length = 20)
	private String cidade;
	@Column(name = "uf", length = 2)
	private String uf;

	@ManyToOne
	@JoinColumn(name = "id_representante")
	private RepresentanteLegal representanteLegal;

}

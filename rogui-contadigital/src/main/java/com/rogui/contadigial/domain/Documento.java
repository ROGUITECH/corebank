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

import com.rogui.contadigial.enums.EnumDocumento;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
@Getter
@Setter
@Entity(name = "documento")
public class Documento implements Serializable {

	private static final long serialVersionUID = 1L;

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_documento", nullable = false, updatable = false)
	private Integer id;
	@Column(name = "nro", length = 20)
	private String nro;
	@Column(name = "tp_documento", length = 15)
	@Enumerated(EnumType.STRING)
	private EnumDocumento tpDocumento;
	@Column(name = "identificado", length = 1)
	private Boolean identificado;

	@ManyToOne
	@JoinColumn(name = "id_cadastro")
	private CadastroPrincipal cadastro;

}

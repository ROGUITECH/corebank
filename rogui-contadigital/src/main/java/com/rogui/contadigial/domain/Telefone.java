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

import com.rogui.contadigial.enums.EnumFone;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
@Getter
@Setter
@Entity(name = "telefone")
public class Telefone implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_fone", nullable = false, updatable = false)
	private Long id;

	@Column(name = "ddd", length = 3, nullable = false)
	private String ddd;

	@Column(name = "nro", length = 15)
	private String nro;

	@Enumerated(EnumType.STRING)
	private EnumFone tpFone;

	@ManyToOne
	@JoinColumn(name = "id_cadastro")
	private CadastroPrincipal cadastro;

}

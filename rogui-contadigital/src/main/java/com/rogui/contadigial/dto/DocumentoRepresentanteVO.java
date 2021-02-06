package com.rogui.contadigial.dto;

import com.rogui.contadigial.domain.DocumentoRepresentante;
import com.rogui.contadigial.domain.RepresentanteLegal;
import com.rogui.contadigial.enums.EnumDocumento;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DocumentoRepresentanteVO {
	
	private Integer id;
	private String nro;
	private EnumDocumento tpDocumento;
	private Boolean identificado;
	private RepresentanteLegal representanteLegal;
	
	public static DocumentoRepresentanteVO consumeDTO(DocumentoRepresentante docRepr) {
		return DocumentoRepresentanteVO.
				builder().
				id(docRepr.getId()).
				nro(docRepr.getNro()).
				tpDocumento(docRepr.getTpDocumento()).
				identificado(docRepr.getIdentificado()).
				representanteLegal(docRepr.getRepresentanteLegal()).
				build();
		}
	
	public static DocumentoRepresentante consumeEntity(DocumentoRepresentanteVO docRepVO) {
		return DocumentoRepresentante.
				builder().
				id(docRepVO.getId()).
				nro(docRepVO.getNro()).
				tpDocumento(docRepVO.getTpDocumento()).
				identificado(docRepVO.getIdentificado()).
				representanteLegal(docRepVO.getRepresentanteLegal()).
				build();
	}
	
}

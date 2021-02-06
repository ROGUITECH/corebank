package com.rogui.contadigial.dto;

import com.rogui.contadigial.domain.CadastroPrincipal;
import com.rogui.contadigial.domain.Documento;
import com.rogui.contadigial.enums.EnumDocumento;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DocumentoVO {
	private Integer id;
	private String nro;
	private EnumDocumento tpDocumento;
	private Boolean identificado;
	private CadastroPrincipal cadastro;
	
	public static DocumentoVO consumeDTO(Documento doc) {
		return DocumentoVO.builder().
				id(doc.getId()).
				nro(doc.getNro()).
				tpDocumento(doc.getTpDocumento()).
				identificado(doc.getIdentificado()).
				cadastro(doc.getCadastro()).
				build();
	}
	
	
	public static Documento consumeEntity(DocumentoVO vo) {
		return Documento.builder().
				id(vo.getId()).
				nro(vo.getNro()).
				tpDocumento(vo.getTpDocumento()).
				identificado(vo.getIdentificado()).
				cadastro(vo.getCadastro()).
				build();
	}
}

package com.rogui.contadigial.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rogui.contadigial.domain.Documento;
import com.rogui.contadigial.dto.DocumentoVO;
import com.rogui.contadigial.exceptions.ResourceNotFoundException;
import com.rogui.contadigial.repositorys.DocumentoRepository;

@Service
public class DocumentoServices {
	
	@Autowired
	DocumentoRepository docRep;
	
	public DocumentoVO findById(Integer id){
		Documento doc = docRep.findById(id).orElseThrow();
		return DocumentoVO.consumeDTO(doc);
	}


	public DocumentoVO findByNro(String nro) {
		Documento doc = docRep.findByNro(nro).orElseThrow(() -> new ResourceNotFoundException("Registro não encontrdo"));
		return DocumentoVO.consumeDTO(doc);
	}
	
	public DocumentoVO salvaDoc(Documento doc) {
		return DocumentoVO.consumeDTO(docRep.save(doc));
	}
	
	public DocumentoVO update(Documento doc, Integer id) throws Exception {
		return DocumentoVO.consumeDTO(docRep.save(doc));
	}
	
	public void delete(Integer id) {
		docRep.deleteById(id);
	}
		
}

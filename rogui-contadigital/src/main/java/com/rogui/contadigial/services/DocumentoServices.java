package com.rogui.contadigial.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.rogui.contadigial.domain.Documento;
import com.rogui.contadigial.dto.DocumentoVO;
import com.rogui.contadigial.repositorys.DocumentoRepository;

@Service
public class DocumentoServices {
	
	@Autowired
	DocumentoRepository docRep;
	
	public Optional <Documento> findById(Integer id){
		return docRep.findById(id);
	}


	public Optional<Documento> findByNro(String nro) {
		return docRep.findByNro(nro);
	}
	
	public DocumentoVO salvaDoc(Documento doc) {
		return DocumentoVO.consumeDTO(docRep.save(doc));
	}
	
	public Documento update(Documento doc, Integer id) throws Exception {
		Assert.notNull(id,"Não foi possível atualizar o documento cadastrado!");
		
		Optional<Documento> optional = findById(id);
		if (optional.isPresent()) {
			Documento dcm = optional.get();
			dcm.setNro(doc.getNro());
			dcm.setTpDocumento(doc.getTpDocumento());
			dcm.setIdentificado(doc.getIdentificado());
			dcm.setCadastro(doc.getCadastro());
						
			docRep.save(doc);
			
			return dcm;
			
		}else {
			throw new Exception("Não foi possipvel atualizar o documento cadastrado!");
		}
	}
	
	public void delete(Integer id) {
		Optional<Documento> doc = findById(id);
		if (doc.isPresent()) {
		docRep.deleteById(id);
		}
	}
		
}

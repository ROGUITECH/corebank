package com.rogui.contadigial.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.rogui.contadigial.domain.DocumentoRepresentante;
import com.rogui.contadigial.dto.DocumentoRepresentanteVO;
import com.rogui.contadigial.repositorys.DocumentoRepresentanteRepository;

@Service
public class DocumentoRepresentanteServices {
	
	@Autowired
	DocumentoRepresentanteRepository docRepRepo;
	
	public Optional<DocumentoRepresentante>	findById(Integer id){
		return docRepRepo.findById(id);
	}
	
	public Optional<DocumentoRepresentante> findByNro(String nro) {
		return docRepRepo.findByNro(nro);
	}
	
	public DocumentoRepresentanteVO saveDocRep(DocumentoRepresentante docRepr) {
		return DocumentoRepresentanteVO.consumeDTO(docRepRepo.save(docRepr));
	}
	
	public DocumentoRepresentante update(DocumentoRepresentante docRepr, Integer id) throws Exception {
		Assert.notNull(id,"Não foi possível atualizar o cadastrado do documento!");
		
		Optional<DocumentoRepresentante> optional = findById(id);
		if (optional.isPresent()) {
			DocumentoRepresentante dcmRep = optional.get();
			dcmRep.setNro(docRepr.getNro());
			dcmRep.setTpDocumento(docRepr.getTpDocumento());
			dcmRep.setIdentificado(docRepr.getIdentificado());
			dcmRep.setRepresentanteLegal(docRepr.getRepresentanteLegal());
						
			docRepRepo.save(docRepr);
			
			return dcmRep;
			
		}else {
			throw new Exception("Não foi possipvel atualizar o cadastrado do cadastro!");
		}
	}
	
	public void delete(Integer id) {
		Optional<DocumentoRepresentante> docR = findById(id);
		if (docR.isPresent()) {
		docRepRepo.deleteById(id);
		}
	}
}

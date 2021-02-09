package com.rogui.contadigial.resources;

import java.net.URI;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.rogui.contadigial.domain.DocumentoRepresentante;
import com.rogui.contadigial.dto.DocumentoRepresentanteVO;
import com.rogui.contadigial.services.DocumentoRepresentanteServices;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "DocumentoRepresentanteEndPoint")
@RestController
@RequestMapping("/api/v1/documentoRepresentante")
public class DocumentoRepresentanteController {
	
	@Autowired
	private DocumentoRepresentanteServices docRepServ;
	
	@ApiOperation(value = "Consulta documento do representante cadastrado pelo id do documento")
	@GetMapping(value = "/id/{id}", produces = { "application/json", "application/xml" })
	public ResponseEntity<Optional<DocumentoRepresentante>> finById(@PathVariable ("id") Integer id){
		Optional<DocumentoRepresentante> optionaldcmRep = docRepServ.findById(id);
		return ResponseEntity.ok(optionaldcmRep);
	}
	
	@ApiOperation(value = "Consulta documento do representante cadastrado pelo número deste")
	@GetMapping(value = "/nroDocumentoRep/{nro}", produces = { "application/json", "application/xml" })
	public ResponseEntity<Optional<DocumentoRepresentante>> findByNro(@PathVariable("nro") String nro){
		Optional<DocumentoRepresentante> optionaldocRep = docRepServ.findByNro("nro");
		return ResponseEntity.ok(optionaldocRep);
	}
	
	@ApiOperation(value = "Cadastrando documento do representante na base")
	@PostMapping(produces = { "application/json", "application/xml" }, consumes = {
			"application/json", "application/xml" })
	public ResponseEntity<DocumentoRepresentanteVO> create(@RequestBody DocumentoRepresentanteVO docVO) {
		DocumentoRepresentanteVO dcmRepVO = docRepServ.saveDocRep(DocumentoRepresentanteVO.consumeEntity(docVO));

		URI location = getUri(Long.valueOf(dcmRepVO.getId()));
		return ResponseEntity.created(location).build();
	}
	
	private URI getUri(Long id) {
		return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
	}
	
	
	@ApiOperation(value = "Alteração de dados do documento do representante")
	@PutMapping(value = "/{id}")
	public String update(@PathVariable ("id") Integer id, @RequestBody DocumentoRepresentante docRepr) throws Exception {
		DocumentoRepresentante dcmRepr = docRepServ.update(docRepr, id);
		return "Cadastro do documento do representante atualizado com sucesso!" + dcmRepr.getId();
	}
	
	@ApiOperation(value = "Deleta um registro de documento do representante pelo id")
	@DeleteMapping(value = "/{id}")
	public String delete(@PathVariable ("id")Integer id) {
		docRepServ.delete(id);
		return "Documento do representante deletado com sucesso!";
	}
}



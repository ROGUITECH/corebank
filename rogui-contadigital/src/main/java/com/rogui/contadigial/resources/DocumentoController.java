package com.rogui.contadigial.resources;

import java.net.URI;

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

import com.rogui.contadigial.domain.Documento;
import com.rogui.contadigial.dto.DocumentoVO;
import com.rogui.contadigial.services.DocumentoServices;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "DocumentoEndPoint")
@RestController
@RequestMapping("/api/v1/documento")
public class DocumentoController {
	
	@Autowired
	private DocumentoServices docServ;
	
	@ApiOperation(value = "Consulta documento cadastrado pelo id")
	@GetMapping(value = "/id/{id}", produces = { "application/json", "application/xml" })
	public ResponseEntity<DocumentoVO> finById(@PathVariable ("id") Integer id){
		DocumentoVO optionaldcm = docServ.findById(id);
		return ResponseEntity.ok(optionaldcm);
	}
	
	@ApiOperation(value = "Consulta documento cadastrado pelo número deste")
	@GetMapping(value = "/nroDocumento/{nro}", produces = { "application/json", "application/xml" })
	public ResponseEntity<DocumentoVO> findByNro(@PathVariable("nro") String nro){
		DocumentoVO optionaldo = docServ.findByNro("nro");
		return ResponseEntity.ok(optionaldo);
	}
	
	@ApiOperation(value = "Cadastrando documento na Base")
	@PostMapping(produces = { "application/json", "application/xml" }, consumes = {
			"application/json", "application/xml" })
	public ResponseEntity<DocumentoVO> create(@RequestBody DocumentoVO docVO) {
		DocumentoVO dcm = docServ.salvaDoc(DocumentoVO.consumeEntity(docVO));

		URI location = getUri(Long.valueOf(dcm.getId()));
		return ResponseEntity.created(location).build();
	}
	
	private URI getUri(Long id) {
		return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
	}
	
	@ApiOperation(value = "Alteração de dados do documento cadastrado")
	@PutMapping(value = "/{id}")
	public String update(@PathVariable ("id") Integer id, @RequestBody Documento doc) throws Exception {
		DocumentoVO dcm = docServ.update(doc, id);
		return "Cadastro atualizado com sucesso!" + dcm.getId();
	}
	
	@ApiOperation(value = "Deleta um registro de documento pelo id")
	@DeleteMapping(value = "/{id}")
	public String delete(@PathVariable ("id")Integer id) {
		docServ.delete(id);
		return "Documento deletado com sucesso!";
	}
}

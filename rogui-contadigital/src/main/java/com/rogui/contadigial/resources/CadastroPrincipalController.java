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

import com.rogui.contadigial.domain.CadastroPrincipal;
import com.rogui.contadigial.dto.CadastroPrincipalVO;
import com.rogui.contadigial.services.CadastroPrincipalServices;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "CadastroPrincipalEndPoint")
@RestController
@RequestMapping("/api/v1/cadastroprincipal")
public class CadastroPrincipalController {

	
	@Autowired
	private CadastroPrincipalServices cpservices;
	
	@ApiOperation(value = "Cadastrando cliente na Base")
	@PostMapping(produces = { "application/json", "application/xml" }, consumes = {
			"application/json", "application/xml" })
	public ResponseEntity<CadastroPrincipalVO> create(@RequestBody CadastroPrincipalVO cadastro) {
		CadastroPrincipalVO cad = cpservices.save(CadastroPrincipalVO.consumeEntity(cadastro));

		URI location = getUri(Long.valueOf(cad.getId()));
		return ResponseEntity.created(location).build();
	}
	
	private URI getUri(Long id) {
		return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
	}	
	
	@ApiOperation(value = "Consulta cadastro pelo número da conta")
	@GetMapping(value = "/nroConta/{nroConta}", produces = { "application/json", "application/xml" })
	public ResponseEntity<CadastroPrincipalVO> finByNroConta(@PathVariable ("nroConta") String nroConta){
		CadastroPrincipalVO cp = cpservices.findByNroConta(nroConta);
		return ResponseEntity.ok(cp);
	}
	
	@ApiOperation(value = "Consulta cadastro pelo id cadastral")
	@GetMapping(value = "/id/{id}", produces = { "application/json", "application/xml" })
	public ResponseEntity<CadastroPrincipalVO> finById(@PathVariable ("id") Integer id){
		CadastroPrincipalVO cp = cpservices.findById(id);
		return ResponseEntity.ok(cp);
	}
	
	@ApiOperation(value = "Atualização de dados cadastrais")
	@PutMapping(value = "/{id}")
	public String update(@PathVariable ("id") Integer id, @RequestBody CadastroPrincipal cadastro) throws Exception {
		CadastroPrincipalVO cad = cpservices.update(cadastro, id);
		return "Cadastro atualizado com sucesso!" + cad.getId();
	}
	
	@ApiOperation(value = "Deleta um registro da base")
	@DeleteMapping(value = "/{id}")
	public String delete(@PathVariable ("id")Integer id) {
		cpservices.delete(id);
		return "Cadastro deletado com sucesso!";
	}
	
}

package com.rogui.contadigial.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.rogui.contadigial.dto.CadastroPrincipalVO;
import com.rogui.contadigial.services.CadastroPrincipalServices;

import io.swagger.annotations.ApiOperation;

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

		URI location = getUri(Long.valueOf(cad.getNome()));
		return ResponseEntity.created(location).build();
	}
	
	private URI getUri(Long id) {
		return ServletUriComponentsBuilder.fromCurrentRequest().path("/{nome}").buildAndExpand(id).toUri();
	}	
	
	@ApiOperation(value = "Consulta cadastro pelo número da conta")
	@GetMapping(value = "/nroConta/{nroConta}", produces = { "application/json", "application/xml" })
	public ResponseEntity<CadastroPrincipalVO> finByNroConta(@PathVariable ("nroConta") String nroConta){
		CadastroPrincipalVO cpVO = cpservices.findByNroConta(nroConta);
		return ResponseEntity.ok(cpVO);
	}
	
	@ApiOperation(value = "Consulta cadastro pelo nome presente na base")
	@GetMapping(value = "/nome/{nome}", produces = { "application/json", "application/xml" })
	public ResponseEntity<CadastroPrincipalVO> findByName(@PathVariable("nome")String nome){
		CadastroPrincipalVO cpVO = cpservices.findByNome(nome);
		return ResponseEntity.ok(cpVO);
	}
	
	@ApiOperation(value = "Atualização de dados cadastrais")
	@PutMapping(produces = { "application/json", "application/xml"}, consumes = {
			"application/json", "application/xml" })
	public ResponseEntity<CadastroPrincipalVO> update(@RequestBody CadastroPrincipalVO cadastro) {
		cpservices.update(CadastroPrincipalVO.consumeEntity(cadastro));
		return ResponseEntity.noContent().build();
	}
}

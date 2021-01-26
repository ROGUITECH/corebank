package com.rogui.contadigial.resources;

import java.net.URI;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.rogui.contadigial.dto.DadosContaVO;
import com.rogui.contadigial.services.DadosContaServices;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "DadosContaEndPoint")
@RestController
@RequestMapping("/api/dadosconta/v1")
public class DadosContaController {

	@Autowired
	private DadosContaServices services;

	
	 /*@ApiOperation(value = "Lista todas as contas criadas no RoguiBank")
	 @GetMapping(produces = { "application/json", "application/xml",
	  "application/x-yaml" }) public List<AccountBankVO> findAll() {
	 List<AccountBankVO> accounts = services.findAll();
	 accounts.stream().forEach(p -> { Link link =
	 linkTo(methodOn(DadosContaController.class).findById(p.getId())).withSelfRel(
	 ); p.add(link); });
	 
	 return accounts; }*/
	

	@ApiOperation(value = "Consulta conta criada pelo numero")
	@ApiResponses(value = {
		    @ApiResponse(code = 200, message = "Retorna a lista de pessoa"),
		    @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
		    @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
		})
	@GetMapping(value = "/nroconta/{nroConta}", produces = { "application/json", "application/xml" })
	public ResponseEntity<DadosContaVO> findByNroConta(@PathVariable("nroConta") String nroConta) {
		DadosContaVO conta = services.findByNroConta(nroConta);
		return ResponseEntity.ok(conta);
	}

	@ApiOperation(value = "Consulta conta criada pelo cpf ou cnpj")
	@GetMapping(value = "/documento/{cpfcnpj}", produces = { "application/json", "application/xml" })
	public ResponseEntity<DadosContaVO> findByCpfCnpj(@PathVariable("cpfcnpj") String cpfcnpj) {

		DadosContaVO conta = services.findByCpfCnpj(cpfcnpj);
		return ResponseEntity.ok(conta);
	}

	@ApiOperation(value = "Criação da conta na Base RoguiBank")
	@PostMapping(produces = { "application/json", "application/xml" }, consumes = {
			"application/json", "application/xml" })
	public ResponseEntity<DadosContaVO> create(@RequestBody DadosContaVO dados) {
		DadosContaVO conta = services.save(DadosContaVO.consumeEntity(dados));

		URI location = getUri(Long.valueOf(conta.getNroConta()));
		return ResponseEntity.created(location).build();
	}

	@ApiOperation(value = "Atualização dos dados da conta na Base RoguiBank")
	@PutMapping(produces = { "application/json", "application/xml"}, consumes = {
			"application/json", "application/xml" })
	public ResponseEntity<DadosContaVO> update(@RequestBody DadosContaVO dados) {
		services.update(DadosContaVO.consumeEntity(dados));
		return ResponseEntity.noContent().build();
	}

	@ApiOperation(value = "Realiza o encerramento da conta na Base RoguiBank")
	@PatchMapping(produces = { "application/json", "application/xml" }, consumes = {
			"application/json", "application/xml" }, value = "/{nroconta}/encerrar")
	public ResponseEntity<DadosContaVO> encerrarConta(@PathVariable("nroconta") String nroConta) {

		services.encerradoConta(nroConta);
		return ResponseEntity.noContent().build();

	}

	@ApiOperation(value = "Realiza o ativamento da conta na Base RoguiBank")
	@PatchMapping(produces = { "application/json", "application/xml" }, consumes = {
			"application/json", "application/xml" }, value = "/{nroconta}/ativar")
	public ResponseEntity<DadosContaVO> ativarConta(@PathVariable("nroconta") String nroConta) {

		services.ativarConta(nroConta);
		return ResponseEntity.noContent().build();

	}

	@ApiOperation(value = "Realiza o bloqueio da conta na Base RoguiBank")
	@PatchMapping(produces = { "application/json", "application/xml" }, consumes = {
			"application/json", "application/xml" }, value = "/{nroconta}/bloquear")
	public ResponseEntity<DadosContaVO> bloquearConta(@PathVariable("nroconta") String nroConta) {

		services.bloquearConta(nroConta);
		return ResponseEntity.noContent().build();

	}

	private URI getUri(Long id) {
		return ServletUriComponentsBuilder.fromCurrentRequest().path("/{nroconta}").buildAndExpand(id).toUri();
	}

}

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

import com.rogui.contadigial.domain.Endereco;
import com.rogui.contadigial.dto.EnderecoVO;
import com.rogui.contadigial.services.EnderecoServices;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "EnderecoEndPoint")
@RestController
@RequestMapping("/api/v1/endereco")

public class EnderecoController  {
	
	@Autowired
	private EnderecoServices endServ;
	
	@ApiOperation(value = "Consulta endereco pelo id")
	@GetMapping(value = "/id/{id}", produces = { "application/json", "application/xml" })
	public ResponseEntity<Optional<Endereco>> finById(@PathVariable ("id") Long id){
		Optional<Endereco> optionalend = endServ.findById(id);
		return ResponseEntity.ok(optionalend);
	}
	
	@ApiOperation(value = "Consulta endereco pelo CEP")
	@GetMapping(value = "/cep/{cep}", produces = { "application/json", "application/xml" })
	public ResponseEntity<Optional<Endereco>> finByCep(@PathVariable ("cep")String cep){
		Optional<Endereco> optionalend = endServ.findByCEP(cep);
		return ResponseEntity.ok(optionalend);
	}
	
	@ApiOperation(value = "Consulta endereco pela rua")
	@GetMapping(value = "/rua/{rua}", produces = { "application/json", "application/xml" })
	public ResponseEntity<Optional<Endereco>> finByRua(@PathVariable ("rua") String rua){
		Optional<Endereco> optionalend = endServ.findByRua(rua);
		return ResponseEntity.ok(optionalend);
	}
	
	@ApiOperation(value = "Cadastrando endereço na Base")
	@PostMapping(produces = { "application/json", "application/xml" }, consumes = {
			"application/json", "application/xml" })
	public ResponseEntity<EnderecoVO> create(@RequestBody EnderecoVO endVO) {
		EnderecoVO enderecoVO = endServ.salvaEnd(EnderecoVO.consumeEntity(endVO));

		URI location = getUri(Long.valueOf(enderecoVO.getId()));
		return ResponseEntity.created(location).build();
	}
	
	private URI getUri(Long id) {
		return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
	}
	
	@ApiOperation(value = "Alteração de dados de endereço cadastrado")
	@PutMapping(value = "/{id}")
	public String update(@PathVariable ("id") Long id, @RequestBody Endereco endereco) throws Exception {
		Endereco end = endServ.update(endereco, id);
		return "Cadastro atualizado com sucesso!" + end.getId();
	}
	
	@ApiOperation(value = "Deleta um registro de endereço pelo id")
	@DeleteMapping(value = "/{id}")
	public String delete(@PathVariable ("id")Long id) {
		endServ.delete(id);
		return "Endereço deletado com sucesso!";
	}

}


package com.rogui.contadigial.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rogui.contadigial.dto.CadastroPrincipalVO;
import com.rogui.contadigial.services.CadastroPrincipalServices;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/cadastroprincipal/v1")
public class CadastroPrincipalController {

	
	@Autowired
	private CadastroPrincipalServices cpservices;
	
	@ApiOperation(value = "Consulta cadastro pelo número da conta")
	@GetMapping(value = "/CadastroPrincipal/{nroConta}", produces = { "application/json", "application/xml" })
	public ResponseEntity<CadastroPrincipalVO> finByNroConta(@PathVariable ("nroConta") String nroConta){
		CadastroPrincipalVO cpVO = cpservices.findByNroConta(nroConta);
		return ResponseEntity.ok(cpVO);
	}
	
	@ApiOperation(value = "Consulta cadastro pelo nome constante no cadastro")
	@GetMapping(value = "/CadastroPrincipal/nome/{nome}", produces = { "application/json", "application/xml" })
	public ResponseEntity<CadastroPrincipalVO> findByName(@PathVariable("nome")String nome){
		CadastroPrincipalVO cpVO = cpservices.findByNome(nome);
		return ResponseEntity.ok(cpVO);
	}
	
}

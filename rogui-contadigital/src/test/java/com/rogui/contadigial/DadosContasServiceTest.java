package com.rogui.contadigial;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.rogui.contadigial.domain.DadosConta;
import com.rogui.contadigial.dto.DadosContaVO;
import com.rogui.contadigial.enums.EnumStatusConta;
import com.rogui.contadigial.exceptions.ResourceNotFoundException;
import com.rogui.contadigial.services.DadosContaServices;

//@RunWith(SpringRunner.class)
//@RunWith(JUnitPlatform.class)
@SpringBootTest
public class DadosContasServiceTest {

	@Autowired
	private DadosContaServices service;

	@Test
	public void TestSave() {
		DadosContaVO vo = service.save(this.carregarObj());
		assertNotNull(vo);
		assertEquals("12345", vo.getNroConta());
	}

	@Test
	public void TestSaveDuplicado() {
		DadosContaVO vo = service.save(this.carregarObj());
		assertNotNull(vo);
		assertEquals("12345", vo.getNroConta());
	}

	@Test
	public void TestConsultaCpfCnpj() {
		this.TestSave();
		DadosContaVO vo = service.findByCpfCnpj("123456");
		assertNotNull(vo);
		assertNotNull(vo.getCpfCnpj());
		assertNotNull(vo.getNroConta());
		this.TestDelete();
	}

	@Test
	public void TestConsultaNroConta() {
		this.TestSave();
		DadosContaVO vo = service.findByNroConta("12345");
		assertNotNull(vo);
		assertNotNull(vo.getCpfCnpj());
		assertNotNull(vo.getNroConta());
		this.TestDelete();
	}

	@Test()
	public void TestDelete() {
		String nroConta = "12345";
		service.delete(nroConta);
		DadosContaVO dados = null;
		try {
			dados = service.findByNroConta("12345");

		} catch (ResourceNotFoundException e) {
			assertNull(dados);
		}

	}

	@Test
	public void TestAtivar() {
		this.TestSave();
		DadosContaVO vo = service.findByNroConta("12345");
		assertEquals(EnumStatusConta.ATIVO, vo.getStatus());

		/* Alterar Status */
		vo.setStatus(EnumStatusConta.ATIVO);
		vo = service.update(DadosContaVO.consumeEntity(vo));
		assertEquals(vo.getStatus(), EnumStatusConta.ATIVO);
		this.TestDelete();

	}

	@Test
	public void TestEncerrado() {
		this.TestSave();
		DadosContaVO vo = service.findByNroConta("12345");
		assertEquals(EnumStatusConta.ATIVO, vo.getStatus());

		/* Alterar Status */
		vo.setStatus(EnumStatusConta.ENCERRADO);
		vo = service.update(DadosContaVO.consumeEntity(vo));
		assertEquals(vo.getStatus(), EnumStatusConta.ENCERRADO);
		this.TestDelete();

	}

	@Test
	public void TestBloqueado() {
		this.TestSave();
		DadosContaVO vo = service.findByNroConta("12345");
		assertEquals(EnumStatusConta.ATIVO, vo.getStatus());

		/* Alterar Status */
		vo.setStatus(EnumStatusConta.BLOQUEADO);
		vo = service.update(DadosContaVO.consumeEntity(vo));
		assertEquals(vo.getStatus(), EnumStatusConta.BLOQUEADO);
		this.TestDelete();

	}

	private DadosConta carregarObj() {
		return DadosConta.builder().agencia("99").cpfCnpj("123456").div(1).dtAbertura(new Date()).nroConta("12345")
				.status(EnumStatusConta.ATIVO).nroContaParceiro("99999").dtEncerramento(new Date()).build();

	}
}

package br.com.alura.rh.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import br.com.alura.rh.execption.ValidacaoException;
import br.com.alura.rh.model.Cargo;
import br.com.alura.rh.model.Funcionario;
import br.com.alura.rh.service.aumento.ReajusteService;
import br.com.alura.rh.service.promocao.PromocaoService;

@TestInstance(Lifecycle.PER_CLASS)
public class TestReajusteSalarial {

	private Funcionario fun1;
	private PromocaoService promocaoService;

	@BeforeAll
	void init() {
		fun1 = new Funcionario("Idinaldo", "111.222", Cargo.ASSISTENTE, new BigDecimal(2000));
		promocaoService = new PromocaoService(); 
		System.out.println("Rodando");
	}
	
	@Test
	void verificarPromocaoAnalista() {
		boolean metaAtingida = true;
		promocaoService.promover(fun1, metaAtingida );
		assertEquals(Cargo.ANALISTA, fun1.getCargo());
	}
	
	@Test
	void verificarExceptionMetaNaoAtingida() {
		boolean metaAtingida = false;
		assertThrows(ValidacaoException.class, () -> promocaoService.promover(fun1, metaAtingida ));
	}
}

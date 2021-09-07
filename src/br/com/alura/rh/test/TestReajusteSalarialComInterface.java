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
import br.com.alura.rh.service.aumento.ValidaReajuste;
import br.com.alura.rh.service.aumento.ValidacaoPercentualSalario;
import br.com.alura.rh.service.aumento.ValidacaoPeriodoAumentoSalarial;

@TestInstance(Lifecycle.PER_CLASS)
public class TestReajusteSalarialComInterface {

	private Funcionario fun1;
	private ReajusteService reajusteService;

	@BeforeAll
	void init() {
		fun1 = new Funcionario("Idinaldo", "111.222", Cargo.ESPECIALISTA, new BigDecimal(2000));
		reajusteService = new ReajusteService();
		System.out.println("Rodando");
	}
	
	@Test
	void verificarAumentoDoSalario() {
		reajusteService.addService(new ValidacaoPercentualSalario());
		reajusteService.reajusteSalario(fun1, new BigDecimal("800"));
		assertEquals(new BigDecimal(2800), fun1.getSalario());
	}
	
	@Test()
	void retornarExecptionAumento40Porcento() {
		reajusteService.addService(new ValidacaoPercentualSalario());
		assertThrows(ValidacaoException.class, () -> reajusteService.reajusteSalario(fun1, new BigDecimal("1800")));
	}
	
	@Test
	void retornarExecptionPeriodoMenoQueSeis() {
		fun1.setDataUltimoReajuste(LocalDate.of(2021, 5, 1));
		reajusteService.addService(new ValidacaoPeriodoAumentoSalarial());
		assertThrows(ValidacaoException.class, () -> reajusteService.reajusteSalario(fun1, new BigDecimal("1200")));
	}
}

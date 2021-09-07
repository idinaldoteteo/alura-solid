package br.com.alura.rh.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import br.com.alura.rh.service.tributacao.Anuenio;
import br.com.alura.rh.service.tributacao.Promocao;
import br.com.alura.rh.service.tributacao.Reajuste;


public class TestReajusteTributario {

	
	@Test
	void verificarAnuenioSemImposto() {
		Reajuste reajuste = new Anuenio();
		assertEquals(new BigDecimal("100"), reajuste.valor());
	}
	
	@Test
	void verificarImpostoRendaPromocao() {
		Reajuste reajuste = new Promocao();
		assertEquals(new BigDecimal("500.0"), reajuste.valor());
	}
	
	
}

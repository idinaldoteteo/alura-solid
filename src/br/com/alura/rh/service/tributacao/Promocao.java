package br.com.alura.rh.service.tributacao;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Promocao implements ReajusteTributavel{

	@Override
	public BigDecimal valor() {
		return valorImpostoDeRenda();
	}

	@Override
	public LocalDate data() {
		return LocalDate.now();
	}

	@Override
	public BigDecimal valorImpostoDeRenda() {
		return new BigDecimal("1000").multiply(new BigDecimal("0.5"));
	}

}

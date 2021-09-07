package br.com.alura.rh.service.tributacao;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Anuenio implements Reajuste {

	@Override
	public BigDecimal valor() {
		return new BigDecimal("100");
	}

	@Override
	public LocalDate data() {
		return LocalDate.now();
	}

}

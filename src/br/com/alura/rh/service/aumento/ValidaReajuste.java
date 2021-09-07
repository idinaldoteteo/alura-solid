package br.com.alura.rh.service.aumento;

import java.math.BigDecimal;

import br.com.alura.rh.model.Funcionario;

public interface ValidaReajuste {

	void valida(Funcionario funcionario, BigDecimal aumento);
}

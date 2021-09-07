package br.com.alura.rh.service.aumento;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import br.com.alura.rh.execption.ValidacaoException;
import br.com.alura.rh.model.Funcionario;

public class ValidacaoPeriodoAumentoSalarial implements ValidaReajuste {

	public void valida(Funcionario funcionario, BigDecimal aumento) {
		LocalDate dataUltimoAjustel = funcionario.getDataUltimoReajuste();
		LocalDate dataAtual = LocalDate.now();
		long periodoEntreUltimoAjuste = ChronoUnit.MONTHS.between(dataUltimoAjustel, dataAtual);
		
		if( periodoEntreUltimoAjuste  < 6) {
			throw new ValidacaoException("O último ajuste de salário foi feito antes de 6 meses!");
		}
	}
}

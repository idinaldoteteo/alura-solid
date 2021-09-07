package br.com.alura.rh.service.aumento;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import br.com.alura.rh.model.Funcionario;

public class ReajusteService {

	private List<ValidaReajuste> validaReajuste;
	
	public void reajusteSalario(Funcionario funcionario, BigDecimal aumento) {
		validaReajuste.forEach( v -> v.valida(funcionario, aumento) );
		
		BigDecimal novoSalario = funcionario.getSalario().add(aumento);
		funcionario.atualizarSalario(novoSalario);
	}
	
	public void addService(ValidaReajuste serviceReajuste) {
		if( Objects.isNull(validaReajuste))
			this.validaReajuste = new ArrayList<>();
		
		this.validaReajuste.add(serviceReajuste);
	}
}

package br.com.alura.rh.service.promocao;

import br.com.alura.rh.execption.ValidacaoException;
import br.com.alura.rh.model.Cargo;
import br.com.alura.rh.model.Funcionario;

public class PromocaoService {

	public void promover(Funcionario funcionario, boolean metaAtingida) {
		Cargo cargoATual = funcionario.getCargo();
		if( Cargo.GERENTE.equals(cargoATual)) {
			throw new ValidacaoException("O Gerente não pode ser promovido. Está no último nível!");
		}
		
		if( !metaAtingida) {
			throw new ValidacaoException("A meta não foi atingida!");
		}
		
		Cargo cargoAtual = cargoATual.getProximo();
		funcionario.promover(cargoAtual);
		
	}
}

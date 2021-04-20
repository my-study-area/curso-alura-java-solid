package br.com.alura.rh.service;

import java.math.BigDecimal;
import java.util.List;

import br.com.alura.rh.model.Funcionario;

public class ReajusteService {
	
	List<ValidacaoReajuste> validacoes;
	
	public ReajusteService(List<ValidacaoReajuste> validacoes) {
		this.validacoes = validacoes;
	}

	public void reajustarSalarioDoFuncionario(Funcionario funcionario, BigDecimal aumento) {
		BigDecimal salarioAtual = funcionario.getSalario();
		validacoes.forEach( v -> v.validar(funcionario, aumento));

		BigDecimal salarioReajustado = salarioAtual.add(aumento);
		funcionario.atualizarSalario(salarioReajustado);
	}
}

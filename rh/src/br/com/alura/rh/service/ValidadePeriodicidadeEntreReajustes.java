package br.com.alura.rh.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import br.com.alura.rh.ValidacaoException;
import br.com.alura.rh.model.Funcionario;

public class ValidadePeriodicidadeEntreReajustes implements ValidacaoReajuste {
	public void validar(Funcionario funcionario, BigDecimal aumento) {
		LocalDate dataUltimoReajuste = funcionario.getDataUltimoReajuste();
		LocalDate dataReajusteAtual = LocalDate.now();
		long periodicidadeDesdeReajuste = ChronoUnit.MONTHS.between(dataUltimoReajuste, dataReajusteAtual);
		if (periodicidadeDesdeReajuste  < 6) {
			throw new ValidacaoException("Intervalo entre reajuste deve ser de no mínimo 6 meses");
		}
	}
}

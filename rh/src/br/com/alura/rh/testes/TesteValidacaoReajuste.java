package br.com.alura.rh.testes;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.alura.rh.model.Cargo;
import br.com.alura.rh.model.Funcionario;
import br.com.alura.rh.service.ReajusteService;
import br.com.alura.rh.service.ValidaPercentualDeReajuste;
import br.com.alura.rh.service.ValidacaoReajuste;
import br.com.alura.rh.service.ValidadePeriodicidadeEntreReajustes;

public class TesteValidacaoReajuste {

	public static void main(String[] args) {
		Funcionario funcionario1 = new Funcionario("Adriano", "123.123.123-12", Cargo.ANALISTA, new BigDecimal(4000));
		funcionario1.setDataUltimoReajuste(LocalDate.of(2020, 10, 19));
		
		List<ValidacaoReajuste> validacoes = new ArrayList<>();
		validacoes.add(new ValidaPercentualDeReajuste());
		validacoes.add(new ValidadePeriodicidadeEntreReajustes());
		
		ReajusteService service = new ReajusteService(validacoes);
		service.reajustarSalarioDoFuncionario(funcionario1, new BigDecimal(1900));
		System.out.println("Nome: " + funcionario1.getNome() + ", Salário: " + funcionario1.getSalario());
	}

}

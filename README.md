# curso-alura-java-solid
Curso de SOLID com Java: Princípios da programação orientada a objetos

## Módulo 01 - Orientação a Objetos Ver primeiro vídeo
### Aula 01.01 - Apresentação
- `S`ingle Responsability Principal
- `O`pen closed Principal
- `L`iskov Substitution Principal
- `I`nterface Sergregation Principal
- `D`ependency Inveersion Principal

### Aula 01.02 - Projeto inicial do treinamento
- [Projeto Inicial](./rh)

### Aula 01.03 - Coesão
- Coesão: harmonia entre a classe e os seus atributos e métodos. Eles devem manter uma relação em comum, como por exemplo, uma classe Funcionario com os atributos nome, cpf, salario e etc e os métodos get dos atributos.
- Classes não coesas tedem a crescer indefinitivamente, o que as tornam difíceis de manter.

### Aula 01.04 - Classes coesas
Qual a melhor definição de uma classe coesa?
- Uma classe que executa bem a sua única tarefa, de forma concisa.
- Uma classe coesa não pode executar várias tarefas.
- Uma classe coesa não pode executar várias tarefas.

### Aula 01.05 - Encapsulamento
- Incluir ou proteger alguma coisa em cápsula.
- encapsulamento é uma forma de manter os objetos das nossas classes protegidos, fornecendo apenas o que é estritamente necessário para o mundo exterior.
- Proteje uma classe de manipulações externas.
- Classes não encapsuladas permitem violação de regras de negócio, além de aumentarem o acoplamento.

### Aula 01.06 - Protegendo o código
- Getters e setters por si só não fornecem nenhum tipo de encapsulamento. O fato de criar getters e setters para tudo, na verdade, quebra o encapsulamento da nossa classe.
- Encapsulamento ajuda no uso correto dos objetos. Ao encapsular o acesso a determinados dados, liberando acesso apenas ao necessário, os objetos da nossa classe se tornam mais fáceis de serem utilizados.

### Aula 01.07 - Acoplamento
- Ação de acoplar. Agrupamento aos pares.
- Classes acopladas causam fragilidade no código da aplicação, o que dificulta sua aplicação.

### Aula 01.08 - Dependências no código
O que é correto afirmar sobre acoplamento?
- É impossível criar um bom sistema sem nenhum tipo de acoplamento. É fato que, se estamos organizando o nosso código, seguindo as recomendações da orientação a objetos, algum acoplamento acontecerá. Algumas classes precisarão de outras, para que não tenham muitas responsabilidades. Cabe a nós medir quando faz sentido adicionar tal acoplamento com as dependências e como depender do que é seguro, ao invés de classes concretas.

### Aula 01.09 - Faça como eu fiz

### Aula 01.10 - O que aprendemos?
Nesta aula, aprendemos:
- Coesão:
  - Uma classe coesa faz bem uma única coisa
  - Classes coesas não devem ter várias responsabilidades
- Encapsulamento:
  - Getters e setters não são formas eficientes de aplicar encapsulamento
  - É interessante fornecer acesso apenas ao que é necessário em nossas -   classes
  - O encapsulamento torna o uso das nossas classes mais fácil e intuitivo
- Acoplamento:
  - Acoplamento é a dependência entre classes
  - Acoplamento nem sempre é ruim, e que é impossível criar um sistema sem  - nenhum acoplamento
  - Devemos controlar o nível de acoplamento na nossa aplicação 

## Módulo 02 - Melhorando a coesão
### Aula 02.01 - Extraindo a lógica de reajuste salarial
- Classe `Funcionario` inicial:
```java
public class Funcionario {

	private String nome;
	private String cpf;
	private Cargo cargo;
	private BigDecimal salario;
	private LocalDate dataUltimoReajuste;

	public Funcionario(String nome, String cpf, Cargo cargo, BigDecimal salario) {
		this.nome = nome;
		this.cpf = cpf;
		this.cargo = cargo;
		this.salario = salario;
	}

	public void reajustarSalario(BigDecimal aumento) {
		BigDecimal percentualReajuste = aumento.divide(salario, RoundingMode.HALF_UP);
		if (percentualReajuste.compareTo(new BigDecimal("0.4")) > 0) {
			throw new ValidacaoException("Reajuste nao pode ser superior a 40% do salario!");
		}
		this.salario = this.salario.add(aumento);
		this.dataUltimoReajuste = LocalDate.now();
	}

  //getters and setters

}
```
- Service responsável pela lógica do reajuste do salário:
```java
public class ReajusteService {
	public void reajustarSalarioDoFuncionario(Funcionario funcionario, BigDecimal aumento) {
		BigDecimal salarioAtual = funcionario.getSalario();
		BigDecimal percentualReajuste = aumento.divide(salarioAtual, RoundingMode.HALF_UP);
		if (percentualReajuste.compareTo(new BigDecimal("0.4")) > 0) {
			throw new ValidacaoException("Reajuste nao pode ser superior a 40% do salario!");
		}
		
		BigDecimal salarioReajustado = salarioAtual.add(aumento);
		funcionario.atualizarSalario(salarioReajustado);
	}
}
```
- Classe `Funcionario` atualizada:
```java
public class Funcionario {

	private String nome;
	private String cpf;
	private Cargo cargo;
	private BigDecimal salario;
	private LocalDate dataUltimoReajuste;

	public Funcionario(String nome, String cpf, Cargo cargo, BigDecimal salario) {
		this.nome = nome;
		this.cpf = cpf;
		this.cargo = cargo;
		this.salario = salario;
	}

	public void atualizarSalario(BigDecimal novoSalario) {
		this.salario = novoSalario;
		this.dataUltimoReajuste = LocalDate.now();
	}

  //getters and setters

}
```

### Aula 02.02 - Extraindo classe
- Refatoração é uma alteração no código que visa melhorar sua clareza e entendimento.

### Aula 02.03 - Single Responsibility Principle
- Só porque você pode, não quer dizer que você deveria.
- Uma classe deveria ter um único motivo para mudar.

### Aula 02.04 - Definição de SRP
Qual é a definição mais formal do princípio de responsabilidade única?    
`R:` Uma classe (ou módulo, função, etc) deve ter um e apenas um motivo para mudar

### Aula 02.05 - Faça como eu fiz

### Aula 02.06 - O que aprendemos?
- Que `classes/métodos/funções/módulos` devem ter uma única responsabilidade bem definida;
- Que, segundo o `Princípio de Responsabilidade Única (SRP)`, uma classe deve ter um e apenas um motivo para ser alterada;
- Como realizar uma refatoração no nosso sistema, para aplicar o SRP;
- Como extrair uma classe.

## Módulo 03 - Reduzindo o acoplamento
### Aula 03.01 - Projeto da aula anterior

### Aula 03.02 - Extraindo validações

### Aula 03.03 - Muitas validações
A classe ReajusteSalarial poderia crescer para sempre. Enquanto novas validações de reajuste fossem criadas, novas condições deveriam ser adicionadas a esta classe, fazendo-a crescer interminavelmente.

### Aula 03.04 - Open Closed Principle
- Entidades de software (classes, funções, módulos, etc.) devem estar abertas para extensão, porém fechadas para modificação.

### Aula 03.05 - Garantindo que o sistema seja extensível
- Para garantir que nosso sistema seja extensível da forma correta devemos garantir que cada ação/responsabilidade esteja na classe correta.

### Aula 03.06 - Faça como eu fiz

### Aula 03.07 - O que aprendemos?
- Que cada classe deve conhecer e ser responsável por suas próprias regras de negócio;
- Que o princípio Aberto/Fechado (OCP) diz que um sistema deve ser aberto para a extensão, mas fechado para a modificação
  - Isso significa que devemos poder criar novas funcionalidades e estender o sistema sem precisar modificar muitas classes já existentes
- Uma classe que tende a crescer "para sempre" é uma forte candidata a sofrer alguma espécie de refatoração.

## Módulo 04 - Herança indesejada
### Aula 04.01 - Projeto da aula anterior
### Aula 04.02 - Implementando uma nova regra de negócio
### Aula 04.03 - Utilizando herança da maneira errada
- Utilizar composição no lugar de herança.

### Aula 04.04 - Herança
Por que nossa classe Terceirizado estava estendendo de forma indesejada um comportamento?    
`R:` Porque estava herdando métodos que não faziam sentido para ela. Alguns métodos herdados não deveriam existir nessa classe.

### Aula 04.05 - Liskov Substitution Principle
- Se nada como um pato, voa como um pato, mas precisa de bateria, existe um problema de violação
- Se para cada objeto o1 do tipo S existe um objeto o2 do tipo T,tal que, para todos os programas P definidos em termos de T,o comportamento de P fica inalterado quando o1 é substituído por o2, então S é um subtipo de T. Resumindo: Uma classe base deve poder ser substituída pela sua classe derivada.

### Aula 04.06 - Alternativa à herança
Qual seria uma alternativa quando a herança não fizer sentido?    
`R:` Utilizar composição. Essa é uma das maneiras de evitar a herança sem duplicação de código.

### Aula 04.07 - Faça como eu fiz

### Aula 04.08 - O que aprendemos?
- Que, embora a herança favoreça o reaproveitamento de código, ela pode trazer efeitos colaterais quando não utilizada da maneira correta;
- Que o Princípio de Substituição de Liskov (LSP) diz que devemos poder substituir classes base por suas classes derivadas em qualquer lugar, sem problema.


## Módulo 05 - Trabalhando com abstrações
### Aula 05.01 - Projeto da aula anterior
### Aula 05.02 - Criando abstrações com interfaces e polimorfismo
### Aula 05.03 - Dependency Inversion Principle
- Abstrações não devem depender de implementações. Implementações devem depender de abstrações. Dependa de abstrações e não de implementações.

### Aula 05.04 - Vantagem ao criar dependências com interfaces
Que vantagem temos ao depender de interfaces e não de implementações?    
`R:` Caso uma determinada implementação mude, não seremos afetados, pois dependemos apenas de sua interface.

### Aula 05.05 - Interface Segregation Principle
- Uma classe não deveria se forçada a depender de métodos que não utilizará.

### Aula 05.06 - Definição do ISP
Qual a definição formal do `Interface Segregation Principle`?  
`R:` Classes não devem ser obrigadas a implementar métodos que não irão precisar.

### Aula 05.07 - Faça como eu fiz

### Aula 05.08 - Projeto final do curso

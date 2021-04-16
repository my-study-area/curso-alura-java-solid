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

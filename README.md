# Sistema de Gestão de Biblioteca Acadêmica 📚

Sistema desenvolvido em **Java** para a disciplina de **Programação Orientada a Objetos (POO)**. O software automatiza o gerenciamento do acervo de livros, cadastro de usuários (divididos entre Alunos e Professores) e o controle dinâmico de empréstimos e devoluções, operando inteiramente via console (terminal).

---

## 🛠️ Funcionalidades do Sistema

* **Cadastro Unificado de Usuários:** Permite registrar Alunos e Professores por meio de regras de herança.
* **Cadastro do Acervo:** Inclusão dinâmica de novos livros com controle automático de disponibilidade.
* **Listagem de Livros:** Varredura completa do acervo com exibição em tempo real do status de cada título (*Disponível* ou *Emprestado*).
* **Controle de Empréstimos:** Vincula de forma lógica um usuário a um livro físico, alterando os metadados do acervo e gerando o número identificador do empréstimo.
* **Gerenciamento de Devoluções:** Libera o livro selecionado imediatamente para novas locações e atualiza o estado interno da transação.
* **Validações Operacionais:** Tratamento de erros de digitação de opções e impedimento de empréstimo caso não existam cadastros prévios ou o livro já esteja indisponível.

---

## 🧬 Aplicação Prática dos Conceitos de POO

O escopo do projeto foi modelado para consolidar os seguintes pilares da engenharia de software orientada a objetos:

1.  **Encapsulamento:** Todos os atributos das entidades (`Usuario`, `Livro`, `Emprestimo`) utilizam o modificador de acesso `private`. O ciclo de leitura e escrita é estritamente controlado via métodos acessores e modificadores (*Getters e Setters*), garantindo a integridade dos dados.
2.  **Herança:** As classes `Aluno` e `Professor` estendem (`extends`) a classe base `Usuario`. Isso elimina a redundância de código, permitindo que as classes filhas herdem atributos comuns (Nome, Matrícula, CPF, E-mail) e comportamentos da classe mãe.
3.  **Coleções (Collections):** Uso de estruturas dinâmicas do tipo `ArrayList` para gerenciar listas expansíveis em memória RAM (`acervo`, `usuarios` e `emprestimos`), simulando um banco de dados relacional volátil sem tamanho fixo.
4.  **Enumerações (Enum):** A classe `StatusEmprestimo` restringe as opções de estado da transação aos valores fortemente tipados `ATIVO`, `DEVOLVIDO` e `ATRASADO`, impedindo estados inválidos no fluxo de negócio.

---

## 📂 Estrutura de Diretórios e Pacotes

Todas as classes pertencem e estão organizadas sob o escopo do pacote `javaoo`, facilitando a modularidade:

```text
src/
└── javaoo/
    ├── Main.java             # Ponto de entrada (Menu interativo estruturado em Switch-Case)
    ├── Usuario.java          # Superclasse / Classe Mãe (Entidade Base)
    ├── Aluno.java            # Subclasse / Classe Filha (Especialização de Usuário)
    ├── Professor.java        # Subclasse / Classe Filha (Especialização de Usuário)
    ├── Livro.java            # Entidade de controle de dados e disponibilidade do acervo
    ├── Emprestimo.java       # Classe associativa (Une Usuário, Livro e Data da operação)
    └── StatusEmprestimo.java # Estrutura Enum contendo as regras de estados do empréstimo



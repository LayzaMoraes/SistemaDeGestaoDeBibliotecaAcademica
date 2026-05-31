package javaoo;

public class Aluno extends Usuario {


    public Aluno(String nome, int matricula, String cpf, String email) {
        super(nome, matricula, cpf, email);
    }

    @Override
    public void solicitarEmprestimo() {
    System.out.println("Aluno " + getNome() + " solicitou um empréstimo.");
}

    public void consultarHistorico() {
    System.out.println("Histórico do aluno " + getNome());
}
}
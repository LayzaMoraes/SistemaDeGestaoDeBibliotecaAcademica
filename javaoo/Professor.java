package javaoo;

public class Professor extends Usuario {

    public Professor(String nome, int matricula, String cpf, String email) {
        super(nome, matricula, cpf, email);
    }
    @Override
    public void solicitarEmprestimo() {
    System.out.println("Professor " + getNome() + " solicitou um empréstimo.");
}
    public void consultarHistorico() {
    System.out.println("Histórico do professor " + getNome());
}
}
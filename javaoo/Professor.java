package javaoo;

public class Professor extends Usuario {

    // O construtor do Professor repassa os dados para o construtor do Pai (Usuario)
    public Professor(String nome, int matricula, String cpf, String email) {
        super(nome, matricula, cpf, email);
    }

    public void solicitaremprestimo(){

    }
}

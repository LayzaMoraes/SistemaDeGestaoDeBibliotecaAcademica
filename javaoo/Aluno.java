package javaoo;
public class Aluno extends Usuario {

    // O construtor do Aluno repassa os dados para o construtor do Pai (Usuario)
    public Aluno(String nome, int matricula, String cpf, String email) {
        super(nome, matricula, cpf, email);
    }

    public void solicitaremprestimo(){

    }
}
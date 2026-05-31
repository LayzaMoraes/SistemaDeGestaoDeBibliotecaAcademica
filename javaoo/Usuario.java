package javaoo;

public class Usuario {
    private String nome;
    private int matricula;
    private String cpf;
    private String email;

    // Construtor
    public Usuario(String nome, int matricula, String cpf, String email) {
        this.nome = nome;
        this.matricula = matricula;
        this.cpf = cpf;
        this.email = email;
    }

    // Método que será herdado pelas classes filhas
    public void solicitarEmprestimo() {
        System.out.println(nome + " solicitou um empréstimo.");
    }

    public void consultarHistorico() {
        System.out.println("Exibindo histórico de " + nome);
    }

    // Getters e Setters (Encapsulamento)
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public int getMatricula() { return matricula; }
    public void setMatricula(int matricula) { this.matricula = matricula; }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}

package javaoo;

import java.util.ArrayList;
import java.util.Date;

public class Emprestimo {
    private int numeroEmprestimo;
    private Usuario usuario;
    private ArrayList<Livro> livros;
    private Date dataEmprestimo;
    private StatusEmprestimo status;
    // Construtor
    public Emprestimo(int numeroEmprestimo, Usuario usuario) {
        this.numeroEmprestimo = numeroEmprestimo;
        this.usuario = usuario;
        this.livros = new ArrayList<>();
        this.dataEmprestimo = new Date();
        this.status = StatusEmprestimo.ATIVO;
    }

    // Métodos específicos
    public void adicionarLivro(Livro livro) {
        this.livros.add(livro);
    }

    public void listarLivros() {
        for (Livro l : livros) {
            System.out.println("- " + l.getTitulo());
        }
    }

    public void finalizarEmprestimo() {
        this.status = StatusEmprestimo.DEVOLVIDO;
    }

    // Getters e Setters
    public int getNumeroEmprestimo() { return numeroEmprestimo; }
    public void setNumeroEmprestimo(int numeroEmprestimo) { this.numeroEmprestimo = numeroEmprestimo; }

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    public ArrayList<Livro> getLivros() { return livros; }
    public void setLivros(ArrayList<Livro> livros) { this.livros = livros; }

    public Date getDataEmprestimo() { return dataEmprestimo; }
    public void setDataEmprestimo(Date dataEmprestimo) { this.dataEmprestimo = dataEmprestimo; }

    public StatusEmprestimo getStatus() { return status; }
    public void setStatus(StatusEmprestimo status) { this.status = status; }
}
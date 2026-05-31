package javaoo;

import java.util.ArrayList;
import java.util.Date;

public class Emprestimo {
    private int numeroEmprestimo;
    private Usuario usuario;
    private ArrayList<Livro> livros;
    private Date dataEmprestimo;
    private StatusEmprestimo status;

    
    public Emprestimo(int numeroEmprestimo, Usuario usuario) {
        this.numeroEmprestimo = numeroEmprestimo;
        this.usuario = usuario;
        this.livros = new ArrayList<>();
        this.dataEmprestimo = new Date();
        this.status = StatusEmprestimo.ATIVO;
    }

    
    public void adicionarLivro(Livro libro) {
        this.livros.add(libro);
    }

    public void finalizarEmprestimo() {
        this.status = StatusEmprestimo.DEVOLVIDO;
    }

    
    public int getNumeroEmprestimo() { return numeroEmprestimo; }
    public Usuario getUsuario() { return usuario; }
    public ArrayList<Livro> getLivros() { return livros; }
    public StatusEmprestimo getStatus() { return status; }
}

package javaoo;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        ArrayList<Usuario> listaUsuario = new ArrayList<>();
        ArrayList<Livro> listaLivro = new ArrayList<>();
        ArrayList<Emprestimo> listaEmprestimo = new ArrayList<>();
        
        int contEmprestimo = 1;
        int opcao = -1;
        
        while (opcao != 0) {
            System.out.println("\n=== BIBLIOTECA ===");
            System.out.println("1 - Cadastrar Usuario");
            System.out.println("2 - Cadastrar Livro");
            System.out.println("3 - Listar Livros");
            System.out.println("4 - Fazer Emprestimo");
            System.out.println("5 - Devolver Livro");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            
            opcao = input.nextInt();
            input.nextLine();
            
            switch (opcao) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = input.nextLine();
                    System.out.print("Matricula: ");
                    int mat = input.nextInt();
                    input.nextLine();
                    System.out.print("CPF: ");
                    String cpf = input.nextLine();
                    System.out.print("Email: ");
                    String email = input.nextLine();
                    
                    Usuario novoUsuario = new Usuario(nome, mat, cpf, email);
                    listaUsuario.add(novoUsuario);
                    System.out.println("Usuario cadastrado!");
                    break;
                    
                case 2:
                    System.out.print("Titulo: ");
                    String titulo = input.nextLine();
                    System.out.print("Autor: ");
                    String autor = input.nextLine();
                    System.out.print("ISBN: ");
                    String isbn = input.nextLine();
                    System.out.print("Ano: ");
                    int ano = input.nextInt();
                    input.nextLine();
                    System.out.print("Editora: ");
                    String editora = input.nextLine();
                    
                    Livro novoLivro = new Livro(titulo, autor, isbn, ano, editora);
                    listaLivro.add(novoLivro);
                    System.out.println("Livro cadastrado!");
                    break;
                    
                case 3:
                    if (listaLivro.isEmpty()) {
                        System.out.println("Nenhum livro cadastrado.");
                    } else {
                        for (Livro l : listaLivro) {
                            String status = "Disponivel";
                            if (l.consultarDisponibilidade() == false) {
                                status = "Emprestado";
                            }
                            System.out.println(l.getTitulo() + " - " + status);
                        }
                    }
                    break;
                    
                case 4:
                    System.out.print("Matricula: ");
                    int matBusca = input.nextInt();
                    input.nextLine();
                    
                    Usuario usuarioBusca = null;
                    for (Usuario u : listaUsuario) {
                        if (u.getMatricula() == matBusca) {
                            usuarioBusca = u;
                        }
                    }
                    
                    if (usuarioBusca == null) {
                        System.out.println("Usuario nao encontrado!");
                        break;
                    }
                    
                    System.out.print("Titulo do livro: ");
                    String tituloBusca = input.nextLine();
                    
                    Livro livroBusca = null;
                    for (Livro l : listaLivro) {
                        if (l.getTitulo().equalsIgnoreCase(tituloBusca)) {
                            livroBusca = l;
                        }
                    }
                    
                    if (livroBusca == null) {
                        System.out.println("Livro nao encontrado!");
                        break;
                    }
                    
                    if (livroBusca.consultarDisponibilidade() == false) {
                        System.out.println("Livro ja esta emprestado!");
                        break;
                    }
                    
                    livroBusca.emprestar();
                    Emprestimo emp = new Emprestimo(contEmprestimo, usuarioBusca);
                    emp.adicionarLivro(livroBusca);
                    listaEmprestimo.add(emp);
                    contEmprestimo = contEmprestimo + 1;
                    System.out.println("Emprestimo realizado!");
                    break;
                    
                case 5:
                    System.out.print("Titulo do livro: ");
                    String tituloDev = input.nextLine();
                    
                    Livro livroDev = null;
                    for (Livro l : listaLivro) {
                        if (l.getTitulo().equalsIgnoreCase(tituloDev)) {
                            livroDev = l;
                        }
                    }
                    
                    if (livroDev == null) {
                        System.out.println("Livro nao encontrado!");
                        break;
                    }
                    
                    if (livroDev.consultarDisponibilidade() == true) {
                        System.out.println("Livro nao estava emprestado!");
                        break;
                    }
                    
                    livroDev.devolver();
                    
                    for (Emprestimo e : listaEmprestimo) {
                        if (e.getStatus() == StatusEmprestimo.ATIVO) {
                            if (e.getLivros().contains(livroDev)) {
                                e.finalizarEmprestimo();
                            }
                        }
                    }
                    
                    System.out.println("Livro devolvido!");
                    break;
                    
                case 0:
                    System.out.println("Programa encerrado.");
                    break;
                    
                default:
                    System.out.println("Opcao invalida!");
            }
        }
        
        input.close();
    }
}


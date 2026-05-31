package javaoo;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Livro> acervo = new ArrayList<>();
    private static ArrayList<Usuario> usuarios = new ArrayList<>();
    private static ArrayList<Emprestimo> emprestimos = new ArrayList<>();
    private static int idEmprestimo = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n==========================================================================");
            System.out.println("1-Cadastrar Usuário | 2-Cadastrar Livro | 3-Listar Livros | 4-Empréstimo | 5-Devolução | 0-Sair");
            System.out.print("Opção: ");
            
            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Por favor, digite um número válido.");
                continue;
            }

            switch (opcao) {
                case 1:
                    System.out.print("Nome: "); String nome = scanner.nextLine();
                    System.out.print("Matrícula: "); int mat = Integer.parseInt(scanner.nextLine());
                    System.out.println("Tipo: [1] Aluno | [2] Professor");
                    int tipo = Integer.parseInt(scanner.nextLine());
                    
                    if (tipo == 1) {
                        usuarios.add(new Aluno(nome, mat, "000", "aluno@email.com"));
                    } else {
                        usuarios.add(new Professor(nome, mat, "000", "prof@email.com"));
                    }
                    System.out.println("Usuário cadastrado com sucesso!");
                    break;

                case 2:
                    System.out.print("Título do Livro: "); String tit = scanner.nextLine();
                    System.out.print("Autor: "); String aut = scanner.nextLine();
                    acervo.add(new Livro(tit, aut, "000", 2026, "Editora"));
                    System.out.println("Livro adicionado ao acervo!");
                    break;

                case 3:
                    System.out.println("\n--- ACERVO DA BIBLIOTECA ---");
                    if (acervo.isEmpty()) {
                        System.out.println("Nenhum livro cadastrado no sistema.");
                    } else {
                        for (Livro l : acervo) {
                            String status = l.consultarDisponibilidade() ? "Disponível" : "Emprestado";
                            System.out.println("- " + l.getTitulo() + " | Autor: " + l.getAutor() + " (" + status + ")");
                        }
                    }
                    break;

                case 4:
                    if (usuarios.isEmpty() || acervo.isEmpty()) {
                        System.out.println("É necessário ter pelo menos um usuário e um livro cadastrados!");
                        break;
                    }

                    System.out.print("Matrícula do Usuário: "); int matUser = Integer.parseInt(scanner.nextLine());
                    Usuario userEncontrado = null;
                    for (Usuario u : usuarios) {
                        if (u.getMatricula() == matUser) { userEncontrado = u; break; }
                    }

                    if (userEncontrado == null) {
                        System.out.println("Usuário não encontrado!");
                        break;
                    }

                    System.out.print("Título do livro desejado: "); String titLivro = scanner.nextLine();
                    Livro livroEncontrado = null;
                    for (Livro l : acervo) {
                        if (l.getTitulo().equalsIgnoreCase(titLivro)) { livroEncontrado = l; break; }
                    }

                    if (livroEncontrado != null && livroEncontrado.consultarDisponibilidade()) {
                        livroEncontrado.emprestar();
                        userEncontrado.solicitarEmprestimo();
                        
                        Emprestimo emp = new Emprestimo(idEmprestimo++, userEncontrado);
                        emp.adicionarLivro(livroEncontrado);
                        emprestimos.add(emp);
                        
                        System.out.println("Empréstimo registrado sob o nº: " + emp.getNumeroEmprestimo());
                    } else {
                        System.out.println("Livro não disponível ou não encontrado!");
                    }
                    break;

                case 5:
                    if (emprestimos.isEmpty()) {
                        System.out.println("Não há empréstimos registrados no sistema.");
                        break;
                    }

                    System.out.print("Título do livro a devolver: "); String titDevolucao = scanner.nextLine();
                    boolean devolvido = false;
                    for (Livro l : acervo) {
                        if (l.getTitulo().equalsIgnoreCase(titDevolucao) && !l.consultarDisponibilidade()) {
                            l.devolver();
                            devolvido = true;
                            
                            for (Emprestimo e : emprestimos) {
                                if (e.getLivros().contains(l) && e.getStatus() == StatusEmprestimo.ATIVO) {
                                    e.finalizarEmprestimo();
                                    break;
                                }
                            }
                            System.out.println("Livro '" + l.getTitulo() + "' devolvido com sucesso!");
                            break;
                        }
                    }
                    if (!devolvido) System.out.println("Livro não encontrado ou não constava como emprestado.");
                    break;

                case 0:
                    System.out.println("Sistema encerrado.");
                    break;

                default:
                    System.out.println("Opção inválida! Escolha um número de 0 a 5.");
                    break;
            }
        }
        scanner.close();
    }
}
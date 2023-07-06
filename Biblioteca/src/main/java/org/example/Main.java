package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Livro> listaLivros = new ArrayList<>();
        List<Usuario> listaUsuarios = new ArrayList<>();
        Biblioteca biblioteca = new Biblioteca(" Biblioteca Municipal", "rua b 245");
        Scanner scanner = new Scanner(System.in);

        int opcao;

            do {
            System.out.println("----- MENU -----");
            System.out.println("1. Cadastrar Livro");
            System.out.println("2. Cadastrar Usuário");
            System.out.println("3. Emprestar Livro");
            System.out.println("4. Devolver Livro");
            System.out.println("5. Listar Livros Disponíveis");
            System.out.println("6. Listar Usuários");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha após o número

            switch (opcao) {
                case 1:
                    System.out.print("Digite o título do livro: ");
                    String tituloLivro = scanner.nextLine();
                    System.out.print("Digite o nome do autor do livro: ");
                    String autorLivro = scanner.nextLine();

                    Livro livro = new Livro(tituloLivro, autorLivro);
                    biblioteca.cadastrarLivro(livro);
                    System.out.println("Livro cadastrado com sucesso!");
                    break;

                case 2:
                    System.out.print("Digite o nome do usuário: ");
                    String nomeUsuario = scanner.nextLine().trim();
                    System.out.print("Digite o endereço do usuário: ");
                    String enderecoUsuario = scanner.nextLine().trim();
                    System.out.print("Digite o telefone do usuário: ");
                    String telefoneUsuario = scanner.nextLine().trim();

                    Usuario usuario = new Usuario(nomeUsuario, enderecoUsuario, telefoneUsuario);
                    biblioteca.cadastrarUsuario(usuario);
                    System.out.println("Usuário cadastrado com sucesso!");
                    break;

                case 3:
                    System.out.print("Digite o título do livro a ser emprestado: ");
                    String tituloLivroEmprestimo = scanner.nextLine();
                    System.out.print("Digite o nome do usuário que irá emprestar o livro: ");
                    String nomeUsuarioEmprestimo = scanner.nextLine();

                    Livro livroEmprestimo = biblioteca.buscarLivroPorTitulo(tituloLivroEmprestimo);
                    Usuario usuarioEmprestimo = biblioteca.buscarUsuarioPorNome(nomeUsuarioEmprestimo);

                    if (livroEmprestimo != null && usuarioEmprestimo != null) {
                        biblioteca.emprestarLivro(livroEmprestimo, usuarioEmprestimo);
                    } else {
                        System.out.println("Livro ou usuário não encontrado.");
                    }
                    break;

                case 4:
                    System.out.print("Digite o título do livro a ser devolvido: ");
                    String tituloLivroDevolucao = scanner.nextLine();

                    Livro livroDevolucao = biblioteca.buscarLivroPorTitulo(tituloLivroDevolucao);

                    if (livroDevolucao != null) {
                        biblioteca.devolverLivro(livroDevolucao);
                    } else {
                        System.out.println("Livro não encontrado.");
                    }
                    break;


                case 5:
                    System.out.println("----- Livros Disponíveis -----");
                    biblioteca.listarLivros();
                    break;

                case 6:
                    System.out.println("----- Usuários Cadastrados -----");
                    biblioteca.listarUsuarios();
                    break;

                case 0:
                    System.out.println("Saindo do programa...");
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }

            System.out.println();
        } while (opcao != 0);

        scanner.close();
    }
}
package org.example;


import javax.xml.transform.stream.StreamSource;
import java.net.StandardSocketOptions;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private String nome;
    private String endereco;
    private List<Livro> livros;
    private List<Usuario> usuarios;


    public Biblioteca(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
        this.livros = new ArrayList<>();
        this.usuarios = new ArrayList<>();
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    private boolean livroDisponivel(Livro livro) {
        return !livro.isEmprestado();
    }

    public void cadastrarLivro(Livro livro) {
        livros.add(livro);
        System.out.println("livro cadastrado com sucesso");
    }

    public void cadastrarUsuario(Usuario usuario) {
        usuarios.add(usuario);
        System.out.println("usuario cadastrado com sucesso");

    }

    public void emprestarLivro(Livro livro, Usuario usuario) {
        if (livroDisponivel(livro)) {
            livro.setEmprestado(true);
            livro.setUsuarioEmprestado(usuario);
            usuario.adicionarLivroEmprestado(livro); // Adiciona o livro à lista de livros emprestados do usuário
            System.out.println("Livro emprestado com sucesso!");
        } else {
            System.out.println("Livro não disponível para empréstimo.");
        }
    }

    public void listarLivros() {
        System.out.println("----- Livros Disponíveis -----");
        boolean livrosDisponiveis = false;
        for (Livro livro : livros) {
            if (!livro.isEmprestado()) {
                System.out.println(livro.getTitulo());
                livrosDisponiveis = true;
            }
        }
        if (!livrosDisponiveis) {
            System.out.println("Não há livros disponíveis.");
        }
    }



    public void devolverLivro(Livro livro) {
        if (livro.isEmprestado()) {
            livro.setEmprestado(false);
            Usuario usuario = livro.getUsuarioEmprestado();
            usuario.removerLivroEmprestado(livro);
            livro.setUsuarioEmprestado(null);
            System.out.println("Livro devolvido com sucesso.");
        } else {
            System.out.println("Este livro não está emprestado.");
        }
    }


    public Livro buscarLivroPorTitulo(String tituloLivro) {
        for (Livro livro : livros) {
            if (livro.getTitulo().equalsIgnoreCase(tituloLivro)) {
                return livro;
            }
        }
        return null; // Retornar null se o livro não for encontrado
    }

    public Usuario buscarUsuarioPorNome(String nomeUsuario) {
        for (Usuario usuario : usuarios) {
            if (usuario.getNome().equalsIgnoreCase(nomeUsuario)) {
                return usuario;
            }
        }
        return null;
    }



    public void listarUsuarios() {
        System.out.println("----- Usuários Cadastrados -----");
        for (Usuario usuario : usuarios) {
            System.out.println("Nome: " + usuario.getNome());
            System.out.println("Endereço: " + usuario.getEndereco());
            System.out.println("Telefone: " + usuario.getTelefone());
            System.out.println();
        }
    }
}




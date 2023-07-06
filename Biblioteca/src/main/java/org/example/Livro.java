package org.example;

public class Livro {
    private String titulo;
    private String autor;
    private boolean emprestado;
    private Usuario usuarioEmprestado;

    public Livro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
        this.emprestado = false;
        this.usuarioEmprestado = null;
    }


    public boolean isEmprestado() {
        return emprestado;
    }


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }


    public void setEmprestado(boolean emprestado) {
        this.emprestado = emprestado;
    }

    public Usuario getUsuarioEmprestado() {
        return usuarioEmprestado;
    }

    public void setUsuarioEmprestado(Usuario usuarioEmprestado) {
        this.usuarioEmprestado = usuarioEmprestado;
    }
}


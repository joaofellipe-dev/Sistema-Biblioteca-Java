package Biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class Admin {
    private String senha;
    private int ad;
    private int functons;
    private String cadastroLivros;

    public Admin() {
        this.senha = senha;
    }

    public void setDigito(int digito) {
        this.senha = senha;
    }

    public boolean autenticar(String senha) {
        if (senha.equals("acesso")) {
            return true;
        } else {
            return false;
        }
    }

    public void cadastrarLivro(ArrayList<Livro> biblioteca, Scanner sc) {
        sc.nextLine();
        System.out.println("Titulo do livro: ");
        String titulo = sc.nextLine();
        System.out.print("Autor: ");
        String autor = sc.nextLine();
        System.out.print("Quantidade inicial em estoque: ");
        int quantidade = sc.nextInt();
        sc.nextLine();

        Livro novo = new Livro(titulo, autor,quantidade);
        biblioteca.add(novo);
        System.out.println("Livro cadastrado com sucesso! ID: " + novo.getId());
    }

    public void adicionarQuantidade(ArrayList<Livro> biblioteca, int id, int qtd) {
        for (Livro l : biblioteca) {
            if (l.getId() == id) {
                l.setQuantidade(l.getQuantidade() + qtd);
                System.out.println("Quantidade atualizada!");
                return;
            }
        }
        System.out.println("Livro nao encontrado.");
    }

    public void excluirUsuario(ArrayList<Usuario> usuarios, int id) {
        boolean removido = usuarios.removeIf(u -> u.getId() == id);
        if (removido) {
            System.out.println("Usuario removido com sucesso.");
        } else {
            System.out.println("ID de usuario nao encontrado.");
        }
    }

    public void excluirLivro(ArrayList<Livro> biblioteca, int id) {
        boolean removido = biblioteca.removeIf(l -> l.getId() == id);
        if (removido) {
            System.out.println("Livro removido da biblioteca.");
        } else {
            System.out.println("ID de livro nao encontrado.");
        }
    }

    public void listarUsuarios(ArrayList<Usuario> usuarios) {
        System.out.println("\n--- LISTA DE USUARIOS ---");
        for (Usuario u : usuarios) {
            System.out.println("ID: " + u.getId() + " | Nome: " + u.getNome() + " | Idade: " + u.getIdade());
        }
    }


    public void listarLivrosDisponiveis(ArrayList<Livro> biblioteca) {
        for (Livro l : biblioteca) {
            if (l.isDisponivel()) {
                System.out.println("ID:" + l.getId() + " | TItulo: " + l.getTitulo() + " | Autor: " + l.getAutor() + " | Quantidade: " + l.getQuantidade());
            }
        }
    }

}


package Biblioteca;

import java.util.ArrayList;

public class Usuario {

    private String nome;
    private int idade;
    private int id;
    private static int idCounter = 1;

    private ArrayList<Livro> meusLivros = new ArrayList<>();

    public Usuario(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
        this.id = idCounter++;
    }

    public boolean verificar(String senhaInformada) {
        return senhaInformada.equals("entrar");
    }

    public void adicionarLivro(Livro livro) {
        meusLivros.add(livro);
    }

    public void removerLivroPorId(int idBuscado) {
        boolean removido = meusLivros.removeIf(l -> l.getId() == idBuscado);

        if (removido) {
            System.out.println("Livro devolvido com sucesso!");
        } else {
            System.out.println("Você não possui um livro com este ID.");
        }
    }

    public void listarMeusLivros() {
        if (meusLivros.isEmpty()) {
            System.out.println("Você não tem livros no momento.");
        } else {
            for (Livro l : meusLivros) {
                System.out.println("ID: " + l.getId() + " - " + l.getTitulo());
            }
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getId() {
        return id;
    }

    public ArrayList<Livro> getMeusLivros() {
        return meusLivros;
    }

    public Livro removerLivroPorIdERetornar(int idBuscado) {
        for (Livro l : meusLivros) {
            if (l.getId() == idBuscado) {
                meusLivros.remove(l);
                return l;
            }
        }
        System.out.println("Você não possui um livro com este ID.");
        return null;
    }
}
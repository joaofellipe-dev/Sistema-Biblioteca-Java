package Biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class CadastroUsuarios {
    public void cadastrar(ArrayList<Usuario> lista, Scanner sc) {

        System.out.println("Nome do usuário:");
        String nome = sc.nextLine();

        System.out.println("Idade do usuário:");
        int idade = sc.nextInt();
        sc.nextLine();

        Usuario novo = new Usuario(nome, idade);

        lista.add(novo);

        System.out.println("| Usuário: " + novo.getNome() + " | Idade: " + novo.getIdade() + " anos | ID: " + novo.getId() + " cadastrado!");
    }
}
package Biblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClassePrincipal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Livro> listaLivros = new ArrayList<>();
        ArrayList<Usuario> listaUsuarios = new ArrayList<>();
        int digito;
        String senha;
        int function;
        String user;
        int functionUser;
        String acesso;

        Admin adm = new Admin();
        CadastroUsuarios novo = new CadastroUsuarios();
        Emprestimo sistemaEmprestimo = new Emprestimo();

        System.out.printf("Digite 1 para acesso de admin.%nDigite 2 para acesso de usuario.%nDigite 3 para se cadastrar.%nDigite 4 para sair.%nDigite aqui:");
        digito = sc.nextInt();

        while (digito != 4) {

            if (digito == 1) {
                sc.nextLine();
                System.out.println("Digite a senha:(acesso)");
                senha = sc.nextLine();

                if (adm.autenticar(senha)) {

                    System.out.println("Acesso de Admin Confirmado!");
                    System.out.println("--- MENU ADMINISTRATIVO ---");
                    System.out.println("1.Cadastrar um livro novo");
                    System.out.println("2.Adicionar quantidade de livros pelo ID.");
                    System.out.println("3.Excluir usuarios pelo ID.");
                    System.out.println("4.Excluir livros pelo ID.");
                    System.out.println("5.Lista de usuarios.");
                    System.out.println("6.Lista dos livros disponiveis.");
                    System.out.println("0. Sair.");
                    System.out.println("Digite aqui:");
                    function = sc.nextInt();
                    sc.nextLine();

                    switch (function) {

                        case 1:
                            adm.cadastrarLivro(listaLivros, sc);
                            break;
                        case 2:
                            System.out.println("ID do livro: ");
                            int idQtd = sc.nextInt();
                            System.out.println("Quantidade a adicionar: ");
                            int qtd = sc.nextInt();
                            adm.adicionarQuantidade(listaLivros, idQtd, qtd);
                            break;

                        case 3:
                            System.out.println("ID do usuario para excluir: ");
                            int idUser = sc.nextInt();
                            adm.excluirUsuario(listaUsuarios, idUser);
                            break;

                        case 4:
                            System.out.println("ID do livro para excluir: ");
                            int idLivro = sc.nextInt();
                            adm.excluirLivro(listaLivros, idLivro);
                            break;

                        case 5:
                            adm.listarUsuarios(listaUsuarios);
                            break;

                        case 6:
                            adm.listarLivrosDisponiveis(listaLivros);
                            break;

                        case 0:
                            System.out.println("Saindo do menu admin...");
                            break;

                        default:
                            System.out.println("Opcao invalida!");
                            break;
                    }
                } else {
                    System.out.println("Senha incorreta!");
                }
            }
            if (digito == 2) {
                System.out.println("--- LOGIN DE USUÁRIO ---");
                System.out.print("Digite seu ID: ");
                int idLogin = sc.nextInt();
                sc.nextLine();

                Usuario usuarioLogado = null;

                for (Usuario u : listaUsuarios) {
                    if (u.getId() == idLogin) {
                        usuarioLogado = u;
                        break;
                    }
                }
                if (usuarioLogado != null) {
                    System.out.print("Digite a senha (entrar): ");
                    String senhaDigitada = sc.nextLine();

                    if (usuarioLogado.verificar(senhaDigitada)) {
                        System.out.println("Bem-vindo, " + usuarioLogado.getNome() + "!");

                        System.out.println("--- MENU USUARIO ---");
                        System.out.println("1. Devolução.");
                        System.out.println("2. Escolher Livros.");
                        System.out.println("3. Ver meus livros.");
                        System.out.println("4. Sair");

                        functionUser = sc.nextInt();
                        sc.nextLine();

                        switch (functionUser) {
                            case 1:
                                System.out.println("--- DEVOLUÇÃO ---");
                                usuarioLogado.listarMeusLivros();

                                System.out.print("Digite o ID do livro que deseja devolver: ");
                                int idParaDevolver = sc.nextInt();
                                sc.nextLine();

                                usuarioLogado.removerLivroPorId(idParaDevolver);
                                break;

                            case 2:
                                System.out.println("--- ESCOLHER LIVROS ---");
                                adm.listarLivrosDisponiveis(listaLivros);

                                System.out.print("Digite o ID do livro que deseja pegar: ");
                                int idLivroDesejado = sc.nextInt();
                                sc.nextLine();

                                Livro livroAchado = null;
                                for (Livro l : listaLivros) {
                                    if (l.getId() == idLivroDesejado) {
                                        livroAchado = l;
                                    }
                                }
                                if (livroAchado != null) {
                                    sistemaEmprestimo.realizarEmprestimo(usuarioLogado, livroAchado);
                                } else {
                                    System.out.println("Aviso: Livro com ID " + idLivroDesejado + " não encontrado.");
                                }
                                break;

                            case 3:
                                usuarioLogado.listarMeusLivros();
                                break;
                        }
                    } else {
                        System.out.println("Senha incorreta!");
                    }
                } else {
                    System.out.println("ID não encontrado! Cadastre-se primeiro.");
                }
            }
            if (digito == 3) {
                sc.nextLine();
                novo.cadastrar(listaUsuarios, sc);

                System.out.println("Cadastro concluido com sucesso.Sua senha como usuario e:(entrar)");
            }
            System.out.printf("%n--- MENU PRINCIPAL ---%n1. Admin | 2. Usuario | 3. Cadastro | 4. Sair%nDigite:");
            digito = sc.nextInt();
        }
        System.out.println("Programa Encerrado");

        sc.close();
    }

}




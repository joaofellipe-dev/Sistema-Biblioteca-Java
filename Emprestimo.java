package Biblioteca;

public class Emprestimo {
    private String usuario;

    public void realizarEmprestimo(Usuario user, Livro livro) {
        if (livro == null) {
            System.out.println("Erro: Livro não encontrado no sistema.");
            return;
        }


        if (livro.isDisponivel()) {

            livro.diminuirQuantidade();
            user.adicionarLivro(livro);

            System.out.println("------------------------------------------");
            System.out.println("EMPRÉSTIMO REALIZADO COM SUCESSO!");
            System.out.println("Livro: " + livro.getTitulo());
            System.out.println("Usuário: " + user.getNome());
            System.out.println("------------------------------------------");

        } else {
            System.out.println("Desculpe, o livro '" + livro.getTitulo() + "' já está emprestado no momento.");
        }
    }
    public void realizarDevolucao(Usuario user, int idLivro){
        Livro livroDevolvido = user.removerLivroPorIdERetornar(idLivro);
        if(livroDevolvido != null){
            livroDevolvido.aumentarQuantidade();
            System.out.println("Livro devolvido com sucesso!");
        }
    }
}


package Biblioteca;

public class Livro {
    private static int contador = 1;

    private int id;
    private String titulo;
    private String autor;
    private boolean disponivel;
    private int quantidade;

    public Livro(String titulo, String autor, int quantidade) {
        this.id = contador++;
        this.titulo = titulo;
        this.autor = autor;
        this.quantidade = quantidade;
        this.disponivel = quantidade > 0;
    }

    public int getId() {
        return this.id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public boolean isDisponivel(){
        return disponivel;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
        this.disponivel = quantidade > 0;
    }

    public int getQuantidade() {
        return quantidade;
    }
    public void diminuirQuantidade(){
        if(quantidade > 0){
            quantidade--;
            if(quantidade == 0){
                disponivel = false;
            }
        }
    }
    public void aumentarQuantidade(){
        quantidade++;
        disponivel = true;
    }
}

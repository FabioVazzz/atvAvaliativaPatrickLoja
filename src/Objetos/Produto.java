package Objetos;

public class Produto {
    private String nome;
    private int quantidade;
    private double preco;

    public Produto() {
    	
    }

    public Produto(String nome, int quantidade, double preco) {
        setNome(nome);
        setQuantidade(quantidade);
        setPreco(preco);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome != null && !nome.isBlank()) {
            this.nome = nome;
        } else {
            System.out.println("Nome inválido!");
        }
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        if (quantidade >= 0) {
            this.quantidade = quantidade;
        } else {
            System.out.println("Quantidade inválida!");
        }
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        if (preco > 0) {
            this.preco = preco;
        } else {
            System.out.println("Preço inválido!");
        }
    }

    public void mostrarProduto() {
        System.out.printf("Produto: %s | Preço: R$%.2f | Estoque: %d\n", nome, preco, quantidade);
    }
}

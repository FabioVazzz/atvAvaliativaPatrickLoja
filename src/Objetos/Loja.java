package Objetos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Loja {
    private static List<Produto> produtos = new ArrayList<>();
    private static List<Produto> carrinho = new ArrayList<>();
    private static Caixa caixa = new Caixa();
    private static Scanner scan = new Scanner(System.in);

    public static void cadastrarProduto() {
        System.out.print("Digite o nome do produto: ");
        String nome = scan.nextLine();

        for (Produto p : produtos) {
            if (p.getNome().equalsIgnoreCase(nome)) {
                System.out.println("Produto já cadastrado.");
                return;
            }
        }

        System.out.print("Digite o preço do produto: ");
        double preco = scan.nextDouble();
        System.out.print("Digite a quantidade inicial: ");
        int qtd = scan.nextInt();
        scan.nextLine();

        Produto novo = new Produto(nome, qtd, preco);
        produtos.add(novo);
        System.out.println("Produto cadastrado com sucesso!");
    }

    public static void listarProdutos() {
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
        } else {
            System.out.println("\n=== Lista de Produtos ===");
            for (Produto p : produtos) {
                p.mostrarProduto();
            }
        }
    }

    public static void realizarVenda() {
        listarProdutos();
        if (produtos.isEmpty()) {
            return;
        }

        System.out.print("\nDigite o nome do produto que deseja comprar: ");
        String nome = scan.nextLine();

        Produto escolhido = null;
        for (Produto p : produtos) {
            if (p.getNome().equalsIgnoreCase(nome)) {
                escolhido = p;
                break;
            }
        }

        if (escolhido == null) {
            System.out.println("Produto não encontrado.");
            return;
        }

        System.out.print("Digite a quantidade desejada: ");
        int qtd = scan.nextInt();
        scan.nextLine();

        if (qtd > escolhido.getQuantidade()) {
            System.out.println("Estoque insuficiente.");
            return;
        }

        double total = escolhido.getPreco() * qtd;
        System.out.printf("Valor total: R$%.2f\n", total);

        System.out.print("Digite o valor pago pelo cliente: ");
        double pago = scan.nextDouble();
        scan.nextLine();

        if (pago < total) {
            System.out.println("Valor insuficiente para a compra.");
            return;
        }

        double troco = pago - total;
        System.out.printf("Troco a devolver: R$%.2f\n", troco);

        boolean trocoOk = caixa.darTroco(troco);
        if (trocoOk) {
            escolhido.setQuantidade(escolhido.getQuantidade() - qtd);
            System.out.println("Venda realizada com sucesso.");
        } else {
            System.out.println("Venda cancelada por falta de troco.");
        }
    }

    // ====== MÉTODOS DO CARRINHO ======

    public static void adicionarAoCarrinho() {
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado para vender.");
            return;
        }

        listarProdutos();

        System.out.print("\nDigite o nome do produto que deseja adicionar ao carrinho: ");
        String nome = scan.nextLine();

        Produto escolhido = null;
        for (Produto p : produtos) {
            if (p.getNome().equalsIgnoreCase(nome)) {
                escolhido = p;
                break;
            }
        }

        if (escolhido == null) {
            System.out.println("Produto não encontrado.");
            return;
        }

        System.out.print("Digite a quantidade desejada: ");
        int qtd = scan.nextInt();
        scan.nextLine();

        if (qtd > escolhido.getQuantidade()) {
            System.out.println("Estoque insuficiente.");
        } else {
            Produto itemCarrinho = new Produto(escolhido.getNome(), qtd, escolhido.getPreco());
            carrinho.add(itemCarrinho);
            System.out.println("Produto adicionado ao carrinho.");
        }
    }

    public static void removerProdutoCarrinho() {
        if (carrinho.isEmpty()) {
            System.out.println("Carrinho vazio.");
            return;
        }

        mostrarCarrinho();

        System.out.print("Digite o nome do produto que deseja remover: ");
        String nome = scan.nextLine();

        Produto remover = null;
        for (Produto p : carrinho) {
            if (p.getNome().equalsIgnoreCase(nome)) {
                remover = p;
                break;
            }
        }

        if (remover != null) {
            carrinho.remove(remover);
            System.out.println("Produto removido do carrinho.");
        } else {
            System.out.println("Produto não encontrado no carrinho.");
        }
    }

    public static void mostrarCarrinho() {
        if (carrinho.isEmpty()) {
            System.out.println("Carrinho vazio.");
            return;
        }

        System.out.println("\n=== Carrinho de Compras ===");
        for (Produto p : carrinho) {
            System.out.printf("Produto: %s | Quantidade: %d | Preço: R$%.2f | Subtotal: R$%.2f\n",
                    p.getNome(), p.getQuantidade(), p.getPreco(), p.getPreco() * p.getQuantidade());
        }
    }

    public static void finalizarCompra() {
        if (carrinho.isEmpty()) {
            System.out.println("Carrinho vazio. Nenhuma compra para finalizar.");
            return;
        }

        double total = 0;
        for (Produto p : carrinho) {
            total += p.getPreco() * p.getQuantidade();
        }

        System.out.printf("Valor total da compra: R$%.2f\n", total);
        System.out.print("Digite o valor pago pelo cliente: ");
        double pago = scan.nextDouble();
        scan.nextLine();

        if (pago < total) {
            System.out.println("Valor insuficiente para a compra.");
            return;
        }

        double troco = pago - total;
        System.out.printf("Troco a devolver: R$%.2f\n", troco);

        boolean trocoOk = caixa.darTroco(troco);
        if (trocoOk) {
            for (Produto item : carrinho) {
                for (Produto p : produtos) {
                    if (p.getNome().equalsIgnoreCase(item.getNome())) {
                        p.setQuantidade(p.getQuantidade() - item.getQuantidade());
                    }
                }
            }
            carrinho.clear();
            System.out.println("Compra finalizada com sucesso!");
        } else {
            System.out.println("Venda cancelada por falta de troco.");
        }
    }

    // ====== CAIXA ======
    public static void mostrarCaixa() {
        caixa.mostrarCaixa();
    }
}

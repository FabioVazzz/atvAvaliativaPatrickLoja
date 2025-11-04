package Loja;

import Objetos.Loja;
import java.util.Scanner;

public class PrincipalLoja {
    private static Scanner scan = new Scanner(System.in); 

    public static void main(String[] args) {
        int opcao;

        do {
            System.out.println("\n=== MENU LOJA ===");
            System.out.println("1 - Cadastrar produto");
            System.out.println("2 - Listar produtos");
            System.out.println("3 - Realizar venda direta");
            System.out.println("4 - Mostrar caixa");
            System.out.println("5 - Carrinho de compras");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scan.nextInt();
            scan.nextLine(); // limpa o ENTER

            switch (opcao) {
                case 1 -> Loja.cadastrarProduto();
                case 2 -> Loja.listarProdutos();
                case 3 -> Loja.realizarVenda();
                case 4 -> Loja.mostrarCaixa();
                case 5 -> menuCarrinho();
                case 0 -> System.out.println("Encerrando o sistema!");
                default -> System.out.println("Opção inválida.");
            }
        } while (opcao != 0);

        scan.close();
    }

    private static void menuCarrinho() {
        int op;
        do {
            System.out.println("\n=== MENU CARRINHO ===");
            System.out.println("1 - Adicionar produto");
            System.out.println("2 - Remover produto");
            System.out.println("3 - Mostrar carrinho");
            System.out.println("4 - Finalizar compra");
            System.out.println("0 - Voltar");
            System.out.print("Escolha: ");

            op = scan.nextInt();
            scan.nextLine();

            switch (op) {
                case 1 -> Loja.adicionarAoCarrinho();
                case 2 -> Loja.removerProdutoCarrinho();
                case 3 -> Loja.mostrarCarrinho();
                case 4 -> Loja.finalizarCompra();
                case 0 -> System.out.println("Voltando ao menu principal...");
                default -> System.out.println("Opção inválida!");
            }
        } while (op != 0);
    }
}

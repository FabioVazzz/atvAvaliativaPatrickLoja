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
            scan.nextLine(); 

            switch (opcao) {
                case 1: 
                	Loja.cadastrarProduto();
                	break;
                case 2: 
                	Loja.listarProdutos();
                	break;
                case 3: 
                	Loja.realizarVenda();
                	break;
                case 4:
                	Loja.mostrarCaixa();
                	break;
                case 5:
                	menuCarrinho();
                	break;
                case 0:
                	System.out.println("Encerrando o sistema!");
                	break;
                default:
                	System.out.println("Opção inválida.");
                	break;
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
                case 1:
                	Loja.adicionarAoCarrinho();
                	break;
                case 2:
                	Loja.removerProdutoCarrinho();
                	break;
                case 3:
                	Loja.mostrarCarrinho();
                	break;
                case 4:
                	Loja.finalizarCompra();
                	break;
                case 0:
                	System.out.println("Voltando ao menu principal...");
                	break;
                default:
                	System.out.println("Opção inválida!");
                	break;
            }
        } while (op != 0);
    }
}

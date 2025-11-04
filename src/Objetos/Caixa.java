package Objetos;

public class Caixa {
    private int notas50 = 5;
    private int notas20 = 5;
    private int notas10 = 5;

    public double calcularTotal() {
        return notas50 * 50 + notas20 * 20 + notas10 * 10;
    }

    public void mostrarCaixa() {
        System.out.println("\n=== Saldo em Caixa ===");
        System.out.println("Notas de R$50: " + notas50);
        System.out.println("Notas de R$20: " + notas20);
        System.out.println("Notas de R$10: " + notas10);
        System.out.printf("Total em caixa: R$%.2f\n", calcularTotal());
    }

    public boolean darTroco(double troco) {
        int trocoInt = (int) troco;
        int qtd50 = 0, qtd20 = 0, qtd10 = 0;

        while (trocoInt >= 50 && notas50 > 0) {
            trocoInt -= 50;
            notas50--;
            qtd50++;
        }
        while (trocoInt >= 20 && notas20 > 0) {
            trocoInt -= 20;
            notas20--;
            qtd20++;
        }
        while (trocoInt >= 10 && notas10 > 0) {
            trocoInt -= 10;
            notas10--;
            qtd10++;
        }

        if (trocoInt == 0) {
            System.out.println("Troco entregue:");
            System.out.println(qtd50 + " nota(s) de R$50, " + qtd20 + " nota(s) de R$20, " + qtd10 + " nota(s) de R$10");
            return true;
        } else {
            System.out.println("Não há notas suficientes para o troco.");
            notas50 += qtd50;
            notas20 += qtd20;
            notas10 += qtd10;
            return false;
        }
    }
}
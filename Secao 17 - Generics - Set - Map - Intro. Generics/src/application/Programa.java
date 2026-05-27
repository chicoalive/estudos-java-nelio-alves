package application;

import services.ServicoDeImpresao;

import java.util.Scanner;

public class Programa {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        // Cria uma instância de ServicoDeImpresao para o tipo Integer.
        ServicoDeImpresao<Integer> servico = new ServicoDeImpresao<>();

        System.out.print("Quantos valores serão digitados: ");
        int quantidade = Integer.parseInt(teclado.nextLine().trim());

        // Lê a quantidade de valores informada pelo usuário.
        for (int i = 0; i < quantidade; i++) {
            System.out.print("Digite um número: ");
            int numero = Integer.parseInt(teclado.nextLine().trim());
            servico.addValor(numero);
        }

        // Imprime a lista de valores formatada.
        System.out.println("Valores: ");
        servico.imprimir();
        
        // Obtém e exibe o primeiro valor da lista.
        Integer x = servico.primeiro();
        System.out.println();
        System.out.println("Primeiro elemento: " + x);

        teclado.close();
    }
}

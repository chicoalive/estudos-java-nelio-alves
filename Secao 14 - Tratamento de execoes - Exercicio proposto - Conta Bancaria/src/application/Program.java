package application;

import model.entities.Account;
import model.exceptions.ExceptionDomain;

import java.util.Locale;
import java.util.Scanner;

// Solução do problema de saque bancário com tratamento de exceções
public class Program {
    public static void main(String[] args) {
        // Configura o locale para US para garantir o uso do ponto como separador decimal
        Locale.setDefault(Locale.US);
        // Cria um objeto Scanner para ler dados do teclado
        Scanner teclado = new Scanner(System.in);
        // Variável para controlar a validade do saque
        boolean saqueValido = false;
        // Cria uma instância da classe Account
        Account account = new Account();
        // Loop para garantir que os dados da conta sejam inseridos corretamente
        while (!saqueValido) {
            try {
                // Solicita e lê os dados da conta
                System.out.println("Insira os dados da conta: ");
                System.out.print("Número da conta: ");
                int numeroConta = Integer.parseInt(teclado.nextLine().trim());
                System.out.print("Titular da conta: ");
                String titularConta = teclado.nextLine().trim();
                System.out.print("Saldo inicial da conta: ");
                double saldoConta = Double.parseDouble(teclado.nextLine().trim());
                System.out.print("Limite de saque: ");
                double limiteSaque = Double.parseDouble(teclado.nextLine().trim());
                // Cria uma nova instância de Account com os dados fornecidos
                account = new Account(numeroConta, titularConta, saldoConta, limiteSaque);
                System.out.println();
                // Se os dados forem válidos, sai do loop
                saqueValido = true;
            } catch (ExceptionDomain e) {
                // Captura e trata exceções de domínio (regras de negócio)
                System.out.println("Erro no saque: " + e.getMessage());
            } catch (NumberFormatException e) {
                // Captura e trata erros de conversão de número
                System.out.println("Erro na conversão de dados");
            }
        }
        // Dividindo o sistema em dois, para não perde progresso.
        // Reseta a variável para controlar o próximo loop
        saqueValido = false;
        // Loop para garantir que o valor do saque seja inserido e processado corretamente
        while (!saqueValido) {
            try {
                // Solicita e lê o valor do saque
                System.out.print("Valor do saque: ");
                double valorSaque = Double.parseDouble(teclado.nextLine().trim());
                // Tenta realizar o saque
                account.withdraw(valorSaque);
                System.out.println();
                // Imprime os dados da conta após o saque
                System.out.println(account);
                // Se o saque for bem-sucedido, sai do loop
                saqueValido = true;
            } catch (ExceptionDomain e) {
                // Captura e trata exceções de domínio (regras de negócio) durante o saque
                System.out.println("Erro no saque: " + e.getMessage());
            } catch (NumberFormatException e) {
                // Captura e trata erros de conversão de número
                System.out.println("Erro na conversão de dados");
            }
        }

        // Fecha o Scanner para liberar os recursos
        teclado.close();
    }
}

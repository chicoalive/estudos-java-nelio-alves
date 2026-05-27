package application;

import model.entities.Contract;
import model.services.ContractService;
import model.services.PaypalService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Locale.setDefault(Locale.US);
        // De todo jeito preciso da mascara, seja para exibir ou coletar dados
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Digite os dados do contrato: ");
        System.out.print("Numero do contrato: ");
        // para coletar a data uso parse, ou seja, de texto para data.
        Integer number = Integer.parseInt(teclado.nextLine().trim());
        System.out.print("Data do contrato: ");
        LocalDate date = LocalDate.parse(teclado.nextLine().trim(), formatter);
        System.out.print("Valor do contrato: ");
        Double totalValue = Double.parseDouble(teclado.nextLine().trim());

        Contract contract = new Contract(number, date, totalValue);

        System.out.print("Digite o numero de parcelas: ");
        Integer months = Integer.parseInt(teclado.nextLine().trim());

        // Criando o serviço de contratos
        ContractService contractService = new ContractService(new PaypalService());
        contractService.processContrato(contract, months);
        System.out.println();
        // Exibindo parcelas
        System.out.println("\nParcelas pagas no PayPal:");
        contract.printInstallments();

    }
}

package application;

import entities.Employee;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Program {
    static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner teclado = new Scanner(System.in);

        // Pedindo ao usuário o caminho do arquivo, depois
        System.out.print("Entre com o caminho do arquivo: ");
        String path = teclado.nextLine();
        System.out.print("Salário mínimo para filtro: ");
        Double salaryComparison = Double.parseDouble(teclado.nextLine().trim());
        System.out.print("Letra inicial para somar salários: ");
        char letter = teclado.nextLine().toUpperCase().trim().charAt(0);

        // Bloco try-with-resources para garantir que o BufferedReader seja fechado automaticamente
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            // Criando uma lista de funcionários
            List<Employee> employees = new ArrayList<>();

            String line = br.readLine();
            while (line != null) {
                String[] fields = line.split(",");
                employees.add(new Employee(fields[0], fields[1], Double.parseDouble(fields[2])));
                line = br.readLine();
            }

            // Operações com Stream. Filtrando funcionários com salário superior ao mínimo e exibindo a lista deles por email e devolvendo a soma de salários dos funcionários que começam com M

            double sum = employees.stream()
                    .filter(e -> e.getName().charAt(0) == letter)
                    .mapToDouble(e -> e.getSalary())
                    .sum();

            List<String> emails = employees.stream()
                    .filter(e -> e.getSalary() > salaryComparison)
                    .map(e -> e.getEmail())
                    .collect(Collectors.toList());

            emails.forEach(System.out::println);
            System.out.println("Soma dos salários das pessoas cujos os nomes começam com a letra: " + letter + ": " + String.format("%.2f", sum));

        } catch (Exception e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }


        teclado.useLocale(Locale.US);
    }
}

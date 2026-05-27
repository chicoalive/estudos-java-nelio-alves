package application;

import entities.Funcionarios;
import entities.FuncionariosTercerizado;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Programa {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner teclado = new Scanner(System.in);

        List<Funcionarios> listaFuncio = new ArrayList<>();

        // Criando os funcionários.
        System.out.print("Quantos funcionários serão cadastrados: ");
        int numeroFunc = teclado.nextInt();
        System.out.println();
        for (int i = 0; i < numeroFunc; i++) {
            System.out.println("Dados do funcionário " + (i + 1) + "º: ");
            System.out.print("Funcionário é terceirizado (sim/não): ");
            String respTerce = teclado.next();
            teclado.nextLine();
            System.out.print("Nome: ");
            String nome = teclado.nextLine();
            System.out.print("Horas trabalhadas: ");
            int horasTrab = teclado.nextInt();
            System.out.print("Valor por hora: ");
            double valPorHora = teclado.nextDouble();
            if (respTerce.equals("sim")) {
                System.out.print("Cobrança adicional: ");
                double cobranAdicional = teclado.nextDouble();
                // Instanciação direta: cria objeto e adiciona à lista em uma única linha
                // Equivalente a: Funcionarios func = new Funcionarios(...); listaFuncio.add(func);
                listaFuncio.add(new FuncionariosTercerizado(nome, horasTrab, valPorHora, cobranAdicional));
            } else {
                listaFuncio.add(new Funcionarios(nome, horasTrab, valPorHora));
            }
            System.out.println();
        }

        System.out.println("Pagamentos: ");
        for (Funcionarios func : listaFuncio) {
            System.out.println(func.getNome() + " - R$ " + String.format("%.2f", func.pagamento()));
        }
        teclado.close();
    }
}

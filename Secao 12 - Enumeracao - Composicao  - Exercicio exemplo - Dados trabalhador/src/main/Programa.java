package main;

import entities.Departamento;
import entities.HorasTrabalhadas;
import entities.Trabalhador;
import entities.enums.NivelTrabalhador;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Programa {
    static void main() throws ParseException {
        Scanner teclado = new Scanner(System.in);
        // Define o formato de data que será usado
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Digite o nome do departamento: ");
        String nomeDepartamento = teclado.nextLine();
        System.out.println("Digite os dados do trabalhador: ");
        System.out.print("Nome: ");
        String nomeTrabalhador = teclado.nextLine();
        System.out.print("Digite o nível do trabalhador: ");
        String nivelTrabalhador = teclado.next();
        System.out.print("Salário base: ");
        double salarioBase = teclado.nextDouble();
        // Instancia um novo Departamento com o nome informado (pois Trabalhador guarda um objeto Departamento, não apenas uma String)
        // Em Nive...valueOf temos que converter a String para um enum.
        Trabalhador trabalhador = new Trabalhador(new Departamento(nomeDepartamento), nomeTrabalhador, NivelTrabalhador.valueOf(nivelTrabalhador), salarioBase);
        System.out.println();
        System.out.print("Quantidade de contrato do trabalhador: ");
        int qtdContratos = teclado.nextInt();
        System.out.println();
        for (int i = 0; i < qtdContratos; i++) {
            System.out.println("Dados do " + (i + 1) + "º contrato: ");
            System.out.print("Data (DD/MM/YYYY): ");
            // Converte String em Date. O método parse pode lançar uma ParseException
            Date dataContrato = formato.parse(teclado.next());
            System.out.print("Valor por hora: ");
            double valorHora = teclado.nextDouble();
            System.out.print("Duração (horas): ");
            int duracaoHoras = teclado.nextInt();
            // Cria um novo objeto HorasTrabalhadas com os dados informados
            HorasTrabalhadas contrato = new HorasTrabalhadas(dataContrato, valorHora, duracaoHoras);
            // Adiciona o contrato criado à lista de contratos do trablhador
            trabalhador.addContrato(contrato);
        }
        System.out.println();
        System.out.print("Digite o mês e ano para calcular a renda (MM/YYYY): ");
        String mesEAno = teclado.next();
        int mes = Integer.parseInt(mesEAno.substring(0, 2)); // Extrai os dois primeiros caracteres
        int ano = Integer.parseInt(mesEAno.substring(3)); // Extrai a parte após a barra ano
        System.out.println("Nome: " + trabalhador.getNome());
        System.out.println("Departamento: " + trabalhador.getDepartamento().getNome());
        // Calcula e exibe a rtenda do trabalhador no período informado
        System.out.println("Renda no periodo " + mesEAno + ": " + String.format("%.2f", trabalhador.rendaPeriodo(mes, ano)));


        teclado.close();
    }
}

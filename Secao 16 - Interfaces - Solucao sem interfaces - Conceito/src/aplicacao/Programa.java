package aplicacao;

import modelo.entidades.AluguelDeCarro;
import modelo.entidades.Veiculo;
import modelo.servicos.ImpostoBrasil;
import modelo.servicos.ServicoAluguel;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Programa {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner teclado = new Scanner(System.in);
        
        // Declaração de variáveis para datas - precisam ser acessíveis fora do loop de validação
        Boolean dataCerta = false;
        LocalDateTime inicio = null, fim = null;
        // Formato esperado para entrada de datas
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        // === COLETA DE DADOS DO VEÍCULO ===
        System.out.println("Digite os dados do aluguel:");
        System.out.print("Modelo do carro: ");
        String modelo = teclado.nextLine().trim();
        System.out.print("Placa do carro: ");
        String placa = teclado.nextLine().trim();
        // Usamos nextLine() para ler a linha inteira e evitar erros de buffer no Scanner

        // === COLETA E VALIDAÇÃO DE DATAS ===
        // Loop de validação: mantém o usuário preso até que ambas as datas sejam validadas
        while (!dataCerta) {
            try {
                System.out.print("Retirada (dd/MM/yyyy HH:mm): ");
                inicio = LocalDateTime.parse(teclado.nextLine().trim(), formatter);
                System.out.print("Retorno (dd/MM/yyyy HH:mm): ");
                fim = LocalDateTime.parse(teclado.nextLine().trim(), formatter);
                dataCerta = true; // Datas válidas, sai do loop
            } catch (DateTimeException e) {
                System.out.println("Formato de data inválido. Use o formato dd/MM/yyyy HH:mm");
            }
        }
        
        // === CRIAÇÃO DO OBJETO ALUGUEL ===
        // Instancia o objeto AluguelDeCarro com os dados coletados
        AluguelDeCarro aluguelDeCarro = new AluguelDeCarro(inicio, fim, new Veiculo(modelo, placa));
        System.out.println();

        // === COLETA DE PREÇOS DO SERVIÇO ===
        System.out.print("Digite o valor por hora: ");
        double precoPorHora = Double.parseDouble(teclado.nextLine().trim());
        System.out.print("Digite o valor por dia: ");
        double precoPorDia = Double.parseDouble(teclado.nextLine().trim());

        // === CONFIGURAÇÃO DO SERVIÇO DE ALUGUEL ===
        // Cria o serviço de aluguel com os preços e a implementação de imposto brasileiro
        ServicoAluguel servicoAluguel = new ServicoAluguel(precoPorHora, precoPorDia, new ImpostoBrasil());

        // === PROCESSAMENTO DA FATURA ===
        // Calcula o pagamento básico, imposto e gera a fatura
        servicoAluguel.processarFatura(aluguelDeCarro);
        
        // === EXIBIÇÃO DOS RESULTADOS ===
        System.out.println();
        System.out.println(aluguelDeCarro.getFatura());
        
        // === FINALIZAÇÃO ===
        teclado.close(); // Fecha o Scanner para liberar recursos
    }
}

package application;

import model.entities.Reserva;
import model.exceptions.DominiodeExcecao;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;
import java.util.Scanner;

public class Programa {
    public static void main(String[] args) {
        // Controla o loop principal, repetindo o processo até que uma reserva seja concluída com sucesso.
        boolean reservaValida = false;

        // Garante que o ponto '.' seja o separador decimal, evitando, erros de leitura em diferentes sistemas.
        Locale.setDefault(Locale.US);
        // Cria o Scanner para ler a entrada do usuário a partir do console.
        Scanner teclado = new Scanner(System.in);


        // Define o formato que a data deve ter (ex: "23/09/2024") para conversão de String para LocalDate.
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        while (!reservaValida) {
            try {
                // --- Leitura dos dados iniciais da reserva ---
                System.out.print("Número do quarto: ");
                // Lê a linha, remove espaços com trim() e converte para inteiro em um único passo.
                int numeroDoQuarto = Integer.parseInt(teclado.nextLine().trim());


                // Usa o método auxiliar para garantir que a data digitada seja válida.
                LocalDate dataDeCheckIn = lerDataValida(teclado, "Data de check-in (dd/MM/yyyy): ", formato);
                LocalDate dataDeCheckOut = lerDataValida(teclado, "Data de check-out (dd/MM/yyyy): ", formato);

                // Instancia a Reserva. O construtor já valida se a data de check-out é posterior à de check-in.
                Reserva reserva = new Reserva(numeroDoQuarto, dataDeCheckIn, dataDeCheckOut);
                System.out.println("Reserva criada: " + reserva); // Chama o método toString() da Reserva.

                System.out.println();

                // --- Leitura dos dados para atualização ---
                System.out.println("Digite os dados para atualizar a reserva:");
                dataDeCheckIn = lerDataValida(teclado, "Data de check-in (dd/MM/yyyy): ", formato);
                dataDeCheckOut = lerDataValida(teclado, "Data de check-out (dd/MM/yyyy): ", formato);

                // Chama o método de atualização, que contém suas próprias regras de validação.
                reserva.atualizarDatas(dataDeCheckIn, dataDeCheckOut);
                System.out.println("Reserva atualizada: " + reserva);
                
                // Se chegou até aqui, a operação foi um sucesso e o loop pode terminar.
                reservaValida = true;


            } catch (DominiodeExcecao excecao) {
                // Captura erros de regra de negócio definidos na classe Reserva.
                System.out.println("Erro na reserva: " + excecao.getMessage());
            } catch (NumberFormatException excecao) {
                // Captura erro se o usuário digitar um texto no lugar do número do quarto.
                System.out.println("Erro na reserva: Por favor, digite apenas números para os quartos ");
            }


        }
        // Boa prática: fecha o Scanner para liberar recursos do sistema.
        teclado.close();
    }


    /**
     * Método auxiliar para ler e validar uma data do console.
     * Encapsula a lógica de repetição e tratamento de erro de formato.
     * 'static' porque é chamado pelo método main (que também é static) e não depende de um objeto 'Programa'.
     * @return um objeto LocalDate válido.
     */
    public static LocalDate lerDataValida(Scanner teclado, String mensagem, DateTimeFormatter formato) {
        // Loop que só termina quando uma data válida é digitada e retornada.
        while (true) {
            try {
                System.out.print(mensagem);
                // Tenta converter o texto digitado para um objeto LocalDate.
                return LocalDate.parse(teclado.nextLine().trim(), formato);
            } catch (DateTimeParseException ex) {
                // Se a conversão falhar, informa o usuário e o loop continua.
                System.out.println("Você deve digitar a data no formato dd/MM/yyyy");
            }
        }
    }
}

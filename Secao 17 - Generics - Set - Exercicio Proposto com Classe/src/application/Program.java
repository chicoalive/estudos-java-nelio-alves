package application;

import entities.Participant;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Program {
    public static void main(String[] args) {
        // Inicializa o Scanner para ler dados do teclado.
        Scanner teclado = new Scanner(System.in);
        // Cria um conjunto (Set) para armazenar os participantes.
        // O Set não permite elementos duplicados, garantindo que cada participante seja único.
        Set<Participant> participantes = new HashSet<>();

        System.out.println("Bem vindo a feira tecnológica do Gemini");
        System.out.print("Digite o numeros de participantes: ");
        // Lê a quantidade de participantes que serão cadastrados.
        int qtdParticipantes = Integer.parseInt(teclado.nextLine().trim());

        // Loop para cadastrar cada um dos participantes.
        for (int i = 0; i < qtdParticipantes; i++) {
            System.out.println("Dados do "+(i+1) +"ª participante: ");
            System.out.print("Nome: ");
            String nome = teclado.nextLine().trim();
            System.out.print("Email: ");
            String email = teclado.nextLine().trim();
            // Adiciona o novo participante ao conjunto.
            // Se um participante com o mesmo e-mail já existir, ele não será adicionado novamente.
            participantes.add(new Participant(nome, email));
            System.out.println();
        }
        // A contagem de participantes únicos é feita automaticamente pelo Set.
        // O método .size() retorna o número de elementos únicos no conjunto.

        // Exibe o número total de participantes únicos.
        System.out.println("Total de participantes: " + participantes.size());
        System.out.println();
        // Itera sobre o conjunto e exibe os dados de cada participante.
        for (Participant participant : participantes) {
            System.out.println(participant.toString());
        }

        // Fecha o Scanner para liberar os recursos.
        teclado.close();
    }
}

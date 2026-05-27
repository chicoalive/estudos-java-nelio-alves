package application;

import entities.VotingBallotBox;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        // O Map irá armazenar os dados da votação, onde a chave (String) é o nome do candidato
        // e o VALOR agora é o próprio OBJETO VotingBallotBox.
        Map<String, VotingBallotBox> map = new HashMap<>();

        System.out.print("Digite o caminho do arquivo: ");
        String caminhoArquivo = teclado.nextLine().trim();

        // O bloco try-with-resources garante que o 'BufferedReader' (leitor de arquivo)
        // seja fechado automaticamente ao final, mesmo que ocorra um erro.
        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {

            String linha = br.readLine();
            // O loop continua enquanto houver linhas para serem lidas no arquivo.
            while (linha != null) {
                // Divide a linha em duas partes usando a vírgula como separador.
                // campos[0] terá o nome do candidato, campos[1] terá o número de votos.
                String[] campos = linha.split(",");
                String candidato = campos[0];
                int votos = Integer.parseInt(campos[1]);

                // Verifica se o mapa já contém uma entrada para este candidato.
                if (map.containsKey(candidato)) {
                    // Se JÁ EXISTE, puxamos o objeto da urna que já está no Map
                    VotingBallotBox urnaExistente = map.get(candidato);

                    // Somamos os votos antigos com os votos da linha atual
                    int votosAtualizados = urnaExistente.getVotos() + votos;

                    // Atualizamos a "alma" do objeto
                    urnaExistente.setVotos(votosAtualizados);

                    // Guardamos o objeto atualizado de volta no Map
                    map.put(candidato, urnaExistente);
                } else {
                    // Se NÃO EXISTE (primeira vez aparecendo), criamos o objeto do zero
                    VotingBallotBox novaUrna = new VotingBallotBox(candidato, votos);

                    // E guardamos no Map
                    map.put(candidato, novaUrna);
                }

                linha = br.readLine(); // Lê a próxima linha do arquivo para continuar o loop.
            }

        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
        System.out.println();
        System.out.println("Dados da votação: ");

        // Loop para percorrer cada entrada (par chave-valor) do mapa.
        // A variável 'entry' armazena esse par a cada iteração.
        for (Map.Entry<String, VotingBallotBox> entry : map.entrySet()) {
            // entry.getKey() retorna o nome (String).
            // entry.getValue() retorna o objeto inteiro, então usamos .getVotos() para imprimir só o número.
            System.out.println(entry.getKey() + ": " + entry.getValue().getVotos());
        }

        teclado.close();
    }

}

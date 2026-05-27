package application;

import entities.Empregado;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Programa {
    public static void main(String[] args) {

        List<Empregado> listaEmpregados = new ArrayList<>();
        // A variável 'caminhoArquivo' armazena o caminho do arquivo de entrada.
        // Note que as barras invertidas (\) precisam ser duplicadas (\\) em uma String Java.
        String caminhoArquivo = "C:\\Users\\chico\\OneDrive\\Desktop\\Entrada.txt";
        
        // Bloco try-with-resources para garantir que o BufferedReader seja fechado automaticamente.
        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            // A variável 'empregadosCsv' armazena cada linha lida do arquivo.
            String  empregadosCsv = br.readLine();
            while (empregadosCsv != null) { // Enquanto houver linhas no arquivo, continue lendo.
                String[] campos = empregadosCsv.split(","); // Divide a linha em nome e salário usando a vírgula como delimitador.
                listaEmpregados.add(new Empregado(campos[0], Double.parseDouble(campos[1]))); // Adiciona um novo empregado à lista.
                empregadosCsv = br.readLine(); // Lê a próxima linha do arquivo.
            }
            // O 'Collections.sort()' ordena a lista.
            // Isso só é possível porque a classe 'Empregado' implementa a interface 'Comparable',
            // que define o critério de ordenação padrão (neste caso, por nome).
            Collections.sort(listaEmpregados);
            // Itera sobre a lista já ordenada e imprime os dados de cada empregado.
            for (Empregado empregado : listaEmpregados) {
                System.out.println(empregado);
            }
        // Captura exceções que possam ocorrer durante a leitura do arquivo.
        } catch ( IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }


    }

}

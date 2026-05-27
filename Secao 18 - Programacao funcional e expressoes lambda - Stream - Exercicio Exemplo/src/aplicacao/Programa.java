package aplicacao;

import entidades.Produto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Programa {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner teclado = new Scanner(System.in);

        System.out.print("Digite o caminho do arquivo: ");
        String caminhoArquivo = teclado.nextLine();

        // Bloco try-with-resources para garantir que o BufferedReader seja fechado automaticamente
        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {

            // Cria uma lista para armazenar os produtos lidos do arquivo
            List<Produto> listaProdutos = new ArrayList<>();

            // Lê a primeira linha do arquivo
            String linha = br.readLine();
            while (linha != null) {
                String[] campos = linha.split(",");
                // Instancia um novo Produto com os dados da linha e o adiciona à lista
                listaProdutos.add(new Produto(campos[0], Double.parseDouble(campos[1])));
                // Lê a próxima linha
                linha = br.readLine();
            }

            // --- OPERAÇÕES COM STREAM ---

            // Calcula o preço médio dos produtos.
            double media = listaProdutos.stream()
                    .mapToDouble(Produto::getPreco) // Mapeia para os preços
                    .average() // Calcula a média
                    .orElse(0.0); // Retorna 0.0 se a lista for vazia

            System.out.println("Preço médio: " + String.format("%.2f", media));

            // A variável 'comp' não é mais necessária, pois a lógica de comparação foi movida para dentro do 'sorted'.
            // Comparator<String> comp = (s1, s2) -> s1.toUpperCase().compareTo(s2.toUpperCase());

            List<String> nomes = listaProdutos.stream()
                    // 1. Filtra a stream, mantendo apenas produtos com preço abaixo da média.
                    .filter(p -> p.getPreco() < media)
                    // 2. Extrai apenas o nome de cada produto filtrado.
                    .map(Produto::getNome)
                    // 3. Ordena os nomes em ordem decrescente (case-insensitive).
                    //    A lógica s2.compareTo(s1) inverte a ordem padrão (que seria s1.compareTo(s2)).
                    .sorted((s1, s2) -> s2.toUpperCase().compareTo(s1.toUpperCase()))
                    // 4. Coleta os nomes ordenados em uma nova lista.
                    .collect(Collectors.toList());

            // Imprime cada nome da lista resultante.
            nomes.forEach(System.out::println);

        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }


        teclado.close();
    }
}

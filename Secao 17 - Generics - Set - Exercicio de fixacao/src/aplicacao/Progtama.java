package aplicacao;

import entidades.RegistroEntrada;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Progtama {

    public static void main(String[] args) {
        // Cria um objeto Scanner para ler a entrada do console.
        Scanner teclado = new Scanner(System.in);

        // Solicita ao usuário o caminho do arquivo de log.
        System.out.print("Digite o caminho do arquivo: ");
        String caminho = teclado.nextLine();

        // Bloco try-with-resources para garantir que o BufferedReader seja fechado automaticamente.
        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
            // Cria um conjunto (Set) do tipo HashSet para armazenar os registros de entrada.
            // O HashSet é usado para garantir que não haja registros duplicados,
            // pois a classe RegistroEntrada implementa equals e hashCode.
            // Isso nos permite contar o número de usuários únicos.
            Set<RegistroEntrada> set = new HashSet<>();

            // Lê a primeira linha do arquivo.
            String linha = br.readLine();
            // Loop para ler todas as linhas do arquivo.
            while (linha != null) {
                // Divide a linha em campos separados por espaço.
                String[] campos = linha.split(" ");
                String usuario = campos[0]; // O primeiro campo é o nome de usuário.
                Date momento = Date.from(Instant.parse(campos[1])); // O segundo campo é o momento do acesso.
                
                // Adiciona um novo registro de entrada ao conjunto.
                set.add(new RegistroEntrada(usuario, momento));
                
                // Lê a próxima linha do arquivo.
                linha = br.readLine();
            }
            // Exibe o número total de usuários únicos.
            System.out.println("Total de usuários: " + set.size());
        } catch (IOException e) {
            // Captura e trata exceções de E/S (por exemplo, arquivo não encontrado).
            System.out.println("Erro ao ler o arquivo." + e.getMessage());
        }

        // Fecha o objeto Scanner para liberar os recursos.
        teclado.close();
    }
}

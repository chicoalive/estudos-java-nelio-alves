import java.io.*;
import java.util.Scanner;

public class Programa {
    public static void main(String[] args) {
        // Demonstra a leitura de um arquivo usando as classes File e Scanner.

        // Cria um objeto File, especificando o caminho do arquivo.
        // Em caminhos de arquivo do Windows, as barras invertidas precisam ser escapadas
        // (ex: "C:\\caminho\\para\\arquivo.txt").
        File arquivo = new File("C:\\Users\\chico\\Downloads\\dentro.txt");

        // Declara um objeto Scanner, inicializando-o como null.
        Scanner teclado = null;

        try {
            // Instancia o Scanner a partir do objeto File.
            // Esta operação pode lançar uma FileNotFoundException se o arquivo não existir.
            teclado = new Scanner(arquivo);

            // Itera sobre as linhas do arquivo enquanto houver uma próxima linha.
            while (teclado.hasNextLine()) {
                String linha = teclado.nextLine();
                System.out.println(linha);
            }
        } catch (FileNotFoundException e) { // Captura a exceção específica para arquivo não encontrado
            System.out.println("Erro: O arquivo não foi encontrado. " + e.getMessage());
        } catch (Exception e) { // Captura outras possíveis exceções de I/O
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        } finally {
            // Garante que o Scanner seja fechado, liberando os recursos do sistema.
            // Esta é uma boa prática para evitar vazamento de recursos.
            if (teclado != null) {
                teclado.close();
            }
        }
    }

    }

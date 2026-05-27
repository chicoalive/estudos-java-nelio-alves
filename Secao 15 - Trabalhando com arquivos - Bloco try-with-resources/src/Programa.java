import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Programa {
    public static void main(String[] args) {
        // Define o caminho do arquivo a ser lido.
        String caminho = "C:\\Users\\chico\\Downloads\\dentro.txt";

        // O bloco try-with-resources garante que os recursos (FileReader e BufferedReader) sejam fechados automaticamente ao final do bloco, mesmo que ocorram exceções.
        // FileReader: Abre o arquivo para leitura de caracteres. BufferedReader: Otimiza a leitura, permitindo ler o arquivo linha por linha.
        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
            // Lê a primeira linha do arquivo.
            String linha = br.readLine();
            // Continua lendo e imprimindo linhas até o final do arquivo (quando readLine() retorna null).
            while (linha != null) {
                System.out.println(linha);
                linha = br.readLine();
            }
        } catch (IOException e) {
            // Captura e imprime qualquer erro de I/O que possa ocorrer durante a leitura do arquivo.
            System.out.println("Erro: " + e.getMessage());
        }
    }
}

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException; // Importa IOException para tratamento de erros de I/O

public class Programa {
    public static void main(String[] args) {
        // Array de strings contendo as linhas a serem escritas no arquivo
        String[] lines = new String[]{"Good Morning", "Good Afternoon", "Good Night"};
        
        // Define o caminho completo e o nome do arquivo de saída
        String path = "C:\\Users\\chico\\Downloads\\fora.txt";

        // Utiliza try-with-resources para garantir que o BufferedWriter seja fechado automaticamente
        // Se colocamos true no FileWriter, ele sobreescreve o arquivo
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            // Itera sobre o array de strings
            for (String line : lines) {
                // Escreve cada linha no arquivo
                bw.write(line);
                // Adiciona uma nova linha após cada string para que elas não fiquem na mesma linha
                bw.newLine(); 
            }
        } catch (IOException e) { // Captura exceções de I/O que podem ocorrer durante a escrita do arquivo
            // Exibe uma mensagem de erro no console padrão de erro
            System.err.println("Erro ao escrever no arquivo: " + e.getMessage()); 
        }
    }
}

package application;

import model.entities.Componentes;
import model.services.QualidadeServico;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Programa {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        List<Componentes> listaDeComponentes = new ArrayList<>();

        System.out.print("Quantos componentes serão processados: ");
        int qtd = Integer.parseInt(teclado.nextLine().trim());

        // loop para adicionar componentes na lista
        for (int i = 0; i < qtd; i++) {
            System.out.println("Dados do " + (i + 1) + "º componente");
            System.out.print("Tipo de componente: ");
            String nome = teclado.nextLine().trim();
            System.out.print("Nivel de desgaste: ");
            Double nivelDesgaste = Double.parseDouble(teclado.nextLine().trim());
            System.out.print("Custo de fabricacao: ");
            Double custoDeFabricacao = Double.parseDouble(teclado.nextLine().trim());
            // Assim já adicono e estacio
            listaDeComponentes.add(new Componentes(nome, nivelDesgaste, custoDeFabricacao));
            System.out.println();
        }

        // Predicate: Define uma regra de filtro.
        // Para cada componente 'c', retorna verdadeiro se o nível de desgaste for maior que 0.5.
        Predicate<Componentes> critico = c -> c.getNivelDesgaste() > 0.5;

        // Consumer: Define uma ação a ser executada.
        // Para cada componente 'c', define o nome para "ALERTA: " mais o nome atual.
        Consumer<Componentes> alerta = c -> c.setNome("ALERTA: " + c.getNome());

        // Function: Define uma transformação de um tipo para outro.
        // Para cada componente 'c', calcula e retorna 80% do seu custo de fabricação.
        Function<Componentes, Double> prejuizo = c -> c.getCustoDeFabricacao() * 0.8;

        // Consumer: Define outra ação a ser executada.
        // Para cada prejuízo 'p' (que é um Double), imprime a mensagem formatada.
        Consumer<Double> relatorioPrejuizo = p -> System.out.println("Prejuízo crítico: R$ " + String.format("%.2f", p));

        // Instancia o serviço de qualidade
        QualidadeServico servico = new QualidadeServico();

        System.out.println("--- INICIANDO INSPEÇÃO ---");
        // Chama o método para processar o lote, passando a lista e as operações lambda.
        servico.processarLote(listaDeComponentes, critico, alerta, prejuizo, relatorioPrejuizo);

        System.out.println("\n--- ESTADO FINAL DO LOTE ---");
        // Exibe o estado final da lista de componentes após o processamento.
        for (Componentes c : listaDeComponentes) {
            System.out.println("Produto: " + c.getNome() + ", Desgaste: " + String.format("%.1f", c.getNivelDesgaste()) + ", Custo: " + String.format("%.2f", c.getCustoDeFabricacao()));
        }

        teclado.close();
    }
}

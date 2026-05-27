package aplicacao;

import entidades.Produto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate; // Importando Predicate para a demonstração da lambda declarada

public class Programa {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Digite o caminho do arquivo: ");
        String caminho = teclado.nextLine().trim();

        // Criando lista de produtos
        List<Produto> listaProdutos = new ArrayList<>();
        // Lendo o arquivo
        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
            // Criando linha
            String linha = br.readLine();
            while (linha != null) {
                String[] campos = linha.split(" ");
                String nome = campos[0];
                double preco = Double.parseDouble(campos[1]);
                Produto produto = new Produto(nome, preco);
                // Pulando linha
                linha = br.readLine();
                // Adicionando produto na lista
                listaProdutos.add(produto);
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo" + e.getMessage());
        }

        System.out.println();
        System.out.print("Deseja remover os produtos com preço menor que: ");
        Double minimo = Double.parseDouble(teclado.nextLine().trim());

        /*
         * LAMBDA COM EXPRESSÕES - A FORMA MAIS EXPLÍCITA E DIDÁTICA
         *
         * ANÁLISE DA EXPRESSÃO LAMBDA:
         *
         * listaProdutos.removeIf(p -> p.getPreco() < minimo);
         *
         * COMPONENTES DA LAMBDA:
         * 1. 'p ->' : Parâmetro da função (cada Produto da lista)
         * 2. 'p.getPreco()' : Acessa o preço do produto atual
         * 3. '< minimo' : Compara com o valor mínimo digitado pelo usuário
         * 4. 'removeIf()' : Método que remove elementos onde a lambda retorna true
         *
         * EVOLUÇÃO DAS ABORDAGENS:
         * 1. CLASSE SEPARADA: new ProdutoPredicate() - verboso mas estruturado
         * 2. MÉTODO ESTÁTICO: Produto::staticPredicate - conciso mas precisa de parâmetro
         * 3. MÉTODO NÃO ESTÁTICO: Produto::naoEstaticoPredicate - elegante e OO
         * 4. LAMBDA DECLARADA (VARIÁVEL): Predicate<Produto> pred = p -> p.getPreco() < minimo;
         *    - A lambda é atribuída a uma variável de interface funcional.
         *    - Uso: listaProdutos.removeIf(pred);
         * 5. LAMBDA INLINE: p -> p.getPreco() < minimo - mais direto e flexível
         *
         * VANTAGENS DA LAMBDA INLINE:
         * - Não precisa criar método ou classe adicional
         * - Pode usar variáveis locais (minimo) diretamente
         * - Mais fácil de entender para lógica simples
         * - Flexível para condições complexas
         *
         * O QUE ACONTECE AQUI:
         * - Para cada Produto 'p' na lista
         * - Se p.getPreco() < minimo for true
         * - O Produto INTEIRO é removido da lista
         * - Não remove apenas o preço, remove o objeto completo
         */
        listaProdutos.removeIf(p -> p.getPreco() < minimo);

        listaProdutos.forEach(System.out::println);

/*
 * POR QUE USAMOS ASSIM AGORA? - LAMBDA INLINE COMO ESCOLHA FINAL
 *
 * ANÁLISE DAS 5 ABORDAGENS E SUAS CARACTERÍSTICAS:
 *
 * 1. CLASSE SEPARADA (ProdutoPredicate):
 *    PRÓS: Reutilizável, encapsulada, boa para lógica complexa
 *    CONTRAS: Verbosa, precisa de arquivo extra, overhead desnecessário
 *
 * 2. MÉTODO ESTÁTICO (Produto::staticPredicate):
 *    PRÓS: Method reference, reutilizável, mais conciso que classe
 *    CONTRAS: Precisa passar parâmetro, menos flexível que lambda
 *
 * 3. MÉTODO NÃO ESTÁTICO (Produto::naoEstaticoPredicate):
 *    PRÓS: Mais OO, elegante, method reference
 *    CONTRAS: Fixo (valor 100.0), não usa variável local 'minimo'
 *
 * 4. LAMBDA DECLARADA (VARIÁVEL):
 *    PRÓS: Reutilizável (se a variável for acessível), legibilidade para lambdas complexas.
 *    CONTRAS: Adiciona uma linha de código para a declaração da variável.
 *
 * 5. LAMBDA INLINE (p -> p.getPreco() < minimo) - ESCOLHA ATUAL:
 *    PRÓS:
 *    - Usa variável local 'minimo' diretamente
 *    - Flexível para qualquer condição
 *    - Não precisa criar classes ou métodos adicionais
 *    - Mais direto e legível para lógica simples
 *    - Ideal para condições dinâmicas (usuário digita valor)
 *
 *    CONTRAS:
 *    - Menos reutilizável (só neste contexto)
 *    - Verboso para lógica muito complexa
 *
 * CONCLUSÃO:
 * Para este caso específico - onde o usuário digita um valor mínimo dinâmico
 * e precisamos de uma condição simples - a lambda inline é a melhor escolha.
 * Ela combina flexibilidade, simplicidade e clareza sem overhead desnecessário.
 */

        teclado.close();
    }
}

package aplicacao;

import entidades.Produto;
import util.AumentarPreco;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

public class Programa {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        List<Produto> listaProdutos = new ArrayList<>();
        System.out.println("Dados do produto ");
        System.out.print("Quantidade de produtos: ");
        int qtdProd = Integer.parseInt(teclado.nextLine().trim());
        for (int i = 1; i <= qtdProd; i++) {
            System.out.println("Produto #" + i);
            System.out.print("Nome produto: ");
            String nome = teclado.nextLine().trim();
            System.out.print("Preço: ");
            Double preco = Double.parseDouble(teclado.nextLine().trim());
            Produto produto = new Produto(nome, preco);
            listaProdutos.add(produto);
            System.out.println();
        }
        System.out.print("Digite a porcentagem de aumento: ");
        double porcentagemAumento = Double.parseDouble(teclado.nextLine().trim());
        /*
         * ===================================================================
         * EVOLUÇÃO COMPLETA DAS ABORDAGENS forEach COM Consumer
         * ===================================================================
         * 
         * ABORDAGEM 1 - Classe Separada (Consumer tradicional):
         * Criamos classe "AumentarPreco" implementando Consumer<Produto>
         * Código: listaProdutos.forEach(new AumentarPreco());
         * 
         * ABORDAGEM 2 - Method Reference Estático:
         * Método estático na classe Produto
         * Código: listaProdutos.forEach(Produto::staticModificarPreco);
         * 
         * ABORDAGEM 3 - Method Reference de Instância:
         * Método de instância que opera nos próprios atributos
         * Código: listaProdutos.forEach(Produto::naoStaticModificarPreco);
         * 
         * ABORDAGEM 4 - Lambda Armazenada em Variável:
         * Expressão lambda armazenada em variável Consumer<Produto>
         * Código: Consumer<Produto> aumentarPreco = p -> { ... };
         *        listaProdutos.forEach(aumentarPreco);
         * 
         * ABORDAGEM 5 - Lambda Inline (FINAL - escolhida):
         * Expressão lambda diretamente no forEach
         * Código: listaProdutos.forEach(produto -> produto.setPreco(...));
         * 
         * ===================================================================
         * POR QUE A ABORDAGEM 5 (Lambda Inline) FOI ESCOLHIDA:
         * ===================================================================
         * 
         * 1. FLEXIBILIDADE: Permite usar variáveis externas (porcentagemAumento)
         * 2. CONCISÃO: Código em uma única linha, sem variáveis intermediárias
         * 3. LEGIBILIDADE: Lógica visível diretamente onde é usada
         * 4. DINAMISMO: Porcentagem pode ser digitada pelo usuário em tempo de execução
         * 5. PADRÃO MODERNO: Forma mais comum de usar forEach com lógica customizada
         * 
         * ===================================================================
         * COMPARAÇÃO: Lambda Armazenada vs Lambda Inline
         * ===================================================================
         * 
         * Lambda Armazenada (ABORDAGEM 4):
         * Consumer<Produto> aumentarPreco = p -> {
         *     p.setPreco(p.getPreco() + porcentagemAumento);
         * };
         * listaProdutos.forEach(aumentarPreco);
         * 
         * Vantagens: Reutilizável, nome descritivo, separa declaração do uso
         * Desvantagens: Verboso, precisa criar variável, menos direto
         * 
         * Lambda Inline (ABORDAGEM 5 - FINAL):
         * listaProdutos.forEach(produto -> 
         *     produto.setPreco(produto.getPreco() + produto.getPreco()));
         * 
         * Vantagens: Conciso, direto, lógica visível, moderno
         * Desvantagens: Não reutilizável, pode ficar longo se lógica for complexa
         */
        
        // Abordagem 4: Lambda armazenada em variável
        // Consumer<Produto> aumentarPreco = p -> {
        //     p.setPreco(p.getPreco() + porcentagemAumento);
        // };
        // listaProdutos.forEach(aumentarPreco);
        
        // Abordagem 3: Method reference de instância (mantida para demonstração)
        // listaProdutos.forEach(Produto::naoStaticModificarPreco);
        
        // Abordagem 5: Lambda inline (FINAL - escolhida para estudo)
        // listaProdutos.forEach(produto ->  
        //     produto.setPreco(produto.getPreco() + produto.getPreco()));
        /*
         * ===================================================================
         * EXPRESSÃO LAMBDA PARA AUMENTO DE PREÇO COM PORCENTAGEM
         * ===================================================================
         * 
         * Usuário digita a porcentagem de aumento (ex: 10 = 10%)
         * Expressão lambda calcula: preco + (preco * porcentagem / 100)
         * 
         * Fórmula: novoPreco = precoAtual * (1 + porcentagem / 100)
         * 
         * Exemplo: preco 100, porcentagem 10%
         * 100 * (1 + 10/100) = 100 * 1.1 = 110
         */
        listaProdutos.forEach(produto -> 
            produto.setPreco(produto.getPreco() * (1 + porcentagemAumento / 100)));
        
        /*
         * ===================================================================
         * EXIBIÇÃO DOS RESULTADOS - System.out::println
         * ===================================================================
         * 
         * Usando method reference para exibir todos os produtos
         * com os preços já atualizados
         */
        listaProdutos.forEach(System.out::println);

        teclado.close();


    }
}

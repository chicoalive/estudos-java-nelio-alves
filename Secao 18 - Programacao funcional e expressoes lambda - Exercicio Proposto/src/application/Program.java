// Por que criamos: Programa principal para testar programação funcional
package application;

import model.etities.Product;
import model.service.ProductService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Aplicação que demonstra uso de interfaces funcionais
public class Program {
    static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        List<Product> listProduct = new ArrayList<>();
        ProductService productService = new ProductService();
        System.out.println("Chico Alive Store");
        System.out.print("Quantos produtos serão cadastrados: ");
        int qtd = Integer.parseInt(teclado.nextLine().trim());
        System.out.println();
        for (int i = 0; i < qtd; i++) {
            System.out.println("Dados do " + (i + 1) + "º produto: ");
            System.out.print("Nome: ");
            String nameProduct = teclado.nextLine().trim();
            System.out.print("Preço: ");
            double priceProduct = Double.parseDouble(teclado.nextLine().trim());
            listProduct.add(new Product(nameProduct, priceProduct));
        }

        System.out.println("-------- RELATÓRIO DE PRODUTOS --------");

        // Como estamos fazendo: processProduct modifica a lista primeiro
        // 1. Filtra produtos com nome começando 'T'
        // 2. Aumenta 10% no preço desses produtos
        // 3. Exibe os nomes em caixa alta dos produtos modificados
        productService.processProduct(listProduct, 
            p -> p.getNameProduct().charAt(0) == 'T',  // Predicate: filtro por 'T'
            p -> p.setPriceProduct(p.getPriceProduct() * 1.10),  // Consumer<T>: aumenta 10%
            Product::getNameProduct,                     // Function: extrai nome
            nome -> System.out.println(nome.toUpperCase())  // Consumer<R>: exibe em caixa alta
        );
        
        // Exibe a lista completa atualizada primeiro
        System.out.println("\nLista atualizada (com 10% a mais nos produtos com 'T'):");
        listProduct.forEach(System.out::println);
        
        // Agora exibe os nomes em caixa alta
        System.out.println("\nNomes em caixa alta (segunda chamada, apenas exibindo):");
        productService.processProduct(listProduct, 
            p -> p.getNameProduct().charAt(0) == 'T',  // Predicate: filtro por 'T'
            p -> {},  // Consumer<T>: vazio (já modificou)
            Product::getNameProduct,                     // Function: extrai nome
            nome -> System.out.println(nome.toUpperCase()) // Consumer<R>: exibe em caixa alta
        );

        teclado.close();
    }
}

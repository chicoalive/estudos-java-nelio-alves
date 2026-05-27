package aplicacao;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import entidades.Produto;
import util.NomeCaixaAlta;

public class Programa {

	public static void main(String[] args) {

		List<Produto> lista = new ArrayList<>();

		lista.add(new Produto("Tv", 900.00));
		lista.add(new Produto("Mouse", 50.00));
		lista.add(new Produto("Tablet", 350.50));
		lista.add(new Produto("HD Case", 80.90));

		// Demonstração de diferentes formas de usar a interface funcional Function
		// para transformar o nome do produto em maiúsculas.

		// 1. Usando uma classe que implementa a interface Function (NomeCaixaAlta)
		// Aqui, passamos uma instância da classe NomeCaixaAlta para o método map.
		// List<String> nomes1 = lista.stream().map(new NomeCaixaAlta()).collect(Collectors.toList());
		// nomes1.forEach(System.out::println);
		// System.out.println("--------------------");

		// 2. Usando Method Reference estático (Produto::nomeEmCaixaAltaEstatico)
		// O método estático 'nomeEmCaixaAltaEstatico' da classe Produto é referenciado.
		// Ele recebe um Produto e retorna uma String.
		// List<String> nomes2 = lista.stream().map(Produto::nomeEmCaixaAltaEstatico).collect(Collectors.toList());
		// nomes2.forEach(System.out::println);
		// System.out.println("--------------------");

		// 3. Usando Method Reference não estático (Produto::nomeEmCaixaAltaNaoEstatico)
		// O método não estático 'nomeEmCaixaAltaNaoEstatico' da classe Produto é referenciado.
		// Para cada objeto Produto na stream, este método é invocado.
		// List<String> nomes3 = lista.stream().map(Produto::nomeEmCaixaAltaNaoEstatico).collect(Collectors.toList());
		// nomes3.forEach(System.out::println);
		// System.out.println("--------------------");

		// 4. Usando uma expressão lambda declarada em uma variável (Function<Produto, String> func)
		// A expressão lambda é atribuída a uma variável do tipo Function.
		// Function<Produto, String> func = p -> p.getNome().toUpperCase();
		// List<String> nomes4 = lista.stream().map(func).collect(Collectors.toList());
		// nomes4.forEach(System.out::println);
		// System.out.println("--------------------");

		// 5. Usando uma expressão lambda inline (p -> p.getNome().toUpperCase())
		// Esta é a forma mais concisa e comum para operações simples.
		// A expressão lambda é passada diretamente para o método map.
		List<String> nomes = lista.stream().map(p -> p.getNome().toUpperCase()).collect(Collectors.toList());
		
		nomes.forEach(System.out::println);
	}
}

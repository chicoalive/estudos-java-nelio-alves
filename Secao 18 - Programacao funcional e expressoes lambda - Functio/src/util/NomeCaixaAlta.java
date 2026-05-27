package util;

import java.util.function.Function;

import entidades.Produto;

// Esta classe implementa a interface funcional Function.
// Ela é usada para transformar um objeto Produto em uma String (o nome em maiúsculas).
// Demonstra como usar uma interface funcional de forma explícita.
public class NomeCaixaAlta implements Function<Produto, String> {

	@Override
	public String apply(Produto p) {
		return p.getNome().toUpperCase();
	}
}
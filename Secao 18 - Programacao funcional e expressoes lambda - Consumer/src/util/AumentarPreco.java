package util;

import entidades.Produto;

import java.util.function.Consumer;

/*
 * Consumer<T> é uma interface funcional do pacote java.util.function
 * Representa uma operação que aceita um argumento do tipo T e não retorna resultado
 * Método principal: accept(T t) - executa a operação sobre o argumento
 * 
 * Nesta classe, implementamos Consumer<Produto> para criar uma operação
 * que aumenta o preço de um produto em 10%
 */
public class AumentarPreco implements Consumer<Produto> {
    @Override
    public void accept(Produto produto) {
        // Aplica um aumento de 10% no preço do produto
        produto.setPreco(produto.getPreco() * 1.1);
    }
    // Esta classe foi criada para demonstrar como implementar a interface Consumer
    // e usá-la com o método forEach de coleções
}

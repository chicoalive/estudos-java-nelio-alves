package util;

import entidades.Produto;

import java.util.function.Predicate;

/*
 * POR QUE CRIAMOS A CLASSE ProdutoPredicate?
 * 
 * 1. ABORDAGEM TRADICIONAL - Classe separada implementando Predicate
 * 2. ENCAPSULAMENTO - Lógica de filtro isolada em sua própria classe
 * 3. REUTILIZAÇÃO - Pode ser usada em diferentes partes do código
 * 4. MANUTENÇÃO - Fácil modificar a lógica sem afetar outras classes
 * 5. ESTADO - Pode armazenar valores (se necessário no construtor)
 * 
 * EVOLUÇÃO: 
 * - Começamos com esta abordagem mais verbosa porém estruturada
 * - Depois evoluímos para formas mais concisas (lambda, method reference)
 * - Esta forma é útil para lógica complexa que não cabe em uma linha
 */
public class ProdutoPredicate implements Predicate<Produto> {
    @Override
    public boolean test(Produto produto) {
        return produto.getPreco() >= 100.0;
    }
}

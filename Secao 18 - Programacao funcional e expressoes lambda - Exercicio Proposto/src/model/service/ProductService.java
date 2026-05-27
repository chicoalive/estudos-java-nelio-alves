// Por que criamos: Estudar programação funcional com interfaces funcionais
package model.service;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

// Classe de serviço para processar produtos com programação funcional
public class ProductService {

    // Por que 5 parâmetros: Fluxo completo filtrar→modificar→transformar→executar
    // Predicate: filtra, Consumer<T>: modifica objeto original, Function: transforma, Consumer<R>: executa no resultado
    public <T, R> void processProduct(List<T> list, Predicate<T> filter, Consumer<T> modifier, Function<T, R> mapper, Consumer<R> action) {
        // Por que for-each: Comparar programação tradicional vs funcional
        for (T element : list) {
            // Predicate: retorna true/false para filtrar
            if (filter.test(element)) {
                // Consumer<T>: modifica o objeto ORIGINAL (ex: Product → Product com preço +10%)
                // Por que T: Para alterar o objeto antes de transformar
                modifier.accept(element);
                // Function: converte T em R (ex: Product → String nome)
                R result = mapper.apply(element);
                // Consumer<R>: executa ação no RESULTADO TRANSFORMADO (ex: String → exibir em caixa alta)
                // Por que R: Para operar no tipo já transformado, não no original
                action.accept(result);
            }
        }
    }
}
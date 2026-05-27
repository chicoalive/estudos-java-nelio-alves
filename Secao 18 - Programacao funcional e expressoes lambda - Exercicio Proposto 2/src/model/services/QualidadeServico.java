package model.services;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

// Classe chamada QualidadeServico
public class QualidadeServico {

    // Método público que não retorna nada (void)
    // É genérico, pode trabalhar com qualquer tipo T e R
    // O método se chama processarLote
    // Recebe cinco parâmetros:
    //   1. lista - uma lista de qualquer coisa (tipo T)
    //   2. filtro - uma regra que retorna verdadeiro ou falso para um elemento T
    //   3. manuntecao - uma ação que faz algo com um elemento T mas não retorna nada
    //   4. calculador - uma função que pega um elemento T e transforma em um resultado R
    //   5. relatorio - uma ação que faz algo com um resultado R mas não retorna nada
    // 
    // O que é T e R?
    // T = Tipo de entrada (pode ser Produto, String, Integer, qualquer coisa)
    // R = Tipo de resultado (pode ser Double, String, Boolean, qualquer coisa que a função retornar)
    // Exemplo: se T é Produto e R é Double, então a função pega um Produto e devolve um Double
    public <T, R> void processarLote(List<T> lista, Predicate<T> filtro, Consumer<T> manuntecao, Function<T, R> calculador, Consumer<R> relatorio) {
        // Para cada elemento dentro da lista, faça:
        for (T elemento : lista) {
            // Se o filtro disser que este elemento passa no teste (retornar verdadeiro), então:
            if (filtro.test(elemento)) {
                // Execute a ação de manutenção neste elemento
                // A ação de manutenção faz algo com o elemento, mas não retorna valor
                manuntecao.accept(elemento);
                
                // Pegue o elemento e aplique a função de cálculo
                // A função pega o elemento T e devolve um resultado do tipo R
                // Guarde esse resultado na variável chamada resultado
                R resultado = calculador.apply(elemento);
                
                // Execute a ação de relatório usando o resultado que foi calculado
                // O relatório faz algo com o resultado, mas não retorna valor
                relatorio.accept(resultado);
            }
        }
    }
}

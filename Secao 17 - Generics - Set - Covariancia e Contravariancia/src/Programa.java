import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Demonstração de Generics com covariancia e contravariancia
public class Programa {
    
    // Método principal - cria listas e demonstra cópia entre tipos diferentes
    public static void main(String[] args) {
        List<Integer> meusInteiros = Arrays.asList(1, 2, 3, 4);  // cria lista de inteiros
        List<Double> meusDoubles = Arrays.asList(3.14, 6.28, 7.45);  // cria lista de doubles
        List<Object> meusObjetos = new ArrayList<Object>();  // cria lista vazia de Objects

        copiar(meusInteiros, meusObjetos);  // copia inteiros para Objects
        imprimirLista(meusObjetos);  // imprime lista após primeira cópia
        copiar(meusDoubles, meusObjetos);  // copia doubles para mesma lista
        imprimirLista(meusObjetos);  // imprime lista final
    }

    // Copia elementos de lista que estende Number para lista que aceita Number
    // Usa ? extends (covariancia) e ? super (contravariancia)
    public static void copiar(List<? extends Number> origem, List<? super Number> destino) {
        for (Number number : origem) {  // percorre elementos da origem
            destino.add(number);  // adiciona cada elemento ao destino
        }
    }

    // Imprime qualquer tipo de lista (apenas leitura)
    // Usa ? (coringa simples) para aceitar qualquer tipo
    public static void imprimirLista(List<?> lista) {
        for (Object x : lista) {  // percorre cada objeto
            System.out.println("Objeto:" + x);  // imprime objeto
        }
        System.out.println();  // linha em branco
    }
}

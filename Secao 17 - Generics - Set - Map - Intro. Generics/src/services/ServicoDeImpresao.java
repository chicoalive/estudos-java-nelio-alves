package services;

import java.util.ArrayList;
import java.util.List;

// Define a classe para aceitar um tipo genérico, que foi nomeado como 'Generico'.
public class ServicoDeImpresao<T> {

    // Cria uma lista que armazenará elementos do tipo 'Generico'.
    private List<T> lista = new ArrayList<>();

    // Adiciona um valor à lista.
    public void addValor(T valor) {
        lista.add(valor);
    }

    // Retorna o primeiro elemento da lista.
    public T primeiro() {
        // Lança uma exceção se a lista estiver vazia.
        if (lista.isEmpty()) {
            throw new IllegalArgumentException("Lista vazia");
        }
        return lista.get(0);
    }

    // Imprime os elementos da lista, com uma formatação específica.
    public void imprimir() {
        System.out.print("[");
        // Se a lista não estiver vazia, imprime o primeiro elemento em uma nova linha.
        if (!lista.isEmpty()) {
            System.out.print(lista.get(0));
        }
        // Itera a partir do segundo elemento e imprime cada um em uma nova linha.
        for (int i = 1; i < lista.size(); i++) {
            System.out.print(", " + lista.get(i));
        }
        System.out.print("]");
    }


}

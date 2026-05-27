package model.service;

import model.entities.Book;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class BookBusiness {

    // Mapa para armazenar os livros, usando o título como chave.
    public Map<Book, Book> listaLivros = new TreeMap<>();

    // Adiciona livros a partir de um arquivo.
    // Se um livro já existir no mapa, atualiza o valor da multa.
    // Caso contrário, cria um novo livro e o adiciona ao mapa.
    public void addBook(String path) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String linha = br.readLine();
            while (linha != null) {
                String[] campos = linha.split(",");
                String tituloLivro = campos[0];
                Integer quantidadeEmprestimos = Integer.parseInt(campos[1]);
                Double valorMulta = Double.parseDouble(campos[2]);
                Book livroAtual = new Book(tituloLivro, quantidadeEmprestimos, valorMulta);
                // Verifica se o livro já existe no mapa.
                if (listaLivros.containsKey(livroAtual)) {
                    // Pega o objeto livro existente.
                    Book livroGuardado = listaLivros.get(livroAtual);
                    // Soma o valor da nova multa com a multa existente.
                    Double multaTotal = livroGuardado.getValorMulta() + valorMulta;
                    // Atualiza o valor da multa no objeto livro.
                    livroGuardado.setValorMulta(multaTotal);
                    // Atualizando a quantidade de emprestimos
                    Integer quantidadeEmprestimosTotal = livroGuardado.getQuantidadeEmprestimos() + quantidadeEmprestimos;
                    // Atualiza o valor da quantidade de emprestimos no objeto livro.
                    livroGuardado.setQuantidadeEmprestimos(quantidadeEmprestimosTotal);

                } else {
                    // Se o livro não existir, um novo é criado e adicionado ao mapa.
                    listaLivros.put(livroAtual, livroAtual);
                }
                linha = br.readLine();
            }

        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo." + e.getMessage());

        }
    }

    // Remove um livro do mapa com base no título.
    public void removeBook(String titulo) {
       Book chaveParaRemover = new Book(titulo, 0, 0.0);
       listaLivros.remove(chaveParaRemover);
    }
}

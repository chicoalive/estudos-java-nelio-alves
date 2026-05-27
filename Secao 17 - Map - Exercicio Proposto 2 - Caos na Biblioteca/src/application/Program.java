package application;

import model.entities.Book;
import model.service.BookBusiness;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Sistema de controle de livros");
        System.out.print("Digite o caminho onde se encontra o arquivo: ");
        String caminho = teclado.nextLine();
        BookBusiness bookBusiness = new BookBusiness();
        bookBusiness.addBook(caminho);
        System.out.println("Lista de livros");
        for (Book livro : bookBusiness.listaLivros.values()) {
            System.out.println(livro.toString());
        }

        teclado.close();
    }
}

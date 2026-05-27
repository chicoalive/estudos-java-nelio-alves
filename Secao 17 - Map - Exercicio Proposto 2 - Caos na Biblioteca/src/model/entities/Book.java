package model.entities;

import java.util.Objects;

public class Book implements Comparable<Book> {
    private String titulo;
    private Integer quantidadeEmprestimos;
    private Double valorMulta;

    public Book(String titulo, Integer quantidadeEmprestimos, Double valorMulta) {
        this.titulo = titulo;
        this.quantidadeEmprestimos = quantidadeEmprestimos;
        this.valorMulta = valorMulta;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getQuantidadeEmprestimos() {
        return quantidadeEmprestimos;
    }

    public void setQuantidadeEmprestimos(Integer quantidadeEmprestimos) {
        this.quantidadeEmprestimos = quantidadeEmprestimos;
    }

    public Double getValorMulta() {
        return valorMulta;
    }

    public void setValorMulta(Double valorMulta) {
        this.valorMulta = valorMulta;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Book book)) return false;
        return Objects.equals(titulo, book.titulo);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(titulo);
    }

    // Ensinando a classe a comparação
    public int compareTo(Book other) {
        return this.titulo.toUpperCase().compareTo(other.getTitulo().toUpperCase());
    }

    @Override
    public String toString() {
        return "Titulo: "+titulo+"\n"
                +"Quantidade de emprestimos: "+quantidadeEmprestimos+"\n"
                +"Valor da multa: "+String.format("%.2f", valorMulta)+"\n";
    }
}

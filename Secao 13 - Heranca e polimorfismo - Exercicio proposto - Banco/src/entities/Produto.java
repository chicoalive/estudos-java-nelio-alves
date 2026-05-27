package entities;

import java.text.ParseException;

public class Produto {
    // Attributes
    private String nome;
    private Double preco;

    // Constructor
    public Produto(String nome, Double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    // Getter and Setter
    public String getNome() {
        return nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    // Methods
    public String precoTag() throws ParseException {
        String retorno = "Produto: " + nome + " - Preço R$ " + String.format("%.2f", preco);
        return retorno;
    }

}

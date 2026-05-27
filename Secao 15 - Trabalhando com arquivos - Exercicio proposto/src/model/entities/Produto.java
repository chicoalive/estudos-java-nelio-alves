package model.entities;

public class Produto {
    // Attributes
    private String nomeProduto;
    private Double precoProduto;
    private Integer qtdProduto;


    // Constructor

    public Produto() {
    }

    public Produto(String nomeProduto, Double preco, Integer qtdProduto) {
        this.nomeProduto = nomeProduto;
        this.precoProduto = preco;
        this.qtdProduto = qtdProduto;
    }

    // Getters and Setters
    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public Double getPrecoProduto() {
        return precoProduto;
    }

    public void setPrecoProduto(Double precoProduto) {
        this.precoProduto = precoProduto;
    }

    public Integer getQtdProduto() {
        return qtdProduto;
    }

    public void setQtdProduto(Integer qtdProduto) {
        this.qtdProduto = qtdProduto;
    }

    // Methods
    public Double valorTotal() {
        return precoProduto * qtdProduto;
    }

    @Override
    public String toString() {
        return "Produto: " + nomeProduto + "\n"
                + "Preço unitário," + String.format("%.2f", precoProduto) + "\n"
                + "Quantidade," + qtdProduto + "\n";

    }
}

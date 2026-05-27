package entities;

public class ProdutoImportado extends Produto {
    // Attributes
    private Double taxaDeImportacao;

    // Constructor
    public ProdutoImportado(String nome, Double preco, Double taxaDeImportacao) {
        super(nome, preco);
        this.taxaDeImportacao = taxaDeImportacao;
    }

    // Getter and Setter
    public Double getTaxaDeImportacao() {
        return taxaDeImportacao;
    }

    public void setTaxaDeImportacao(Double taxaDeImportacao) {
        this.taxaDeImportacao = taxaDeImportacao;
    }

    // Methods
    public Double precoTotal() {
        return getPreco() + taxaDeImportacao;
    }

    @Override
    public String precoTag() {
        String retorno = getNome() + " R$ "
                + String.format("%.2f", precoTotal())
                + " (Taxa de Importação R$ "
                + String.format("%.2f )", taxaDeImportacao);
        return retorno;
    }


}

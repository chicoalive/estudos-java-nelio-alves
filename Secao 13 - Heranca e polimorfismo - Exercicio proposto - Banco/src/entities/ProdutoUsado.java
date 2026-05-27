package entities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ProdutoUsado extends Produto {
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    // Attributes
    private final Date dataDeFabricacao;

    // Constructor
    public ProdutoUsado(String nome, Double preco, Date dataDeFabricacao) {
        super(nome, preco);
        this.dataDeFabricacao = dataDeFabricacao;
    }

    // Getter and Setter
    public Date getDataDeFabricacao() {
        return dataDeFabricacao;
    }

    // Methods
    @Override
    public String precoTag() throws ParseException {
        return getNome() + " (usado) R$ "
                + String.format("%.2f", getPreco())
                + sdf.format(dataDeFabricacao);

    }

}

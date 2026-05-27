package modelo.entidades;

public class Fatura {
    // Atributos
    private Double pagamentoBasico;
    private Double taxa;

    // Construtores
    public Fatura() {
    }

    public Fatura(Double pagamentoBasico, Double taxa) {
        this.pagamentoBasico = pagamentoBasico;
        this.taxa = taxa;
    }

    // Getter e Setter

    public Double getPagamentoBasico() {
        return pagamentoBasico;
    }

    public void setPagamentoBasico(Double pagamentoBasico) {
        this.pagamentoBasico = pagamentoBasico;
    }

    public Double getTaxa() {
        return taxa;
    }

    public void setTaxa(Double taxa) {
        this.taxa = taxa;
    }

    // Métodos
    // Usamos "get" apenas como convenção de nome para indicar um retorno mais claro no código
    public Double getPagamentoTotal() {
        return pagamentoBasico + taxa;
    }

    @Override
    public String toString() {
        return "Fatura:"
                + "\n" + "Pagamento basico: " + String.format("%.2f", getPagamentoBasico())
                + "\n" + "Taxa: " +  String.format("%.2f",getTaxa())
                + "\n" + "Pagamento total: " +  String.format("%.2f",getPagamentoTotal());
    }
}

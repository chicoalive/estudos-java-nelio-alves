package modelo.entidades;

import java.time.LocalDateTime;

public class AluguelDeCarro {
    // Atributos
    private LocalDateTime inicio;
    private LocalDateTime fim;
    private Veiculo veiculo;
    private Fatura fatura;

    // Construtores

    public AluguelDeCarro() {
    }

    // O atributo Fatura não entra no construtor, pois é gerado apenas no fim do processo.
    public AluguelDeCarro(LocalDateTime inicio, LocalDateTime fim, Veiculo veiculo) {
        this.inicio = inicio;
        this.fim = fim;
        this.veiculo = veiculo;
    }
    // Getter e Setter

    public LocalDateTime getInicio() {
        return inicio;
    }

    public void setInicio(LocalDateTime inicio) {
        this.inicio = inicio;
    }

    public LocalDateTime getFim() {
        return fim;
    }

    public void setFim(LocalDateTime fim) {
        this.fim = fim;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Fatura getFatura() {
        return fatura;
    }

    public void setFatura(Fatura fatura) {
        this.fatura = fatura;
    }


    // Métodos

}

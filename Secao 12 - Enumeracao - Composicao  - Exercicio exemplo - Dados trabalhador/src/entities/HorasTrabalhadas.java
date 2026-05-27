package entities;

import java.util.Date;

public class HorasTrabalhadas {
    private Date data;
    private Double valorHora;
    private Integer horas;

    // Construtor
    public HorasTrabalhadas(Date data, Double valorHora, Integer horas) {
        this.data = data;
        this.valorHora = valorHora;
        this.horas = horas;
    }

    // Getter e Setter
    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Double getValorHora() {
        return valorHora;
    }

    public void setValorHora(Double valorHora) {
        this.valorHora = valorHora;
    }

    public Integer getHoras() {
        return horas;
    }

    public void setHoras(Integer horas) {
        this.horas = horas;
    }

    // Métodos
    public Double valorTotal() {
        return valorHora*horas;
    }
}

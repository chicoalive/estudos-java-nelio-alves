package entities;

import entities.enums.NivelTrabalhador;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Trabalhador {
    // Associações simples
    private Departamento departamento;

    private String nome;

    // Associações simples
    private NivelTrabalhador nivelTrabalhador;

    private Double salarioBase;

    // Composição
    List<HorasTrabalhadas> listaHorasTrabalhadas = new ArrayList<>();

    // Construtor
    public Trabalhador(Departamento departamento, String nome, NivelTrabalhador nivelTrabalhador, Double salarioBase) {
        this.departamento = departamento;
        this.nome = nome;
        this.nivelTrabalhador = nivelTrabalhador;
        this.salarioBase = salarioBase;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public String getNome() {
        return nome;
    }

    public NivelTrabalhador getNivelTrabalhador() {
        return nivelTrabalhador;
    }

    public Double getSalarioBase() {
        return salarioBase;
    }

    public List<HorasTrabalhadas> getListaHorasTrabalhadas() {
        return listaHorasTrabalhadas;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNivelTrabalhador(NivelTrabalhador nivelTrabalhador) {
        this.nivelTrabalhador = nivelTrabalhador;
    }

    public void setSalarioBase(Double salarioBase) {
        this.salarioBase = salarioBase;
    }

    // Métodos
    public void addContrato(HorasTrabalhadas contrato) {
        listaHorasTrabalhadas.add(contrato);
    }

    public void removeContrato(HorasTrabalhadas contrato) {
        listaHorasTrabalhadas.remove(contrato);
    }

    // Calcula a renda total do trabalhador em um determinado ano e mês
    public double rendaPeriodo(int ano, int mes) {
        double soma = salarioBase;
        // Cria um objeto Calendar para manipular datas
        Calendar cal = Calendar.getInstance();
        for (HorasTrabalhadas contrato : listaHorasTrabalhadas) {
            // Configura o Calendar para a data do contrato atual
            cal.setTime(contrato.getData());
            // Extrai o ano e mês da data do contrato
            int c_ano = cal.get(Calendar.YEAR);
            int c_mes = 1+cal.get(Calendar.MONTH);
            if (ano == c_ano && mes == c_mes) {
                soma += contrato.valorTotal();
            }
        }
        return soma;
    }

}

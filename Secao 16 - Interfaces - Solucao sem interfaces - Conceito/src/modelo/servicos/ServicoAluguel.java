package modelo.servicos;

import modelo.entidades.AluguelDeCarro;
import modelo.entidades.Fatura;

import java.time.Duration;

public class ServicoAluguel {
    // Atributos
    private Double precoPorHora;
    private Double precoPorDia;

    private ServicoImposto servicoImposto;
    // Construtores

    public ServicoAluguel(Double precoPorHora, Double precoPorDia, ServicoImposto servicoImposto) {
        this.precoPorHora = precoPorHora;
        this.precoPorDia = precoPorDia;
        this.servicoImposto = servicoImposto;
    }

    // Getter e Setter
    // Classes de serviço não possuem getters e setters pois seu foco é realizar cálculos, não armazenar dados.
    // Métodos

    public void processarFatura(AluguelDeCarro aluguelDeCarro) {
        // Comparamos a duração entre dois instantes e transformamos em minutos
        double minutos = Duration.between(aluguelDeCarro.getInicio(), aluguelDeCarro.getFim()).toMinutes();
        // Converte minutos em horas
        double horas = minutos / 60.0;

        double pagamentoBasico;

        if (horas <= 12.0) {
            pagamentoBasico = precoPorHora * Math.ceil(horas); // Arredondamento para cima
        } else {
            pagamentoBasico = precoPorDia * Math.ceil(horas / 24.0);
        }

        double valorTaxa = servicoImposto.taxa(pagamentoBasico);

        aluguelDeCarro.setFatura(new Fatura(pagamentoBasico, valorTaxa));

    }


}

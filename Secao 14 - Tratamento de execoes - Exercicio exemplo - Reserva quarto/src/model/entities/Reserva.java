package model.entities;

import model.exceptions.DominiodeExcecao;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Reserva {

    private Integer numeroDoQuarto;

    // LocalDate (Java 8+): Imutável e API moderna. Mais seguro e claro que o antigo Date.
    private LocalDate dataDeCheckIn;
    private LocalDate dataDeCheckOut;

    // DateTimeFormatter: Thread-safe para formatar datas. Mais seguro que o antigo SimpleDateFormat.
    // 'static' para não recriar o objeto a cada nova reserva.
    private static DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Reserva(Integer numeroDoQuarto, LocalDate dataDeCheckIn, LocalDate dataDeCheckOut) {
        // Validação no construtor: Garante que o objeto já nasce com dados consistentes.
        if (!dataDeCheckOut.isAfter(dataDeCheckIn)) {
            throw new DominiodeExcecao("Erro: Check-out deve ser após o check-in.");
        }
        this.numeroDoQuarto = numeroDoQuarto;
        this.dataDeCheckIn = dataDeCheckIn;
        this.dataDeCheckOut = dataDeCheckOut;
    }

    public Integer getNumeroDoQuarto() {
        return numeroDoQuarto;
    }

    public LocalDate getDataDeCheckIn() {
        return dataDeCheckIn;
    }

    public LocalDate getDataDeCheckOut() {
        return dataDeCheckOut;
    }

    public long duracao() {
        // Calcula o número de dias entre as datas de forma simples e legível.
        return ChronoUnit.DAYS.between(dataDeCheckIn, dataDeCheckOut);
    }

    public void atualizarDatas(LocalDate dataDeCheckIn, LocalDate dataDeCheckOut) {
        LocalDate now = LocalDate.now();
        // Valida se as novas datas são futuras.
        if (dataDeCheckIn.isBefore(now) || dataDeCheckOut.isBefore(now)) {
            throw new DominiodeExcecao("As datas da reserva para atualização devem ser futuras.");
        }
        // Valida se a data de check-out é posterior à de check-in.
        if (!dataDeCheckOut.isAfter(dataDeCheckIn)) {
            throw new DominiodeExcecao("A data de check-out deve ser posterior à de check-in.");
        }
        // Se as validações passarem, atualiza os dados.
        this.dataDeCheckIn = dataDeCheckIn;
        this.dataDeCheckOut = dataDeCheckOut;
    }

    @Override
    public String toString() {
        // Usa o 'formato' para exibir a data como uma String "dd/MM/yyyy".
        return "Quarto: "
                + numeroDoQuarto
                + ", Check-in: "
                + formato.format(dataDeCheckIn)
                + ", Check-out: "
                + formato.format(dataDeCheckOut)
                +", "
                + duracao()
                +" noites";
    }
}

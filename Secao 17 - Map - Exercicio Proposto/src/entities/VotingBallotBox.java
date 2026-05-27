package entities;

import java.util.Objects;

public class VotingBallotBox {
    private String candidato;
    private int votos;

    public VotingBallotBox() {
    }

    public VotingBallotBox(String candidato, int votos) {
        this.candidato = candidato;
        this.votos = votos;
    }

    public String getCandidato() {
        return candidato;
    }

    public void setCandidato(String candidato) {
        this.candidato = candidato;
    }

    public int getVotos() {
        return votos;
    }

    public void setVotos(int votos) {
        this.votos = votos;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof VotingBallotBox that)) return false;
        return Objects.equals(candidato, that.candidato);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(candidato);
    }

    @Override
    public String toString() {
        return "Candidato: " + candidato + " - " + votos + " votos";
    }
}

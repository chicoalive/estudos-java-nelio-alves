package model.entities;

public class Componentes {
    private String nome;
    private Double nivelDesgaste;
    private Double custoDeFabricacao;

    public Componentes(String nome, Double nivelDesgaste, Double custoDeFabricacao) {
        this.nome = nome;
        this.nivelDesgaste = nivelDesgaste;
        this.custoDeFabricacao = custoDeFabricacao;
    }

    public Double getCustoDeFabricacao() {
        return custoDeFabricacao;
    }

    public void setCustoDeFabricacao(Double custoDeFabricacao) {
        this.custoDeFabricacao = custoDeFabricacao;
    }

    public Double getNivelDesgaste() {
        return nivelDesgaste;
    }

    public void setNivelDesgaste(Double nivelDesgaste) {
        this.nivelDesgaste = nivelDesgaste;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Produto: " + nome + ", Desgate: " + String.format("%.2f", nivelDesgaste) + " Custo: " + String.format("%.2f", custoDeFabricacao);
    }
}

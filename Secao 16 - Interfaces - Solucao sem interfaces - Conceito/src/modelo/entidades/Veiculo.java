package modelo.entidades;

public class Veiculo {
    // Atributos
    private String modelo;
    private String placa;

    // Construtores
    public Veiculo() {
    }

    public Veiculo(String modelo, String placa) {
        this.modelo = modelo;
        this.placa = placa;
    }

    // Getter e Setter

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    // Métodos

}

package model.entities;

import model.enums.Cor;

// Como 'Circulo' herda de 'FormaAbstrata', ela recebe o atributo 'cor' e é obrigada a implementar o método 'area()', que foi definido na interface 'Forma'.
public class Circulo extends FormaAbstrata {
    private Double raio;

    public Circulo(Cor cor, double raio) {
        super(cor);
        this.raio = raio;
    }

    public double getRaio() {
        return raio;
    }

    public void setRaio(double raio) {
        this.raio = raio;
    }

    @Override
    public double area() {
        return Math.PI * raio * raio;
    }
}

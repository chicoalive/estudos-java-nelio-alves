package model.entities;

import model.enums.Cor;

// Como 'Retangulo' herda de 'FormaAbstrata', ela recebe o atributo 'cor' e é obrigada a implementar o método 'area()', que foi definido na interface 'Forma'.
public class Retangulo extends FormaAbstrata {
    private Double base;
    private Double altura;

    public Retangulo(Cor cor, double base, double altura) {
        super(cor);
        this.base = base;
        this.altura = altura;
    }

    public Double getBase() {
        return base;
    }

    public void setBase(Double base) {
        this.base = base;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    @Override
    public double area() {
        return base * altura;
    }
}

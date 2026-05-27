package application;

import model.entities.Circulo;
import model.entities.FormaAbstrata;
import model.entities.Retangulo;
import model.enums.Cor;

public class Programa {
    public static void main(String[] args) {

        FormaAbstrata s1 = new Circulo(Cor.PRETO, 2.0);
        FormaAbstrata s2 = new Retangulo(Cor.BRANCO, 3.0, 4.0);

        System.out.println("Cor do circulo: " + s1.getCor());
        System.out.println("Area do circulo: " + String.format("%.2f", s1.area()));
        System.out.println();
        System.out.println("Cor do retangulo: " + s2.getCor());
        System.out.println("Area do retangulo: " + String.format("%.2f", s2.area()));


    }
}

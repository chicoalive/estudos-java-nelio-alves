package entities;

import java.time.LocalDate;

public class RegularStudent extends Student {

    public RegularStudent(String name, LocalDate dateOfBirth, Double baseMonthlyFee, Integer months) {
        super(name, dateOfBirth, baseMonthlyFee, months);
    }

    @Override
    public String toString() {
        return "Nome: " + getName() + " (Regular) " + "\n"
                + "Idade: " + calculateAge() + "\n"
                + "Mensalidade: R$" + String.format("%.2f", finalMonthlyPayment());
    }
}

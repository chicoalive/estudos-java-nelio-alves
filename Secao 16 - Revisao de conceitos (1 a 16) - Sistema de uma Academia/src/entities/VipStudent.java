package entities;

import java.time.LocalDate;

public class VipStudent extends Student {
    public VipStudent(String name, LocalDate dateOfBirth, Double baseMonthlyFee, Integer months) {
        super(name, dateOfBirth, baseMonthlyFee, months);
    }

    // Overriding methods

    // Acréscimo de 30% na mensalidade base do VIP, mantendo a regra de desconto de 10% para mais de 12 meses
    @Override
    public Double finalMonthlyPayment() {
        double MonthlyVip = (getBaseMonthlyFee() + getBaseMonthlyFee() * 0.3);
        if (getMonths() > 12) {
            double discount = MonthlyVip - MonthlyVip * 0.1;
            return discount;
        } else {
            return MonthlyVip;
        }
    }

    @Override
    public String toString() {
        return "Nome: " + getName() + " (VIP) " + "\n"
                + "Idade: " + calculateAge() + "\n"
                + "Mensalidade: R$" + String.format("%.2f", finalMonthlyPayment());

    }
}

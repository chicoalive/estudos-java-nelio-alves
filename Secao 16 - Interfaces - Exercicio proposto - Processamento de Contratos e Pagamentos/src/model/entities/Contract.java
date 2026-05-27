package model.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Contract {

    // Atributos
    private Integer number;
    private LocalDate date;
    private Double totalValue;
    private List<Installment> installments = new ArrayList<>();

    // Construtores
    public Contract(Integer number, LocalDate date, Double totalValue) {
        this.number = number;
        this.date = date;
        this.totalValue = totalValue;
    }

    // Getters e Setters
    public Integer getNumber() {
        return number;
    }

    public LocalDate getDate() {
        return date;
    }

    public Double getTotalValue() {
        return totalValue;
    }

    public List<Installment> getInstallments() {
        return installments;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setTotalValue(Double totalValue) {
        this.totalValue = totalValue;
    }

    // Métodos
    // Adicionar parcelas
    public void addInstallment(Installment installment) {
        installments.add(installment);
    }

    // Remover parcelas
    public void removeInstallment(Installment installment) {
        installments.remove(installment);
    }

    // Exibindo parcelas
    public void printInstallments() {
        for (Installment installment : installments) {
            System.out.println(installment);
        }
    }

}

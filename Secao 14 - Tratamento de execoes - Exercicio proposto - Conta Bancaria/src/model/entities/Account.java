package model.entities;

import model.exceptions.ExceptionDomain;

public class Account {
    // Attributes
    private Integer number;
    private String holder;
    private Double balance;
    private Double withdrawLimit;

    // Constructor


    public Account() {
    }

    public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
        this.number = number;
        this.holder = holder;
        this.balance = balance;
        this.withdrawLimit = withdrawLimit;
    }

    // Getter and Setter
    public Integer getNumber() {
        return number;
    }

    public String getHolder() {
        return holder;
    }

    public Double getBalance() {
        return balance;
    }

    public Double getWithdrawLimit() {
        return withdrawLimit;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    // Methods
    public void deposit(Double amount) {
        balance += amount;
    }

    public void withdraw(Double amount) {
        if (amount>balance) {
            throw new ExceptionDomain("Saldo insuficiente");
        }
        if ((amount > withdrawLimit)) {
            throw new ExceptionDomain("Limite de saque excedido");
        }
        balance -= amount;
    }


    // Return to user

    @Override
    public String toString() {
        return "Conta: " + number + "\n"
                +"Titular: "+holder+"\n"
                +"Novo saldo: "+String.format("%.2f", balance);
    }
}

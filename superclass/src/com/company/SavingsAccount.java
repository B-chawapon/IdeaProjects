package com.company;

public class SavingsAccount extends Account{

    public SavingsAccount() {

    }
    public SavingsAccount(int id, double balance) {
        super(id, balance);
    }

    @Override
    public String toString() {
        return "SavingsAccount{}";
    }
}

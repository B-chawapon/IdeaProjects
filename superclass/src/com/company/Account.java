package com.company;

import java.util.Date;

public class Account {
        private int id=0;
        private  double balance =0;
        private double annualInterestRate =0;
        private final Date dataCreated = new Date();

        Account(){

        }
        Account(int id,double balance)
        {
            this.id=id;
            this.balance=balance;

        }
         public void setID(int id)
        {
            this.id=id;

        }
        public int getID()
        {

            return id;
        }
        public void setBalance(double balance)
        {
            this.balance=balance;

        }
        public double getBalance()
        {

            return balance;
        }

        public void setMonthlyInterestRate(double annualInterestRate){
            this.annualInterestRate=annualInterestRate;

        }
        public double getMonthlyInterestRate(){

            return annualInterestRate/12;
        }

        public double getMonthlyInterest()
        {
            return (balance*(annualInterestRate/12))/100;
        }
        public Date getDataCreated()
        {

            return  dataCreated;
        }

        public void  withDraw(double withdraw)
        {
            if(withdraw<=balance) {
                balance = balance - withdraw;

            }
            else {
                System.out.println("You cant withdraw");
            }

        }
        public double deposit(double deposit) {
            balance = balance + deposit;
            return balance;
        }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", balance=" + balance +
                ", annualInterestRate=" + annualInterestRate +
                ", dataCreated=" + dataCreated +
                '}';
    }
}

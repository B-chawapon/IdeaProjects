package com.company;
import java.util.ArrayList;
import java.util.Date;
import java.lang.String;

public class newAccount2 {
    private String name;
    private int id=0;
    private  double balance =0;
    private double annualInterestRate =0;
    private final Date dataCreated = new Date();
    private ArrayList<Transaction> trans=new ArrayList<Transaction>();
    newAccount2(){

    }
    newAccount2(int id,double balance)
    {
        this.id=id;
        this.balance=balance;

    }

    public newAccount2(String name, int id, double balance) {
        this.name = name;
        this.id = id;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    public void  withDraw(double withdraw,String description)
    {
        if(withdraw<=balance) {
            balance = balance - withdraw;
            trans.add(new Transaction('W',withdraw,balance,description));
        }
        else {
            System.out.println("You cant withdraw");
        }

    }
    public double deposit(double deposit,String description) {
        balance = balance + deposit;
        trans.add(new Transaction('D',deposit,balance,description));
        return balance;
    }

    public ArrayList<Transaction> getTrans() {
        return trans;
    }

    public void transaction(Date day, char type, double amount, double balance, String description){
       trans.add(new Transaction(type,amount,balance,description));

    }
}


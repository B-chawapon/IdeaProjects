package com.company;

public class CheckingAccount extends Account{


    private double overdraftLimit;

    public CheckingAccount(){

    }
    public CheckingAccount(int id, double balance, double overdraftLimit) {
        super(id, balance);
        this.overdraftLimit = overdraftLimit;
    }

    public double getOverdraftLimit() {
        return overdraftLimit;
    }
    public void setOverdraftLimit(double overdraftLimit) {
        this.overdraftLimit = overdraftLimit;
    }



    public void withDraw(double withdraw)
    {
        if(withdraw<=getBalance()+getOverdraftLimit())
        {
            setBalance(getBalance()-withdraw);
        }
        else{
            System.out.println("check You cant withdraw");
        }


    }




    @Override
    public String toString() {
        return "CheckingAccount{" +
                "overdraftLimit=" + overdraftLimit +
                '}';
    }
}

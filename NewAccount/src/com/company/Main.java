package com.company;
import java.util.ArrayList;
public class Main {

    public static void main(String[] args) {
	// write your code here
        newAccount2 ac1 = new newAccount2("George",112,1000);
        System.out.println(ac1.getName());
        System.out.println(ac1.getId());
        System.out.println(ac1.getBalance());
        System.out.println(ac1.getMonthlyInterest());

        ac1.deposit(1000,"");
        ac1.deposit(1000,"");
        ac1.deposit(1000,"");
        ac1.withDraw(1000,"");
        System.out.println("");
        for (int i = 0; i < ac1.getTrans().size();i++)
        {
            System.out.println(ac1.getTrans().get(i).getDataCreated()+" "+ ac1.getTrans().get(i).getType()+" "+ " "+ac1.getTrans().get(i).getBalance());

        }




    }
}

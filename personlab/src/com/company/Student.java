package com.company;

public class Student extends Person{
    final int FRESHMAN =1;
    final int SOPHOMORE=2;
    final int JUNIOR = 3;
    final  int SENIOR = 4;

    private int status;
    public Student(){

    }
    public Student(String name, String address, String phone, String email) {
        super(name, address, phone, email);
    }

    public void setstatus( int status){
        this.status=status;
    }
    public String getstatus(){
        switch(status){
            case 1: return " Freshman";
            case 2: return " sophomore";
            case 3: return " junior";
            case 4: return " senior";
            default: return "UNknown";
        }

    }

    @Override
    public String toString() {
        return "Student{" +getstatus()+
                '}';
    }
}

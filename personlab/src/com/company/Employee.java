package com.company;
import java.util.GregorianCalendar;
public class Employee extends Person{
    private String office;
    private double salary;
    private GregorianCalendar dateHire=new GregorianCalendar();
    public  Employee(){}

    public Employee(String office, double salary) {
        this.office = office;
        this.salary = salary;
    }

    public Employee(String name, String address, String phone, String email, String office, double salary) {
        super(name, address, phone, email);
        this.office = office;
        this.salary = salary;
    }

    public void  getDateHire() {
        System.out.println(dateHire.getTime());
    }

    public void setDateHire(int year,int month,int date) {
        dateHire=new GregorianCalendar(year,month,date);
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "office='" + office + '\'' +
                ", salary=" + salary +
                ", dateHire=" + dateHire.getTime() +
                '}';
    }
}

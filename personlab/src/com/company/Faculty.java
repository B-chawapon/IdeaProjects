package com.company;
import java.util.GregorianCalendar;
public class Faculty extends Employee{

    private int officeHour;
    private String rank;
    private GregorianCalendar dateHire=new GregorianCalendar();

    public Faculty() {}
    public Faculty(int officeHour, String rank) {
        this.officeHour = officeHour;
        this.rank = rank;
    }

    public Faculty(String office, double salary, int officeHour, String rank) {
        super(office, salary);
        this.officeHour = officeHour;
        this.rank = rank;
    }

    public Faculty(String name, String address, String phone, String email, String office, double salary, int officeHour, String rank) {
        super(name, address, phone, email, office, salary);
        this.officeHour = officeHour;
        this.rank = rank;
    }

    public void getOfficeHour() {
        System.out.println(dateHire.getTime());
    }

    public void setOfficeHour(int year,int month,int date) {
        dateHire=new GregorianCalendar(year,month,date);
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "officeHour=" + officeHour +
                ", rank='" + rank + '\'' +
                ", dateHire=" + dateHire.getTime() +
                '}';
    }
}

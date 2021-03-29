package com.company;
import java.util.Date;
public class Geometric {
    private String color;
    private boolean isFilled;
    private Date dataCreated=new Date();
    public Geometric(){

    }
    public Geometric(String color,boolean isFilled)
    {
        this.color = color;
        this.isFilled = isFilled;
    }
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return isFilled;
    }

    public void setFilled(boolean filled) {
        isFilled = filled;
    }
    public Date getDataCreated()
    {
        return dataCreated;
    }
}

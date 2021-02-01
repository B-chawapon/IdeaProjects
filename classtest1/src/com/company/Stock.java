package com.company;

public class Stock {
    String symbol;
    String  name;
    double  previousClosingPrice;
    double  currentPrice;
    Stock(){

    }
    Stock(String newsymbol, String newname, double newpreviousClosingPrice, double newcurrentPrice){
        symbol = newsymbol;
        name = newname;
        previousClosingPrice = newpreviousClosingPrice;
        currentPrice = newcurrentPrice;
    }
    double getChangePercent(){
       return   (((currentPrice-previousClosingPrice)*100)/previousClosingPrice);
    }


}

package sample;


import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;


public class Controller {
    @FXML
    private Label label;
    private long number1;
    private long number2;
    private String  operator="";
    private boolean start=true;
    Model   model=new Model();
    @FXML
    private void processNumbers(ActionEvent event) {
        if(start==true){
            label.setText("");
            start=false;
        }
        String value=((Button)event.getSource()).getText();
        label.setText(label.getText()+value);
    }

    @FXML
    private void processOperators(ActionEvent event) {
        String  value=((Button)event.getSource()).getText();
        if(value.equals("=")==false){
            if(!operator.equals("")){
                return;
            }
            operator=value;
            number1=Long.parseLong(label.getText());
            label.setText("");

        }
        else {
            if(operator.equals("")){
                return;
            }
            number2=Long.parseLong(label.getText());
            calculate(number1,number2,operator);
            operator="";
        }

    }

    public void calculate(long n1,long n2,String operator)
    {
        switch (operator)
        {
            case"+":
                label.setText(n1+n2+"");
                break;
            case "-":
                label.setText(n1-n2+"");
                break;
            case "/":
                if (n2==0){
                    label.setText("0");
                    break;
                }
                else {
                    label.setText(n1/n2 + "");
                    break;
                }
            case"*":
                label.setText(n1*n2+"");
                break;
            default:
                break;

        }
    }


}


package sample;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField textFAnnual;

    @FXML
    private TextField textFNumber;

    @FXML
    private TextField textFLoan;

    @FXML
    private TextField textFMonthly;

    @FXML
    private TextField textFTotal;

    @FXML
    private Loan loan=new Loan();
    private double  annualRate;
    private int year;
    private double loanamount;

    public Controller() throws FileNotFoundException {
    }

    public void calculate(ActionEvent event) {
        try {
            annualRate = Double.parseDouble(textFAnnual.getText());
            if(annualRate<0){
                throw new Exception("Annual Error");
            }
            else{
                textFAnnual.setStyle(null);
            }

        }
        catch (Exception e){
            textFAnnual.setStyle("-fx-background-color: red;");
        }
        try{
             year=Integer.parseInt(textFNumber.getText());
            if(year<0){
                throw new Exception("Year Error");
            }
            else{
                textFNumber.setStyle(null);
            }
        }
        catch (Exception e){
            textFNumber.setStyle("-fx-background-color: red;");
        }
        try{
            loanamount=Double.parseDouble(textFLoan.getText());
            if(loanamount<0){
                throw new Exception("Loan Error");
            }
            else{
                textFLoan.setStyle(null);
            }
        }
        catch (Exception e){
            textFLoan.setStyle("-fx-background-color: red;");
        }

        loan.setAnnualInterestRate(annualRate);
        loan.setNumberOfYears(year);
        loan.setLoanAmount(loanamount);

        textFMonthly.setText(   String.format("%.5f",(loan.getMonthlyPayment())   )   );
        textFTotal.setText(   String.format("%.5f",(loan.getTotalPayment())   )   );


    }

    @FXML
    public void clearButton(ActionEvent actionEvent) {

        /*annualRate= 0;
        year=0;
        loanamount=0;
        loan.setAnnualInterestRate(annualRate);
        loan.setNumberOfYears(year);
        loan.setLoanAmount(loanamount);*/

        textFAnnual.setText("");
        textFNumber.setText("");
        textFLoan.setText("");
        textFMonthly.setText("");
        textFTotal.setText("");
    }

    @FXML
    void initialize() {
        assert textFAnnual != null : "fx:id=\"textFAnnual\" was not injected: check your FXML file 'sample.fxml'.";
        assert textFNumber != null : "fx:id=\"textFNumber\" was not injected: check your FXML file 'sample.fxml'.";
        assert textFLoan != null : "fx:id=\"textFLoan\" was not injected: check your FXML file 'sample.fxml'.";
        assert textFMonthly != null : "fx:id=\"textFMonthly\" was not injected: check your FXML file 'sample.fxml'.";
        assert textFTotal != null : "fx:id=\"textFTotal\" was not injected: check your FXML file 'sample.fxml'.";

    }


    File  file =new File("loan.dat");
    @FXML
    public void loadButton(ActionEvent actionEvent) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        DataInputStream input = new DataInputStream(fileInputStream);

        this.textFAnnual.setText(String.format("%.5f",  input.readDouble()));
        this.textFNumber.setText(String.format("%d",  input.readInt()));
        this.textFLoan.setText(String.format("%.5f",  input.readDouble()));
        this.textFMonthly.setText(String.format("%.5f",  input.readDouble()));
        this.textFTotal.setText(String.format("%.5f",  input.readDouble()));

        input.close();

    }
    @FXML
    public void saveButton(ActionEvent actionEvent) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        DataOutputStream output = new DataOutputStream(fileOutputStream);

        output.writeDouble(Double.parseDouble(textFAnnual.getText()));
        output.writeInt(Integer.parseInt(textFNumber.getText()));
        output.writeDouble(Double.parseDouble(textFLoan.getText()));
        output.writeDouble(Double.parseDouble(textFMonthly.getText()));
        output.writeDouble(Double.parseDouble(textFTotal.getText()));

        output.close();

    }
}

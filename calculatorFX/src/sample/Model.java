package sample;

public class Model {
    public Model() {
    }
    public  Model(long n1, long n2, String operator){

    }

    public float calculate(long n1, long n2, String operator)
    {
        switch (operator)
        {
            case"+":
                return  n1+n2;
            case "-":
                return n1-n2;
            case "/":
                if (n2==0){
                    return  0;
                }
                return  n1/n2;
            case"*":
                return n1*n2;
            default:
                return  0;

        }
    }
}

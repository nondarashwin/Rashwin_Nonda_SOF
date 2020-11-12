package CalculatorClass;

public class Calculator{
    int addition(int value1,int value2){
        return value1+value2;
    }
    int subtraction(int value1,int value2){
        return value1-value2;
    }
    int multiplication(int value1,int value2){
        return value1*value2;
    }
    Integer division(int value1,int value2){
        if(value2!=0){
            return  value1/value2;
        }
        System.out.println("cant divide by zero");
        return null;
    }
}

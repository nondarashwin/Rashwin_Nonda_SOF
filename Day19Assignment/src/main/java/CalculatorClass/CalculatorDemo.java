package CalculatorClass;

public class CalculatorDemo {
    public static void main(String[] args) {
        Calculator c=new Calculator();
        System.out.println(c.addition(1,2));
        System.out.println(c.subtraction(1,3));
        System.out.println(c.division(1,2));
        System.out.println(c.multiplication(2,7));
    }
}

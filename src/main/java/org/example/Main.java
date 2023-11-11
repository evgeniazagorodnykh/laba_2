package org.example;

import Calculator.Calculator;
import static Calculator.Check.checking;

public class Main {
    public static void main(String[] args) {
        String data = "((52+100)*(10-9)+(3+6))/5";
        Calculator temp = new Calculator(checking(data));
        System.out.println(temp.expression());
    }
}
package project3;

import java.util.Stack;
import java.util.Scanner;
import org.apache.commons.lang3.tuple.Pair;

/**
* This class computes an expression given in Reverse Polish Notation (RPN), and
* returns it as a double.
*
* @author Anderson Levasseur
* @version 1.0
* @exception InvalidRPNString
* File: RPNCalculator.java
* Created: October 2023
* ©Copyright Cedarville University, its Computer Science faculty, and the
* authors. All rights reserved.
* Summary of Modifications:
* 6 October 2023 built out class
*
*
* Description: This class computes an expression given in Reverse Polish 
* Notation (RPN), and returns it as a double. If the given RPN statement isn't
* valid it throws an InvalidRPNString. RPNCalculator is tested by 
* RPNCalculatorTest.java.
*/
public class RPNCalculator {

    /**
     * Computes the given Reverse Polish Notation string
     * @param RPNString  - Reverse Polish Notation String
     * @return The result of the reverse polish notaion given as a Double
     * @exception InvalidRPNString
     */

    public double compute(String RPNString) throws InvalidRPNString {
        Stack<Double> stack = new Stack<>();
        Scanner scanner = new Scanner(RPNString);
        scanner.useDelimiter(" ");

        while (scanner.hasNext()) {
            if (scanner.hasNextDouble()) {
                double nextDouble = scanner.nextDouble();
                stack.push(nextDouble);
            } else {
                //Used a Pair because Java doesn't allow pass by reference
                Pair<Double, Double> pair;
                switch (scanner.next()) {
                    case "+":
                        pair = checkSize(stack);
                        stack.push(pair.getRight() + pair.getLeft());
                        break;
                    case "-":
                        pair = checkSize(stack);
                        stack.push(pair.getRight() - pair.getLeft());
                        break;
                    case "*":
                        pair = checkSize(stack);
                        stack.push(pair.getRight() * pair.getLeft());
                        break;
                    case "/":
                        pair = checkSize(stack);
                        if (pair.getLeft() == 0) {
                            throw new InvalidRPNString("Cannot divide by zero");
                        }
                        stack.push(pair.getRight() / pair.getLeft());
                        break;
                    default:
                        throw new InvalidRPNString("Invalid character");
                }
            }
        }
        scanner.close();
        if (stack.size() > 1) {
            throw new InvalidRPNString("Too many numbers");
        }
        return stack.pop();

    }

    private Pair<Double, Double> checkSize(Stack<Double> stack) {
        if (stack.size() > 1) {
            return Pair.of(stack.pop(), stack.pop());
        } else {
            throw new InvalidRPNString("Too many operators");
        }
    }

}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package numeric;

/**
 * This class finds the factorial of a positive integer and returns a long
 *
 *
 *
 * @author Anderson Levasseur
 * @version 1.0 File: Factorial.java Created: Sept 2023 Â©Copyright Cedarville
 * University, its Computer Science faculty, and the authors. All rights
 * reserved. Summary of Modifications: 07 Sept 2023 --Created a working
 * Factorial method and completed the main method-- 21 Sept 2023 --Changed
 * return type and parameter of ComputeInt to long, renamed ComputeInt to
 * compute--
 *
 * Description: This class finds the factorial when given a positive integer. If
 * not given one positive integer factorial will print an error message and
 * return nothing. This class returns a double
 */
public class Factorial {

    public static void main(String[] args) throws FactorialException {
        //Input Error checking
        if (args.length != 1) {
            System.out.println("There must be 1 argument passed.\n You Passed : ");
            for (String arg : args) {
                System.out.println(arg);
            }
            return;
        }

        int num;

//Converting the given string to an integer
        try {
            num = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            System.out.println("The given argument must be an integer");
            return;
        }

        if (num < 0 || num > 171) {
            System.out.println("Given number must be greater than zero, and less than 171");
            return;
        }
        long prod;
        try {
            prod = compute(num);
        } catch (FactorialException exc) {
            System.out.println(exc.getMessage());
            return;
        }
        System.out.println(args[0] + " factorial is " + prod);

    }

    public static long compute(int num) throws FactorialException {
        if (num < 0) {
            FactorialException exc = new FactorialException("Factorial num cannot be negative");
            throw exc;
        } else if (num > 20) {
            FactorialException exc = new FactorialException("Factorial num cannot be larger than 20");
            throw exc;
        }
        
        if (num == 0) {
            return 1;
        }

        long prod = num;
        num--;

        while (num > 1) {
            prod *= num;
            num--;
        }
        return prod;
    }
}

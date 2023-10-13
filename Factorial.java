package numeric;

/**
* This class finds the factorial of a positive integer and returns a double
*
*
*
* @author Anderson Levasseur
* @version 1.0
* File: Factorial.java
* Created: Sept 2023
* ©Copyright Cedarville University, its Computer Science faculty, and the
* authors. All rights reserved.
* Summary of Modifications:
* 07 Sept 2023 --Created a working Factorial method and completed the main method-- 
*
*
* Description: This class finds the factorial when given a positive integer. If not 
* given one ositive integer factorial will print an error message and return 
* nothing.
* This class returns a double
*/

public class Factorial {
 public static void main (String [] args) {
 //Input Error checking
 if (args.length != 1) {
   System.out.println("There must be 1 argument passed.\n You Passed : ");
   for (String arg:args) {
    System.out.println(arg);
   }
  return;
 }
 
int num;

//Converting the given string to an integer
try {
  num = Integer.parseInt(args[0]);
 } catch (Exception e) {
  System.out.println("The given argument must be an integer");
  return;
 }
 
 if (num < 0 || num > 171) {
  System.out.println("Given number must be greater than zero, and less than 171");
  return;
 } 
 
 double prod = ComputeInt(num);
 System.out.println(args[0] + " factorial is " + prod);
  
 }

 public static double ComputeInt(double f) {
  double prod = f;
  f--;
  
  if (f==0) {
   return 1.0;
  }
  
  while(f > 1) {
   prod *= f;
   f--;
  }
  return prod;
 }
}


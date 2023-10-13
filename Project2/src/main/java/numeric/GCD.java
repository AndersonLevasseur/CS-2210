/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package numeric;

/**
* This class finds the greatest common divisor between two integers and returns an 
* integer
*
*
*
* @author Anderson Levasseur
* @version 1.0
* File: GCD.java
* Created: Sept 2023
* Â©Copyright Cedarville University, its Computer Science faculty, and the
* authors. All rights reserved.
* Summary of Modifications:
* 07 Sept 2023 -- Wrote the solve method and completed the main method --
*
* Description: This class finds the greatest common divisor between the given 
* integers.
*
*/

public class GCD {
 public static void main (String [] args) {
  //Input Error checking
  if (args.length != 2) {
   System.out.println("There must be 2 arguments passed.\n You Passed : ");
   for (String arg:args) {
    System.out.println(arg);
    return;
   }
  } 
 
  long num1;
  long num2;

  //Verifying that the input contains only integers
  try {
   num1 = Long.parseLong(args[0]);
   num2 = Long.parseLong(args[1]);
  } catch (NumberFormatException e) {
   System.out.println("Please enter integers only");
   return;
  }
  
  if (num1==0 && num2==0) {
   System.out.println("You must enter one non zero integer");
   return;
  }
  
  long gcd;
  
  gcd = compute(num1, num2);
  System.out.println("GCD is : " + gcd);
 }

 //recursively finds the GCD between 2 non-zero, non negative numbers
 public static long compute (long num1, long r) {
     if (r==0) {
      if(num1 < 0) {
          num1*= -1;
      }
   return num1;
  }
   return compute(r, num1%r);
 
 }
}

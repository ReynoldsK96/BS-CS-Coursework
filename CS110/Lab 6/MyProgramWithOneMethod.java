// Author: Katherine Reynolds
// Date: 02/19/2020
// File: MyProgramWithOneMethod.java

// import statements
import java.util.Scanner;

public class MyProgramWithOneMethod {

   // a method to print instructions
   public static void printInstructions() {
      System.out.println("This program calculates the nth power " +
                         "of a base interger input by the user.");
   }

    // the main routine
   public static void main(String[] args) {
   
        // print to the screen, instructions
      printInstructions();
        
        // receive user's input
      Scanner keyboard = new Scanner(System.in);
      System.out.print("Please input your exponent; a positive integer less than 10 : ");
      int myInteger = keyboard.nextInt();
      System.out.print("Please input your exponent; a positive integer less than 10 : ");
      int myExponent = keyboard.nextInt();
      int myIntegerPower = myInteger;
   
        
        // perform calculation
      for (int i = 2; i <= myExponent; i++) {
         myIntegerPower *= myInteger;
      }
   
        // output result
      System.out.println("The integer " + myInteger + " raised to the " + myExponent + "th power: " + myIntegerPower);
   }
}
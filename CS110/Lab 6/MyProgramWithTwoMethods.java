// Author: Katherine Reynolds
// Date: 02/19/2020
// File: MyProgramWithTwoMethods.java

// import statements
import java.util.Scanner;

public class MyProgramWithTwoMethods {

   // a method to print instructions
   public static void printInstructions() {
      System.out.println("This program calculates the nth power " +
                         "of a base interger input by the user.");
   }
   
   //a method to read an integar value from the keyboard
   public static int getIntegerFromKeyboard() {
      Scanner keyboard = new Scanner(System.in);
      int keyboardInput = keyboard.nextInt();
      return keyboardInput;
   }

    // the main routine
   public static void main(String[] args) {
   
        // print to the screen, instructions
      printInstructions();
        
        // receive user's input
      System.out.print("Please input your exponent; a positive integer less than 10 : ");
      int myInteger = getIntegerFromKeyboard();
      System.out.print("Please input your exponent; a positive integer less than 10 : ");
      int myExponent = getIntegerFromKeyboard();
      int myIntegerPower = myInteger;
   
        
        // perform calculation
      for (int i = 2; i <= myExponent; i++) {
         myIntegerPower *= myInteger;
      }
   
        // output result
      System.out.println("The integer " + myInteger + " raised to the " + myExponent + "th power: " + myIntegerPower);
   }
}
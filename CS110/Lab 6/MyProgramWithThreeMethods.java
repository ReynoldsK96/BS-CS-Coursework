// Author: Katherine Reynolds
// Date: 02/19/2020
// File: MyProgramWithThreeMethods.java

// import statements
import java.util.Scanner;

public class MyProgramWithThreeMethods {

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
   
   // a method that taesk two arguments, and calculates the first input
   // argument raised to the power of the second argument
   public static int calcExponentValue(int myInteger, int myExponent) {
      int myIntegerPower = myInteger;
      for (int i = 2; i <= myExponent; i++) {
         myIntegerPower *= myInteger;
      }
      return myIntegerPower;
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
      System.out.print("The integer " + myInteger);
      System.out.println(" raised to the " + myExponent + "th power is: " 
                           + calcExponentValue(myInteger, myExponent));
        
   }
}
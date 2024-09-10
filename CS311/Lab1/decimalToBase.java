// Name: Katherine Reynolds
// Student ID: 24556946
// Date: 09/30/2021
// File: decimalToBase.java
// Honor Code: I pledge that this submission is solely my work, and that I have neither given, nor received help from anyone.
import java.util.Scanner;
public class decimalToBase {

   // method that converts number input by user to decimal
   public static int conversion(int num, int base) {
      // variable declaration
      int n = String.valueOf(num).length();
      int result = 0;
      // for loop that establishes i as one less than the length, continues until i equals 0 or less, and subtracts 1 for every iteration
      for (int i = n - 1; i >= 0; i--) {
         //isolates each number by dividing by 10 to the power of position
         int isolatedNum = num/(int)Math.pow(10, i);
         // removes segment of the number already evaluated taking the remainder of the number
         int updatedNum = num % (int)Math.pow(10, i);
         // the remainder becomes the num 
         num = updatedNum;
         // updates result by multiplying it times the base and adding the number isolated to the product
         result = (result * base) + isolatedNum;
      }  
      return result;
   }
   
   public static void main(String args[]) {
      
      // variable declaration
      int num;
      // setting up scanner to collect user input
      Scanner keyboard = new Scanner(System.in);
      // asking user for base value
      System.out.print("Please enter a base from 2-9: ");
      int base = keyboard.nextInt();
      // if else statements to make sure valid base value is entered
      if ((base >= 2) && (base <= 9)) {
         // asking user for number to be converted to base 10
         System.out.print("Enter a base " + base + " number: ");
         num = keyboard.nextInt();
      } else {
         System.out.print("Incorrect base system. Please enter a base from 2-9: ");
         base = keyboard.nextInt();
         System.out.print("Enter a base " + base + " number: ");
         num = keyboard.nextInt();
      }
      // calls conversion method to convert number to base 10
      System.out.print("The equivalent number in base 10 format is " + conversion(num, base));
   }
}
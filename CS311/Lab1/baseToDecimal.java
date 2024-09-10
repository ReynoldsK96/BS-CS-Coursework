// Name: Katherine Reynolds
// Student ID: 24556946
// Date: 09/30/2021
// File: baseToDecimal.java
// Honor Code: I pledge that this submission is solely my work, and that I have neither given, nor received help from anyone.
import java.util.Scanner;
public class baseToDecimal {

   // method that converts decimal to binary
   public static int decimalToBinary(int num, int base){
      System.out.print("Base 2: ");
      // variable declaration
      StringBuilder str = new StringBuilder();
      int quotient = num;
      int remainders = 0;
      // while loop that will continue until the quotient = 0
      while (quotient != 0) {
         // calculates remainder by using modulo operator to divide the quotient by the base
         remainders = quotient % base;
         // calculates quotient using the integer divide operator to divide the quotient by the base, the value will be used again to calculate the remainder
         quotient = quotient/base;
         // adds remainder value and space to stringbuilder object 
         str.append(Integer.toString(remainders));
         str.append(" "); 
      }
      // prints out stringbuilder object, the converted decimal to binary number, in reverse 
      System.out.print(str.reverse());
      return remainders;
   }
   
   // method that converts decimal to octal 
   public static int decimalToOctal(int num, int base) {
      System.out.print("Base 8: ");
      // variable declaration
      StringBuilder str = new StringBuilder();
      int quotient = num;
      int remainders = 0;
      // while loop that will continue until the quotient = 0
      while (quotient != 0) {
         // calculates remainder by using modulo operator to divide the quotient by the base
         remainders = quotient % base;
         // calculates quotient using the integer divide operator to divide the quotient by the base, the value will be used again to calculate the remainder
         quotient = quotient/base;
         // adds remainder value and space to stringbuilder object 
         str.append(Integer.toString(remainders));
         str.append(" "); 
      }
      // prints out stringbuilder object, the converted decimal to octal number, in reverse 
      System.out.print(str.reverse());
      return remainders;
   }
   
   // method that converts decimal to hexadecimal
   public static int decimalToHexadecimal(int num, int base) {
      System.out.print("Base 16: ");
      // variable declaration
      StringBuilder str = new StringBuilder();
      int quotient = num;
      int remainders = 0;
      // while loop that will continue until the quotient = 0
      while (quotient != 0) {
         // if statement to evaluate if the quotient is smaller than the base it is being divided and modulated by
         if (quotient >= base) {
            // calculates remainder by using modulo operator to divide the quotient by the base
            remainders = quotient % base;
            // calculates quotient using the integer divide operator to divide the quotient by the base, the value will be used again to calculate the remainder
            quotient = quotient/base;
            // if else statements to assign the appropriate letter if the number is between 11-15. Appropriate letter or number is appended to the stringbuilder object
            if (remainders == 10) {
               str.append("A ");
            } else if (remainders == 11) {
               str.append("B ");
            } else if (remainders == 12) {
               str.append("C ");
            } else if (remainders == 13) {
               str.append("D ");
            } else if (remainders == 14) {
               str.append("E ");
            } else if (remainders == 15) {
               str.append("F "); 
            } else {
               str.append(Integer.toString(remainders));
               str.append(" "); 
            } 
         // if base is larger than quotient, that last number is appriopriately added to the stringbuilder object
         } else {
             if (quotient == 10) {
               str.append("A ");
               break;
            } else if (quotient == 11) {
               str.append("B ");
               break;
            } else if (quotient == 12) {
               str.append("C ");
               break;
            } else if (quotient == 13) {
               str.append("D ");
               break;
            } else if (quotient == 14) {
               str.append("E ");
               break;
            } else if (quotient == 15) {
               str.append("F "); 
               break;
            } else {
               str.append(Integer.toString(quotient));
               str.append(" ");                
               break;
            } 
         }
      }
      // prints out stringbuilder object, the converted decimal to hexadecimal number, in reverse 
      System.out.print(str.reverse());
      return remainders;
   }
   
   public static void main(String args[]) {
      
      // setting up scanner to collect user input and variable declaration
      Scanner keyboard = new Scanner(System.in);
      System.out.print("Please enter a base 10 number: ");
      int num = keyboard.nextInt();  
      // calling appropriate methods to convert the number input by the user
      decimalToBinary(num, 2);
      System.out.println("");
      decimalToOctal(num, 8);
      System.out.println("");
      decimalToHexadecimal(num, 16);
   }
}
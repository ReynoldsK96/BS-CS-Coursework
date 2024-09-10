// Name: Katherine Reynolds
// Date: 01/28/2021
// File: DecimalMathUsingIntegers

// import scanner
import java.util.Scanner;
public class DecimalMathUsingIntegers {

   // main routine
   public static void main (String[] args) {
      
      // declare variables and assign
      int wholePart = 0, fractionalPart = 0;
      double composedDecimalValue = 0.0;
      Scanner keyboard = new Scanner(System.in);
      
      // intruct user
      System.out.print("Input an integer for digits left of the decimal: ");
      wholePart = keyboard.nextInt();
      
      System.out.print("Input an integer >= for digits right of the decimal: ");
      fractionalPart = keyboard.nextInt();
      
      // output status message and calculations
      System.out.println("The wholePart variable has the value: " + wholePart);
      System.out.println("The fractionalPart variable has the value: " + fractionalPart);
      
      composedDecimalValue = wholePart + fractionalPart/100.0;
      System.out.println("The composedDecimalValue is: " + composedDecimalValue);
      
      // mult composedDecimal by 10,000 and format with commas and 6 decimal places
      System.out.printf("The formatted composedDecimalValue times 10,000 is: %,.6f \n",
                        (composedDecimalValue * 10000.0));
                   
      }
}
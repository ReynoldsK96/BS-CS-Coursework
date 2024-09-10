// Name: Katherine Reynolds
// Date: 01/21/2021
// File: NestedIfStatements.java

import java.util.Scanner;
public class NestedIfStatements{

   public static void main(String[] args) {
   
   // declare two variables, one of type double and the other of type int
      double tempOutsideF = 74;
      int raining = 0;
   
   // set up a Scanner to recieve input from the keyboard
      Scanner keyboard = new Scanner(System.in);
   
      System.out.print("What is the temp outside (in F)? ");
      tempOutsideF = keyboard.nextDouble();
      System.out.print("Is it raining? (enter 1 for yes, 0 for no)? ");
      raining = keyboard.nextInt();
   
      // indicate that clothing to wear, based on temperature 
      if (tempOutsideF > 70){
         // for any temperature higher than 70
         System.out.print("Wear sandals, shorts, a t-shirt, ");
         if (raining == 1){
            // print statement for rain and temp > 70
            System.out.print("and bring a umbrella.");
         }else{
            if (raining == 0)
            // print statment for no rain and temp > 70
               System.out.print("and bring sunglasses.");
         }   
      } else if (tempOutsideF < 30){ 
         // for any temperature below 30
         System.out.print("Wear boots, pants, sweater, gloves, ");
         if (raining == 1){
            System.out.print("and bring a umbrella.");
            // print statement for rain and temp < 30
         }else{
            if (raining == 0)
            // print statement for no rain and temp < 30
               System.out.print("and bring sunglasses.");
         }
      } else {  // this is not the default else; all inputs that are 
                // not caught by one of the above two, are processed
                // here
         if (raining == 1){
            // default print statement for rain
            System.out.println("Wear long-sleeve shirt, pants, shoes, and bring a umbrella.");
         }else{
            // default print statement for no rain
            System.out.println("Wear long-sleeve shirt, pants, shoes, and bring sunglasses.");
         }
      }
   }
}

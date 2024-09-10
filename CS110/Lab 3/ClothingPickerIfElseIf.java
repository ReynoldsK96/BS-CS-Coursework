// Name: Katherine Reynolds
// Date: 01/21/2021
// File: ClothingPickerIfElse.java

import java.util.Scanner;
public class ClothingPickerIfElseIf{

   public static void main(String[] args) {
   
      // declare a variable of type of double that hold temperature 
      double tempOutsideF;
      Scanner keyboard = new Scanner (System.in);
      System.out.print("What is the temp outside (in F)? ");
      tempOutsideF = keyboard.nextDouble();
      
      // indicate what clothing wear, based on the above temperature 
      if (tempOutsideF > 70){
         System.out.println("Wear sandals, shorts and a t-shirt.");
         // for any temperature higher than 70
      } else if (tempOutsideF < 30){
         System.out.println("Wear boots, pants, sweater, and gloves.");
         // for any temperature below 30
      } else {
         System.out.println("Wear long-sleeve shirt, pants, and shoes.");
         // this is the default else; all inputs that are 
         // not caught by one of the above two, are processed
         // here
      }    
   }
}
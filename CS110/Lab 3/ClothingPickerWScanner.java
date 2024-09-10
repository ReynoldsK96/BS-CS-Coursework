// Name: Katherine Reynolds
// Date: 01/21/2021
// File: ClothingPickerWScanner.java

import java.util.Scanner;
public class ClothingPickerWScanner{

   public static void main(String[] args) {
   
      // declare a variable of type of double that hold temperature 
      double tempOutsideF;
      Scanner keyboard = new Scanner (System.in);
      System.out.print("What is the temp outside (in F)? ");
      tempOutsideF = keyboard.nextDouble();
      
      // indicate what clothing wear, based on the above temperature 
      if (tempOutsideF <= 32) 
         System.out.println("Wear boots, pants, sweater, and gloves.");
         
      if (tempOutsideF > 32)
         System.out.println("Wear sandals, shorts and a t-shirt.");
      
      
         
   }
}
// Name: Katherine Reynolds
// Date: 01/14/2021 
// Description: Circumference of a circle  

import java.util.Scanner;
public class CircumferenceOfCircle { 
   
   public static void main(String[] args) { 
   
      // create an object of type Scanner
      Scanner keyboard = new Scanner(System.in);
      
       // Ask the user to input a number with decimals
      System.out.print("Enter a decimal number, and press enter  ");
   
      // Step 1: declare a variable, call it radius, of type double
      double radius = keyboard.nextDouble();
           
      // place the user's input into the variable radius
      //radius = keyboard.nextDouble();
   
      // Step 2: Declare a variable, call it diameter, of type double, 
      // and assign it the value of twice the variable radius. For this 
      // part, do NOT write "double diameter = 9.2". You must use the 
      // variable "radius". For example, if you were assigning the value 
      // to diameter to be twice the radius, you would write: 
      // 
      // double diameter = 2 * radius; 
      double diameter = 2 * radius;
   
      // Step 3: Define a variable, circumference, of type double, and 
      // use the Math library's PI value to assign it a value that is 
      // the circumference, which has the formula pi * diameter. 
      // Hint: to use the Math Library's pi value, you use: Math.PI. 
      // See page 70 of the textbook for an example 
      double circumference = Math.PI * diameter;
   
      // Output the result to the screen 
      System.out.println("The circle with radius " + radius + 
            " has a circumference of " + circumference); 
   } 
}


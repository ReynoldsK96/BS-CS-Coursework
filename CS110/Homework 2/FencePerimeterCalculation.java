// Name: Katherine Reynolds
// Date: 01/24/2021
// File: FencePerimeterCalculation.java

// Get user input for circumference and perimeter calculations
// Declare variables
// Calculate and output circumference
// Calculate and output rectangle perimeter

import java.util.Scanner;
public class FencePerimeterCalculation {  

   public static void main(String[] args) {
   
      // Declare variable and set up means for user to input cicumference, rectangle length, 
      // and rectangle width
      Scanner keyboard = new Scanner(System.in);
      System.out.print("What is the radius of the circle? ");
      double radius = keyboard.nextDouble();
      System.out.print("What is the length of the rectangle? ");
      double rectangleLength = keyboard.nextDouble();
      System.out.print("What is the width of the rectangle? ");
      double rectangleWidth = keyboard.nextDouble();
      
      // Calulate and output circumference 
      double diameter = 2 * radius;
      double circumference = Math.PI * diameter;
      System.out.println("The circle circumference is " + circumference); 
                         
      // Calculate and output rectangle perimeter
      double rectanglePerimeter = (rectangleLength * 2) + (rectangleWidth * 2);
      System.out.println("The perimeter of the rectangle is " + rectanglePerimeter);
   } 
}

// If I input something that is not a number when it asks for the radius of the circle,
// my program does not work.
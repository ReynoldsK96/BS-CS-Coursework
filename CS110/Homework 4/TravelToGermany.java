// Name: Katherine Reynolds
// Date: 02/17/2021
// File: TravelToGermany.java

import java.util.Scanner;
public class TravelToGermany {
   public static double convertDistance(double distance, String distanceMeasurement) {
   // method that converts the distance from miles to kilometers or kilometers to miles,
   // or if neither m or k is entered, informs user that a wrong input has been entered
      
      double productDistance = distance;
      // declaring variable
           
      if (distanceMeasurement.equals("m")) {
      // code that converts from miles to kilometers
         productDistance *= 1.60934;
         System.out.print(distance + " miles are equal to " + productDistance + " kilometers\n");
      } else if (distanceMeasurement.equals("k")) {
      // code that converts from kilometers to miles
         productDistance *= 0.621371;
         System.out.print(distance + " kilometers is equal to " + productDistance + " miles");
      } else {
      // code that outputs a message indicating that an incorrect option was selected
         System.out.println("Sorry, you've entered a bad choice.");
      }
      return productDistance;
   }
   
   public static void main (String args []) {
      
      // Sets up scanner and collects user input for the convertDistance method
      // to use in its calculations
      Scanner keyboard = new Scanner(System.in);
      System.out.println("Hello. This program will convert Miles to Kilometers, " +
                         "or vice-versa.");
      System.out.print("To get started please enter a distance: ");
      double distance = keyboard.nextDouble();
      keyboard.nextLine();
      System.out.println("You've entered " + distance);      
      System.out.print("Did you submit Miles or Kilometers?\n" +
                       "Type m for Miles, or k for Kilometers: ");
      String distanceMeasurement = keyboard.nextLine();
      double resultDistance = convertDistance(distance, distanceMeasurement);
   }
}
// Inputs that break the code: To get started please enter a distance: letter -> exception occurs
   

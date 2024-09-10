// Name: Katherine Reynolds
// Date: 01/24/2021
// File: DjName.java

// Get user first and last name input
// Declare variables
// Set up even and odd rules for first name
// Set up even and odd rules for last name
// Add JayJay to output

import java.util.Scanner;
public class DjName {
   
   public static void main(String[] args) {
   
      // Declare variable and set up means for user to input first and last name 
      String userFirstName, userLastName;
      Scanner keyboard = new Scanner(System.in);
      System.out.print("What is your first name? ");
      userFirstName = keyboard.nextLine();
      System.out.print("What is your last name? ");
      userLastName = keyboard.nextLine();
      int lengthFName = userFirstName.length();
      int lengthLName = userLastName.length();
      int lengthHalfFName = lengthFName/2;
      int lengthHalfLName = lengthLName/2;
   
      // Even and odd first name rules
      if (lengthFName % 2 == 0){
         System.out.print(userFirstName.substring(0, lengthHalfFName));
      }else{
         System.out.print(userFirstName.substring(0, lengthHalfFName));
      }
            
      // Even and odd last name rules
      if (lengthLName % 2 == 0){
         System.out.print(userLastName.substring(lengthHalfLName, lengthLName-0));
      }else{
         System.out.print(userLastName.substring(lengthHalfLName, lengthLName-1));
      }
      
      // Adding JayJay to DJ Name
      System.out.print("JayJay");
   }
}


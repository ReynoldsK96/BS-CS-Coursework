// Name: Katherine Reynolds
// Date: 05/28/2021
// File: HomeworkFourChallenges.java
import java.util.Scanner;
import java.util.*;

public class HomeworkFourChallenges {
   
   // code that uses recursion to check and see if there is a user specified string contained
   // in the array of strings
   public static boolean isItAMember(String[] arrayOfStrings, String targetValue, int num) {
      boolean existence = false;
      if (num > (arrayOfStrings.length - 1)) {
         return existence;
      } else if (targetValue.equals(arrayOfStrings[num]) == false) {
         num++;
         return isItAMember(arrayOfStrings, targetValue, num);
      } else {
         existence = true;
      }
      return existence;
   }
   
   // code that uses recursion to reverse the order and capitalization of a user input string
   public static String stringTotalReverser(String str) {
      if ((null == str) || (str.length() <= 1)) {
         return str;
      } else if ((Character.isUpperCase(str.charAt(0))) == true) {
         return stringTotalReverser(str.substring(1)) + Character.toLowerCase(str.charAt(0));
      } else if ((Character.isLowerCase(str.charAt(0))) == true) {
         return stringTotalReverser(str.substring(1)) + Character.toUpperCase(str.charAt(0));
      } else {
         return stringTotalReverser(str.substring(1)) + str.charAt(0);
      }
   }
 
   // code that uses recursion to see if a user input string is spelled the same backwards as it is forwards
   public static boolean interestingString(String interestingStr) {
      boolean interesting = true;
      if ((null == interestingStr) || (interestingStr.length() <= 1)) {
         return interesting;
      } else if (interestingStr.charAt(0) == interestingStr.charAt(interestingStr.length() - 1)) {         
         return interestingString(interestingStr.substring(1, (interestingStr.length() - 1)));
      } else {
         interesting = false;
      }
      return interesting;
   }  
   
   // main method where the user can select which assignment code they would like to run
   public static void main(String[] args) {
      
      int assignmentNum = 0;
      
      do {
         Scanner keyboard = new Scanner(System.in);
         System.out.print("Which part of the assignment code would you like to run?\n" + 
                           "Programming Challenge 1, 2, or 3? ");
         
         try {
            assignmentNum = keyboard.nextInt();
         } catch (InputMismatchException e) {
            assignmentNum = 4;
         }
         
         switch (assignmentNum) {
         
            case 0: 
               System.out.println("Goodbye!");
               break;
            case 1:
               keyboard.nextLine();
               String[] arrayOfStrings = {"A", "B", "C", "D", "E", "F", "G"};
               System.out.print("Pick a uppercase letter from the alphabet to see if it is in the array: ");
               String targetValue = keyboard.nextLine();
               int num = 0;
               if (isItAMember(arrayOfStrings, targetValue, num) == true) {
                  System.out.println(targetValue + " is present in the array.");
               } else {
                  System.out.println(targetValue + " is not present in the array.");
               }
               break;
            case 2:
               keyboard.nextLine();
               System.out.print("Enter a word or phrase you would like to be reversed: ");  
               String str = keyboard.nextLine();
               String reversedStr = stringTotalReverser(str);
               System.out.println("And here it is reversed, capitalization and all: " + reversedStr);
               break;
            case 3:
               keyboard.nextLine();
               System.out.print("Enter a word you would like to check to see if it is interesting: ");
               String interestingStr = keyboard.nextLine();
               if (interestingString(interestingStr) == true) {
                  System.out.println("Your word is interesting!");
               } else {
                  System.out.println("Your word is boring!");
               } 
               break;
            default:
               System.out.println("Bad selection. Try again!");
         }
      } while(assignmentNum != 0);
   }
}

// Name: Katherine Reynolds
// Date: 03/09/2021
// File: FinalProject.java
// Description: Generates what character you should make in the video game Elder Scrolls Online.

import java.io.*;
import java.util.Random;
import java.util.Scanner;
public class FinalProject {

   // Main method that sets up scanner, declares variables, collects user input, and prints out 
   // methods that determine what traits the character should have. 
   public static void main(String[] args) throws IOException {
      Scanner keyboard = new Scanner(System.in);
      CharacterTraits charGenerator = new CharacterTraits();
      charGenerator.printInstructions();
      String userAnswer = keyboard.nextLine();
      
   
      // while loop used to execute different outcomes depeneding on whether the user
      // wants to make a character using the program.                  
      while (true) { 
         // Portion of the code that executes if the user respondes yes and wants
         // to generate a character using this program. This portion of the code 
         // collected user inputs that are used in the CharacterTraits class to generate 
         // the character traits. Establishes an array for each of the traits so that 
         // multiple characters can be generated during one run of the program. Once the 
         // user has inputed how many characters they wish to generate and the numbers 
         // used in the trait generation, the results are printed out onto a text file and
         // the program is done.
         if (userAnswer.equals("yes")) {
            // User input for how many characters they would like the program to generate
            System.out.print("How many characters would you like to generate? ");
            int numOfChars = keyboard.nextInt();
            
            // Character trait arrays
            String[] arrayOfCharRaces;
            arrayOfCharRaces = new String[numOfChars];
            String[] arrayOfCharGenders;
            arrayOfCharGenders = new String[numOfChars];
            String[] arrayOfCharRoles;
            arrayOfCharRoles = new String[numOfChars];
            String[] arrayOfCharClasses;
            arrayOfCharClasses = new String[numOfChars];
            
            // User input for a large number for the methods that generate the gender and role to use,
            // as well as the values that are used in the class generator method
            System.out.print("To start with let's generate a random number to determine several traits.\n"
                          + "Enter a large number: ");
            int highestPossibleNum = keyboard.nextInt();
            System.out.println("Now you will choose two more numbers.");
            System.out.print("Number 1: ");
            double valueOne = keyboard.nextDouble();
            System.out.print("Number 2: ");
            double valueTwo = keyboard.nextDouble();
            
            // for loop to generate the character traits for any number of characters
            // the user wants the program to generate
            for (int i = 0; i < numOfChars; i++) {
               arrayOfCharRaces[i] = charGenerator.generateRace();
               arrayOfCharGenders[i] = charGenerator.generateGender(highestPossibleNum);
               arrayOfCharRoles[i] = charGenerator.generateRole(highestPossibleNum);
               arrayOfCharClasses[i] = charGenerator.generateCharClass(valueOne, valueTwo);
            }
            
            // sets up text file for loop to write the generated characters in
            FileWriter myFile = new FileWriter("GeneratedCharacters.txt"); 
            PrintWriter out = new PrintWriter(myFile);
            
            // for loop to print generated traits onto a text file names GeneratedCharacters.txt
            for (int i = 0; i < numOfChars; i++) { 
               out.println("Character " + (i+1) + " should play the role of " + arrayOfCharRoles[i] + 
                           ", be a " + arrayOfCharGenders[i] + " of the " + arrayOfCharRaces[i] + " race, "
                           + "and be of the " + arrayOfCharClasses[i] + " class.");                 
            }
            out.close();
            myFile.close();  
            System.out.println("Your randomly generated character can be found in the " + 
                                 "text file named GeneratedCharacter. Have fun!");
            break;
         // Portion of the code that executes if the user responds no and does not want 
         // to generate a character using this program
         } else if (userAnswer.equals("no")) {
            System.out.println("Have fun making your own character! :)");
            break;
         // Portion of the code that executes if the user inputs a value other than "yes" 
         // or "no" so that the program does not break when a wrong response is entered
         } else {
            System.out.println("Incorrect answer, please try again.");
            break;
         }
      }
   }
}  
 




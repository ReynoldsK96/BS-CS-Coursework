// Name: Katherine Reynolds
// Date: 02/01/2021
// File: OneThroughNine.java

// import the Scanner class
import java.util.Scanner;

// Create the java Class OneThroughNine
public class OneThroughNine {

   // Write the main routing
   public static void main(String[] args) {
   
      // Declare variables
      int whichNumber; 
      String minutesRemaining = "12.56";
   
      // Create a scanner to retrieve input from keyboard
      Scanner keyboard = new Scanner(System.in);
      System.out.print("Type a number between 1 and 9: ");
      whichNumber = keyboard.nextInt();   
   
         // Switch statements for inpute of 1 through 9
      switch (whichNumber){
         // Statement for if the number is 1
         case 1:
            System.out.println("1 can be written as 1*1, thus it has two factors,");
            System.out.print("but they both are not different hence it is not a prime number");
            break;
         // Statement for if the number is 2
         case 2:
            System.out.println("2 is the only prime number that is even and " +
                                  "it is the smallest prime number");
            break;
         // Statement for if the number is 3 or 9
         case 3:
         case 9:
            System.out.println("3 squared is 9, and the square root of 9 is 3");
            break;
         // Statement for if the number is 4
         case 4:
            System.out.println("4 is the smallest square greater than 1");
            break;
         // Statement for if the number is 5
         case 5:
            System.out.println("5 is a half of 10. Wow!");
            break;
         // Statement for if the number is 6
         case 6:
            System.out.println("6 is the smallest number that is equal to the sum " +
                                  "of its proper divisors. Interesting!");
            break;
         // Statement for if the number is 7 or 8
         case 7:
         case 8:
            System.out.println("The numbers 7 and 8 are both less than 9. Amazing!");  
            break;
         // Statement for if a number outside of 1-9 is inputed
         default: 
            System.out.println("Please input a number bewteen the values"); 
            System.out.print("equal to or greater than 1 and less than or equal to 9.");                
      }
   }
}

                  
                         

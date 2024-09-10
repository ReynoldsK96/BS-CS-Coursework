// Name: Katherine Reynolds
// Date: 04/20/2021
// File: MakePassword.java
import java.util.Scanner;
public class MakePassword {
   public static void main(String[] args) {
   
   // asks user to input password and then calls 
   // method isValid from the PasswordVerifier class to 
   // check to see if the password follows the rules or not
   Scanner keyboard = new Scanner (System.in);
   System.out.print("Enter a password: ");
   String str = keyboard.nextLine();
   PasswordVerifier.isValid(str);
   }
}
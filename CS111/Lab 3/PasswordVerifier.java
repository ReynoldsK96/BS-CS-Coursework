// Name: Katherine Reynolds
// Date: 04/20/2021
// File: PasswordVerifier.java
public class PasswordVerifier {
   
   // fields
   private static byte minPasswordLength;
   
   // method that checks to see if the password valid i.e. it conforms to the 
   // rules that it needs to be at least 7 characters long, contain one digit, 
   // one upper case, and one lower case. If the password follows these rules
   // the statement VALID PASSWORD will print out. If the password does not follow
   // these rules then a statement for which rule(s) is not being followed will print out.
   public static boolean isValid(String str) {
      boolean status = false;
      minPasswordLength = 7;
      if (str.length() >= minPasswordLength) {
         if ((hasDigit(str) == true) && (hasUpperCase(str) == true) &&
            (hasLowerCase(str) == true)) {
            System.out.println("VALID PASSWORD");
            status = true;
         }
      } 
      if (str.length() < minPasswordLength) {
         System.out.println("Password needs to be at least 7 characters long.");
      } if (hasDigit(str) == false) {
         System.out.println("Password did not include a digit.");
      } if (hasUpperCase(str) == false) {
         System.out.println("Password did not include a upper case character.");
      } if (hasLowerCase(str) == false) {
         System.out.println("Password did not include a lower case character.");
      } if (status == false) {
         System.out.println("INVALID PASSWORD");
      }
      return status;
   }
   
   // method that checks to see if the password contains at least one digit
   private static boolean hasDigit(String str) {
      boolean status = false;
      for (int i = 0; i < str.length(); i++) {
         char ch = str.charAt(i);
         if (Character.isDigit(ch) == true) {
            status = true;
         } else {
            status = false;
         } 
         if (status == true) {
            break;
         }
      }
      return status;
   }
   
   // method that checks to see if the passwork contains at least one upper case character
   private static boolean hasUpperCase(String str) {
      boolean status = false;
      for (int i = 0; i < str.length(); i++) {
         char ch = str.charAt(i);
         if (Character.isUpperCase(ch) == true) {
            status = true;
         } else {
            status = false;
         } 
         if (status == true) {
            break;
         }
      }
      return status;   
   }
   
   // method that checks to see if the password contains at least one lower case character
   private static boolean hasLowerCase(String str) {
      boolean status = false;
      for (int i = 0; i < str.length(); i++) {
         char ch = str.charAt(i);
         if (Character.isLowerCase(ch) == true) {
            status = true;
         } else {
            status = false;
         } 
         if (status == true) {
            break;
         }
      }
      return status;
   }
   
}
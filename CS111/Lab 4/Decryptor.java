// Name: Katherine Reynolds
// Date: 04/27/2021
// File: Decryptor.java
import java.io.*;
import java.lang.*;
import java.util.Scanner;
public class Decryptor {

   // method that gets the unicode value of the of the characters
   // of the string that is being decoded, adds 13 to the value of the 
   // unicode, then converts the unicode back to char, and then appends
   // the new character onto the string
   public static String decryptLevelOne(String str) {
      StringBuilder updatedStr = new StringBuilder();
      int codePoint;
      for (int i = 0; i < str.length(); i++) {
         codePoint = str.codePointAt(i);
         codePoint += 13;
         char ch = (char)codePoint;
         updatedStr.append(ch);  
      }
      str = updatedStr.toString();
      return str;
   }
   
   // method that replaces ! with a's, { with x's, cuts off the 
   // *@ that starts and the @* that ends the string, and then
   // changes all lower case to upper case and upper case to lower case
   public static String decryptLevelTwo(String str) {
      str = str.replace("!", "a");
      str = str.replace("{", "x");
      int index1 = str.indexOf("*@") + 2;
      int index2 = str.indexOf("@*");
      str = str.substring(index1, index2);
      StringBuilder reverseStr = new StringBuilder(str).reverse();
      str = reverseStr.toString();
      
      char[] ch = new char[str.length()];
      for (int i = 0; i < str.length(); i++) {
         ch[i] = str.charAt(i);
      }
      for (int i = 0; i < str.length(); i++) {
         if (Character.isUpperCase(ch[i]) == true) {
            ch[i] = Character.toLowerCase(ch[i]);
         } else if (Character.isLowerCase(ch[i]) == true) {
            ch[i] = Character.toUpperCase(ch[i]);
         } else {
            ch[i] = ch[i];
         }
      }
      str = String.valueOf(ch);
      
      return str;
   }
   
   // method to read the encrypted txt on the document and put it into 
   // a string variable
   public static String readMessage(String fileName) throws IOException {
      File myFile = new File(fileName);
      Scanner inputFile = new Scanner(myFile);
      String line = inputFile.nextLine();
      return line;
   }
   
   // main method that first retrieves the encypted txt from the file, 
   // runs the encrypted txt through first decryption method, then runs 
   // the encypted txt through the second decryption method, and last
   // prints out the fully decrypted txt.
   public static void main(String[] args) throws IOException {
      String fileName = "EncryptedMessage.txt";
      String str = readMessage(fileName);
      str = decryptLevelTwo(str);
      str = decryptLevelOne(str);
      System.out.println(str);
   
   }
}

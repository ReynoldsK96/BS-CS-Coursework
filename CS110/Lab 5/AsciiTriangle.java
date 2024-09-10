// Name: Katherine Reynolds
// Date: 02/04/2021
// File: AsciiTriangle.java

import java.util.Scanner;
public class AsciiTriangle {
   public static void main (String[] args) {
   
      int triangleHeight = 0;
      String aSCIICharacter = "*";
      Scanner keyboard = new Scanner(System.in);
      
      System.out.println("This program prints as simple ASCII triangle. ");
      System.out.print("How tall should the tirangle be? ");
      triangleHeight = keyboard.nextInt() + 1;
      
      System.out.print("What ASCII character should be used to draw the triangle? ");
      aSCIICharacter = keyboard.next();
      
      int triangleRow = 1;
      String triangleRowChars = "";
      int rowCharacterPosition = 1;
      
      while (triangleRow < triangleHeight ){
         triangleRowChars = "";
         rowCharacterPosition = 1;
         while (rowCharacterPosition <= triangleRow){
            triangleRowChars = triangleRowChars + aSCIICharacter;
            rowCharacterPosition++;
         }
         System.out.println(triangleRowChars);
         triangleRow++;
      }
   }
}
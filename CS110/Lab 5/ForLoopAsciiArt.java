// Name: Katherine Reynolds
// Date: 02/15/2021
// File: ForLoopAsciiArt.java

import java.util.Scanner;
public class ForLoopAsciiArt {
   public static void main (String[] args) {
   
      Scanner keyboard = new Scanner(System.in);
      System.out.print("How tall is the triangle? ");
      int triangleHeight = keyboard.nextInt();  
       
      for (int row = 0; row <= triangleHeight; row++) {
         for (int column = 0; column < row; column++) {
            System.out.print("%");
         }
         System.out.println();
      }  
   }
}



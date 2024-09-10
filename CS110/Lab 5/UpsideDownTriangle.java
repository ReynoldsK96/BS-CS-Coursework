// Name: Katherine Reynolds
// Date: 02/15/2021
// File: UpsideDownTriangle.java

import java.util.Scanner;
public class UpsideDownTriangle {
   public static void main (String[] args) {
   
      Scanner keyboard = new Scanner(System.in);
      System.out.print("How tall is the upside-down triangle? ");
      int triangleHeight = keyboard.nextInt();  
      int row;
      int column;
      
   
      for (row = triangleHeight; row > 0; row--) {
         for (column = 0; column < row; column++) {
            System.out.print("%");
         }
         System.out.println();
      } 
   }
}
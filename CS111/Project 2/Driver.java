// Name: Katherine Reynolds
// Date: 06/08/2021
// File: Driver.java

// imports 
import java.util.Scanner;
import java.io.*;

public class Driver{
   
   // main method that sets of RandomAccessFile file and runs a do-while loop to accept user input on 
   // what value to search the file for, calling binarySearch method, and printing out whether the value 
   // was found in the file. Program continues to run until user inputer "N" or an invalid input
   public static void main(String[] args) throws IOException {
      try {
         Scanner keyboard = new Scanner(System.in);
         RandomAccessFile file = new RandomAccessFile("BinFileShort", "r");
      
         String run = "Y";
      
         do {
            System.out.println("What value would to search for? ");
            short key = keyboard.nextShort();
            long first = 0;
            long last = 9998;
            int callNumber = 0;
            if (BinaryRecursiveSearch.binarySearch(file, first, last, key, callNumber) == -1) {
               System.out.println("The value " + key + " is not in the file");
            } else {
               System.out.println("The value " + key + " is at index location: " + (file.getFilePointer() - 2)/2);
            }
            keyboard.nextLine();
            System.out.println("Look for another value? (Y/N)");
            run = keyboard.nextLine();
         } while (run.equals("Y") == true);
      } catch (IOException e) {
         System.out.println(e.getMessage());
         System.exit(1);
      }   
   }
}

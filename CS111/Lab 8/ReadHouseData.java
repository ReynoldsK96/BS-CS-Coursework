// Name: Katherine Reynolds
// Date: 05/25/2021
// File: ReadHouseData.java
import java.io.*;
import java.util.Scanner;
public class ReadHouseData {

   // method that creates a file stream and reads the various binary values and assigns them
   // to different variables. Then those variables are put into a print statement so that the 
   // information is printed out.
   public static void printOutHouseData(String fileName) throws IOException {
        
      boolean endOfFile = false;
      
      FileInputStream fileStream = new FileInputStream(fileName);
      DataInputStream input = new DataInputStream(fileStream);  
      
      while (!endOfFile) {
         try {
            String address = input.readUTF();
            int numBedrooms = input.read();
            short squareFT = input.readShort();
            int price = input.readInt();
            String description = input.readUTF();
            System.out.println("Address : " + address + "\nNumbe of bedrooms : " + numBedrooms + 
                               "\nSquare feet : " + squareFT + "\nPrice USD : " + price + "\n" + description +
                               "\n********************\n");
         } catch (EOFException e) {
            endOfFile = true;      
         }
      }
      input.close();
   }
    
   // method that increases the value of the houses by the percent inputed by the user
   public static void increasePrice(String fileName, int valueIncrease) throws IOException {
      boolean endOfFile = false;
      RandomAccessFile file = new RandomAccessFile(fileName, "rw");
      int skipBytes = 159;
      double percentageIncrease = valueIncrease/100.0;
      file.seek(47);
      while (!endOfFile) {
         try { 
            int oldPrice = file.readInt();
            double newPriceCalc = oldPrice + (oldPrice * percentageIncrease);
            int newPrice = (int)newPriceCalc;
            file.seek(file.getFilePointer() - 4);      
            file.writeInt(newPrice);
            file.seek(file.getFilePointer() + skipBytes);
         } catch (EOFException e) {
            endOfFile = true;
         }
      }
      file.close();
   }

   // main method that prints out information about the houses, asks user by what percentage
   // they want to increase the prices of the houses by, and then prints out information about 
   // the houses again with the prices adjusted accordingly
   public static void main(String[] args) {
      String fileName = "HouseData.bin";
      try {
         printOutHouseData(fileName);
         Scanner keyboard = new Scanner(System.in);
         System.out.println("By what percentage would you like to increase the house prices by?");
         int valueIncrease = keyboard.nextInt();
         increasePrice(fileName, valueIncrease);
         printOutHouseData(fileName);
      } catch (IOException e) {
         System.out.println(e.getMessage());
         System.exit(1);
      } 
   }
}
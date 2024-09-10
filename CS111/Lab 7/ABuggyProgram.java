// Name: Katherine Reynolds
// Date: 05/18/2021
// File: ABuggyProgram.java

// required imports
import java.io.*;
import java.util.*;


public class ABuggyProgram{

    
   public static void openFile() {
      // attempt to open a file that doesn't exist
     
      try {
         String fileName = "importantFile.docx.java.cwu";
         File file = new File(fileName);
         Scanner inputFile = new Scanner(file);
         System.out.println("The first line of myFileFile is: "+ inputFile.nextLine());
      } catch (FileNotFoundException e) {
         System.out.println("****File can’t be open, it does not exist.****\n" + e.getMessage());
      }  
   }
    
   public static void parseNumber(){
      // parsing an integer "String"
      try {
         String str = "Hello World";
         int intFormOfStr = Integer.parseInt(str);
      } catch (NumberFormatException e) {
         System.out.println("****A conversion error happened****");
      }
   }
    
   public static void readPoorlyFormattedFile()throws FileNotFoundException{
      // accessing a file with doubles
      try {
         String fileName = "myDataFile.txt";
         File file = new File(fileName);
         Scanner inputFile = new Scanner(file);
         double sumOfDoubleVals = 0.0;
         while (inputFile.hasNext()) {
            sumOfDoubleVals += inputFile.nextDouble();
         }
      } catch (FileNotFoundException e1) {
         System.out.println("****File can’t be open, it does not exist.****\n" + e1.getMessage());
      } catch (InputMismatchException e2) {
         System.out.println("****Input was incorrect****");
      }
   }
    
   public static void createCarArray(){
      // invoking methods on null objects
      Car[] cars = new Car[100];
      for(int i=0; i<cars.length; i++){
         System.out.println("car "+i+" make :"+cars[i].getMake());
      }
   }
    
   // main method
   public static void main(String[] args) throws IOException {
        
      int userInput = 0;
        
      do{
         // ask what feature should be tested
         Scanner keyboard = new Scanner(System.in);
         System.out.println("\nWhich 'error' would you like to test: ");
         System.out.println(" Press 0 to exit the program.");
         System.out.println(" Press 1 to test FileNotFoundException");
         System.out.println(" Press 2 to test NumberFormatException");
         System.out.println(" Press 3 to test InputMismatchExcpetion");
         System.out.println(" Press 4 to test NullPointerExcpetion\n");
            
         try {
            userInput= keyboard.nextInt();
         } catch (InputMismatchException e) {
            userInput = 5;
         }

          
         switch (userInput) {
            case 0:
               break;
            case 1:
               openFile();
               break;
            case 2:
               parseNumber();
               break;
            case 3:
               readPoorlyFormattedFile();
               break;
            case 4:
               try {
                  createCarArray();
               } catch (NullPointerException e) {
                  System.out.println("****The array has NOT been populated with car objects****");
               }
               break;
            default:
               System.out.println("Bad selection. Try again!");
         }
        
      }while(userInput != 0);
   }
    
}







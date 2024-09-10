// Name: Katherine Reynolds
// Date: 05/18/2021
// File: ProcessTransactions.java
import java.util.*;
import java.io.*;

public class ProcessTransactions{
   
   // checks to see if the account zip code matches the zip code provided at checkout, 
   // if not FraudulentTransactionException is thrown
   public static void checkZipCodes(String acctNum, String zip) throws FraudulentTranscationException {
      String accountZip = acctNum.substring(8);
      if (!(accountZip.equals(zip))) {
         throw new FraudulentTranscationException();
      }
   }
   
   
   // checks to see if the transaction does not exceed more than 20% of the limit, 
   // if not CreditLimitExceededException is thrown
   public static void checkTransactionAmount(int limit, int purchase) throws CreditLimitExceededException{ 
      double exceededLimitCalculation = limit + (limit * 0.2);
      int exceededLimit = (int)exceededLimitCalculation;
      if (purchase > exceededLimit) {
         int amountExceeded = purchase - limit;
         throw new CreditLimitExceededException(amountExceeded);
      }
   }
   
   
   // takes the lines, one at a time, read from the file and splits them into an array of 
   // strings that are then assigned to variables that make up the info in the file. Calls
   // the checkZipCodes method to see if the zip code provided at checkout matches the account
   // zip code, if it does not FradaudulentTransactionException is caught and prints out corresponding message. 
   // Calls the checkTransactionAmount method to see if the transaction exceeds the limit by more
   // than 20%, if it does CreditLimitExceededException is caught and prints out corresponding message. 
   // If neither exception occurs the transaction is successfully processed.
   public static void processTransaction(String transaction) {
      try {
         String str = transaction;
         String[] strArray = str.split(";");
         String transactionID = strArray[0];
         String acctNum = strArray[1];
         String zip = strArray[2];
         System.out.print("Transaction # " + transactionID);
         int limit = Integer.parseInt(strArray[3]);
         int purchase = Integer.parseInt(strArray[4]);
         checkZipCodes(acctNum, zip);
         checkTransactionAmount(limit, purchase);
         System.out.println(" successfully proccessed");
      } catch (CreditLimitExceededException e1) {
         System.out.println(" declined, " + e1.getMessage());
      } catch (FraudulentTranscationException e2) {
         System.out.println(" declined, " + e2.getMessage());
      }  
   }
   

   // main method that reads from user inputed file, if the file does not exist then 
   // FileNotFoundException is caught. Reads from file line by line and passes the lines 
   // to the processTransaction method.
   public static void main(String[] args) {
      try {
         System.out.print("Please enter the file you wish to have processed: ");
         Scanner keyboard = new Scanner(System.in);
         String fileName = keyboard.nextLine();
         File file = new File(fileName);
         Scanner inputFile = new Scanner(file);
         while (inputFile.hasNextLine()) {
            String transaction = inputFile.nextLine();
            processTransaction(transaction);
         }
      } catch (FileNotFoundException e) {
         System.out.println("File not found:\n" + e.getMessage());
      }  
   }

}

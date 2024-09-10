// Author: Katherine Reynolds
// Date: 03/04/2021
// File: StockMarket.java

import java.util.Scanner;

// A "casino" class
public class StockMarket {

   public static void main(String Args[]) {
   
      // four reference variables, trader1, trader2, trader3, trader4, 
      // each of which references a new instance of an object of type Trader,
      // created using the non-standard constructor
      Trader trader1 = new Trader("Lucky");
      Trader trader2 = new Trader("Grumpy");
      Trader trader3 = new Trader("Happy");
      Trader trader4 = new Trader("Sleepy");
   
      // set stock change percentage (stockChangePercentage) for each player (sample percentages)
      // trader1 has stock change percentage of 0.61
      trader1.setStockChangePercentage(0.61);
      // trader2 has stock change percentage of 0.19
      trader2.setStockChangePercentage(0.19);
      // trader3 has stock change percentage of 0.81
      trader3.setStockChangePercentage(0.81);
      // trader4 has stock change percentage of 0.42
      trader4.setStockChangePercentage(0.42);
        
      // invoke the getTraderName and getStockChangePercentage methods
      // for each Trader object, to retrieve that information, and print
      // it to the screen
      System.out.println("Here are the Traders, and their stock change percentages:");
      System.out.println(trader1.getTraderName() + "'s stock change percentage: "
                           + trader1.getStockChangePercentage());
      System.out.println(trader2.getTraderName() + "'s stock change percentage: "
                           + trader2.getStockChangePercentage());
      System.out.println(trader3.getTraderName() + "'s stock change percentage: "
                           + trader3.getStockChangePercentage());
      System.out.println(trader4.getTraderName() + "'s stock change percentage: "
                           + trader4.getStockChangePercentage());
                           
      // create a variable, keyboard, of type Scanner, and set it
      // equal to a new object of type Scanner, that "listens" to
      // System.in	
      Scanner keyboard = new Scanner(System.in);
        
      // a while loop, with a "true" conditional
      while (true) {
         // For each of the four traders, retrieve the trader's name, how much money hey/she spent
         // how much money he/she currently has, and the trader's net profit. Print that information
         // to the screen. Look at the homework handout for sample output	
         System.out.println("Trader " + trader1.getTraderName() + "; Spent: $" + trader1.getDollarsSpent() +
                            "; Current $" + trader1.getDollarsMade() + "; Net $" + trader1.getNetProfit());
         System.out.println("Trader " + trader2.getTraderName() + "; Spent: $" + trader2.getDollarsSpent() +
                            "; Current $" + trader2.getDollarsMade() + "; Net $" + trader2.getNetProfit());
         System.out.println("Trader " + trader3.getTraderName() + "; Spent: $" + trader3.getDollarsSpent() +
                            "; Current $" + trader3.getDollarsMade() + "; Net $" + trader3.getNetProfit());
         System.out.println("Trader " + trader4.getTraderName() + "; Spent: $" + trader4.getDollarsSpent() +
                            "; Current $" + trader4.getDollarsMade() + "; Net $" + trader4.getNetProfit());				
      
         // use a System.out.print statement to ask how much money each trader should bet. 
         System.out.print("How much money should each Trader bet? Enter 0 to quit ");
      
         // Then declare a variable dollarsSpend of type double, and set its value to the keyboard's
         // keystroke (be sure to use keyboard.nextDouble()).
         double dollars = keyboard.nextDouble();
      
         // If the user enters 0, then issue a break statement, so that the while loop terminates
         // Else, invoke the tradeSomeMore method of each Trader, and pass it the variable dollarsSpend		
         if (dollars == 0) {
            break;
         } else {
            trader1.tradeSomeMore(dollars);
            trader2.tradeSomeMore(dollars);
            trader3.tradeSomeMore(dollars);
            trader4.tradeSomeMore(dollars);
         }
      }
   }
}
//Input that breaks code: Entering a letter instead of 0 or another number amount.
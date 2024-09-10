// Name: Katherine Reynolds
// Date: 02/18/2021
// File: GenerateSomeRandomLotteryNums.java

import java.util.Scanner;
import java.util.Random;
public class GenerateSomeRandomLotteryNums{

   public static void main(String[] args) {
   
      System.out.print("I know you are busy, so I will guess\n" +
                       "your lottery numbers for you!\n" +
                       "How many numbers should I guess? ");
      
      Scanner keyboard = new Scanner(System.in);
      int numLotteryNums = keyboard.nextInt();
      System.out.print("What is the highest possible lottery number? ");
      int highestPossibleLotteryNum = keyboard.nextInt();
      Random randomNumbers = new Random();
      
      for (int i = 0; i < numLotteryNums; i++) {
         int randomNum = randomNumbers.nextInt(highestPossibleLotteryNum); 
         {
            String numPosition;
            if (i == 0) {
               numPosition = "first";
            } else if ((i != 0) && (i != numLotteryNums - 1)) {
               numPosition = "next";
            } else {
               numPosition = "last"; 
            }
            System.out.println("The " + numPosition + " lottery number is " + randomNum);
         }                  
      }
   }
}
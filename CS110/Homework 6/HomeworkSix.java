// Name: Katherine Reynolds
// Date: 03/09/2021
// Description: HomeworkSix.java
import java.util.Scanner;
import java.util.Random;

public class HomeworkSix {
   public static void main(String[] args) {
   
      Scanner keyboard = new Scanner(System.in);
      System.out.print("How many double numerical entries do you have? ");
      int sizeOfArray = keyboard.nextInt();
      
      double[] arrayOfDoubles = new double[sizeOfArray];
      
      Random randomNums = new Random();
      
      for (int i = 0; i < sizeOfArray; i++) {
         arrayOfDoubles[i] = randomNums.nextDouble();
      }
   }
   calcSumOfDoubles(arrayOfDoubles);
   calcMaxDouble(arrayOfDoubles);
   calcMinDouble(arrayOfDoubles);
   getCalculations(arrayofDoubles);
}
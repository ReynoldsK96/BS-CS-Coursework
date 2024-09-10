// Name: Katherine Reynolds
// Date: 03/09/2021
// Description: Calculations.java

public class Calculations {
   
   private double sumOfDoubles = 0.0;
   private double average;
   private double maxDouble = 0.0;
   private double minDouble = 0.0;

   public double calcSumOfDoubles(double[] arrayOfDoubles) {
      for (int i = 0; i < arrayOfDoubles.length; i++) {
         sumOfDoubles += arrayOfDoubles[i];
      }
      return sumOfDoubles;
   }
   
   public double calcMaxDouble(double[] arrayOfDoubles) {
      
      for (int i = 0; i < arrayOfDoubles.length; i++) {
         if (arrayOfDoubles[i] > maxDouble) {
            maxDouble = arrayOfDoubles[i];
         }
      }
      return maxDouble;
   }
   
   public double calcMinDouble(double[] arrayOfDoubles) {
      for (int i = 0; i < arrayOfDoubles.length; i++) {
         if (arrayOfDoubles[i] > minDouble) {
            minDouble = arrayOfDoubles[i];
         }
      }
      return minDouble;
   }
   
   public void getCalculations(double[] arrayOfDoubles) {
      System.out.println("The sum of the doubles is: " + sumOfDoubles);
      System.out.println("The average was " + (sumOfDoubles/arrayOfDoubles.length) +
                         " , the maximum double was " + maxDouble + " and the "
                         + "minumum double was " + minDouble);  
   }                       
}


   
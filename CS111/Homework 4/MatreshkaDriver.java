// Name: Katherine Reynolds
// Date: 05/30/2021
// File: MatreshkaDriver.java

public class MatreshkaDriver {

   // method that recursively prints out objects of type Matreshka in decreasing
   // order according to their height.
   public static Matreshka decreasingHeight(Matreshka doll) {
      // if height of doll object is less than one, method is done
      if (doll.getHeight() < 1.0) {
         return doll;
      // if height of doll object greater than or equal to one, prints out doll name 
      // and substracts 1.0 from doll height value, assigning the new height to daughter object
      } else if (doll.getHeight() >= 1.0) {
         System.out.println(doll.getName() + doll.getHeight());
         Matreshka daughter = new Matreshka(doll.getName(), (doll.getHeight() - 1.0));
         // if height of daughter object is greater than one, prints out daughter name,
         // then assigns new value to doll height, 1.0 less than daughter height and runs
         // method recursively
         if (daughter.getHeight() > 1.0) {
            System.out.println(daughter.getName() + daughter.getHeight());
            double height = daughter.getHeight() - 1.0;
            doll.setHeight(height);
            return decreasingHeight(doll);
         }
      }     
   return doll;
   }
   
   // method that recursively prints out objects of type Matreshka in increasing 
   // order according to their height.
   public static Matreshka increasingHeight(Matreshka doll) {
      // if height of doll object is greater than the original height value of 5.0, method is done
      if (doll.getHeight() > 5.0) {
         return doll;
      // if height of doll object greater than or equal to one, prints out doll name 
      // and adds 1.0 to doll height value, assigning the new height to daughter object      
      } else if (doll.getHeight() >= 1.0) {
         System.out.println(doll.getName() + doll.getHeight());
         Matreshka daughter = new Matreshka(doll.getName(), (doll.getHeight() + 1.0));
         // if height of daughter object is greater than the original height value of 5.0, 
         // prints out daughter name, then assigns new value to doll height,
         // 1.0 more than daughter height and runs method recursively
         if (daughter.getHeight() < 5.0) {
            System.out.println(daughter.getName() + daughter.getHeight());
            double height = daughter.getHeight() + 1.0;
            doll.setHeight(height);
            return increasingHeight(doll);
         }
      }
   return doll;
   }

   // main method that creates the 'mother' object of type matreshka, and calls
   // the decreasing and increasing methods
   public static void main(String[] args) {
      Matreshka doll = new Matreshka("Natasha", 5.0);
      System.out.println("call to decreasingHeight()");
      decreasingHeight(doll);
      System.out.println("\ncall to increasingHeight()");
      increasingHeight(doll);
   }
}
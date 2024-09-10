// Name: Katherine Reynolds
// Date: 05/11/2021
// File: CruiseShip.java

public class CruiseShip extends Ship {
   
   protected int numPassengers;
   
   public CruiseShip(String name, int numEngines, int passengers) {
      super(name, numEngines);
      numPassengers = passengers;
   }
   
   public String toString() {
      String str = "-----" +
                   "\nCruise Ship" +
                   "\nName : " + getName() +
                   "\nYear Built : " + getYearBuilt() +
                   "\nNumber of Engines : " + getNumEngines() +
                   "\nNumber of Passengers : " + numPassengers +
                   "\n-----";
   return str;
   }
   
   public String info() {
      String str = "28.5 million people took a cruise in 2018.";
      return str;
   }
   
}
// Name: Katherine Reynolds
// Date: 05/11/2021
// File: Helicopter.java

public class Helicopter extends Aircraft {

   private int topSpeed;
   
   public Helicopter(String name, double altitude, int speed) {
      super(name, altitude);
      topSpeed = speed;
   }
   
   public String toString() {
      String str = "-----" +
                   "\nHelicopter" +
                   "\nName : " + getName() + 
                   "\nYear Built : " + getYearBuilt() +
                   "\nCruising Altitude : " + getCruisingAltitude() + " feet" +
                   "\nTop Speed : " + topSpeed + " mph" +
                   "\n-----";
      return str;
   }
   
   public String takeoffType() {
      String str = "Helicopter can takeoff vertically.";
      return str;
   }
   
}

// Name: Katherine Reynolds
// Date: 05/11/2021
// File: Aircraft.java

public abstract class Aircraft extends Vehicle {

   protected double cruisingAltitude;
   
   public Aircraft(String name, double altitude) {
      super(name);
      cruisingAltitude = altitude;
   }
   
   public double getCruisingAltitude() {
      return cruisingAltitude;
   }
   
   public abstract String takeoffType();

}
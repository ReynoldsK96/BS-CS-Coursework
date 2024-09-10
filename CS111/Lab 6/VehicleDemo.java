// Name: Katherine Reynolds
// Date: 05/11/2021
// File: VehicleDemo.java

public class VehicleDemo {
   public static void main(String[] args) {
   
      Helicopter vehicle1 = new Helicopter("AH-1 Cobra", 7800.0, 267);
      vehicle1.setYearBuilt(1998);
      CruiseShip vehicle2 = new CruiseShip("Carnival Sunrise", 15, 5400);
      vehicle2.setYearBuilt(2017);
      CruiseShip vehicle3 = new CruiseShip("Oasis of the Seas", 9, 3900);
      vehicle3.setYearBuilt(2003);
      
      Vehicle[] vehicleArray = {vehicle1, vehicle2, vehicle3};
      
      for (int i = 0; i < vehicleArray.length; i++) {
         System.out.println(vehicleArray[i]);
      }
      
      System.out.println(vehicle1.takeoffType());
      System.out.println(vehicle2.info());
   
   }
}
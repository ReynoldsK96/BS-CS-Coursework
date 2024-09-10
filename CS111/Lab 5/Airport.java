// Name: Katherine Reynolds
// Date: 05/04/2021
// File: Airport.java

public class Airport {
   public static void main(String[] args) {
   
      MilitaryCargo airplane1 = new MilitaryCargo(15);
      airplane1.setNumEngines(8);
   
      Seaplane airplane2 = new Seaplane(30.0);
      airplane2.setNumEngines(2);
   
      Airplane airplane3 = new Airplane(100.0);
      airplane3.setNumEngines(4);
   
      Airplane[] airplanes = {airplane1, airplane2, airplane3};
   
      for (int i = 0; i < airplanes.length; i++) {
         System.out.println(airplanes[i] + "number of engines : " + airplanes[i].getNumEngines());
      }
      if (airplane2.getLandOnWater() == true) {
         System.out.println("Seaplane is able to land.");
      } else {
         System.out.println("Seaplane is not able to land.");
      }
   }
}
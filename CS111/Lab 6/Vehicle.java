// Name: Katherine Reynolds
// Date: 05/11/2021
// File: Vehicle.java

public abstract class Vehicle {
   
   protected String name;
   private int yearBuilt;
   
   public Vehicle(String name) {
      this.name = name;
   }
   
   public String getName() {
      return name;
   }
   
   public void setYearBuilt(int year) {
      yearBuilt = year;
   }
   
   public int getYearBuilt() {
      return yearBuilt;
   }
   
   public abstract String toString();

}
   
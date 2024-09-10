// Name: Katherine Reynolds
// Date: 05/11/2021
// File: Ship.java

public abstract class Ship extends Vehicle {

   protected int numEngines;
   
   public Ship(String name, int numEngines) {
      super(name);
      this.numEngines = numEngines;
   }
   
   public int getNumEngines() {
      return numEngines;
   }
   
   public abstract String info();

}
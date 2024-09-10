// Name: Katherine Reynolds
// Date: 05/30/2021
// File: Metreshka.java

public class Matreshka {

   // fields
   private String name;
   private double height;
   
   // non-default constructor
   public Matreshka(String name, double height) {
      this.name = name;
      this.height = height;
   }
   
   // method to get height of object
   public double getHeight() {
      return height;
   }
   
   // method to set height of object
   public void setHeight(double height) {
       this.height = height;
   }
   
   // method to get name of object
   public String getName() {
      return name;
   }
}
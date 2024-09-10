// Name: Katherine Reynolds
// Date: 05/04/2021
// File: Seaplane.java

public class Seaplane extends Airplane{
   /**Is the seaplane landing on water*/
   private boolean landOnWater;
   /**The depth of the water the seaplane is landing on*/
   private double waterDepth;
   
   /**
   *The constructor.
   *
   *Takes as input a single argument of type double.
   *@param waterDepth to set the waterDepth the seaplane
   * is landing on. ableToLand method is then called to 
   * check to see if the plane can land based on waterDepth.
   */
   public Seaplane(double waterDepth){
      this.waterDepth = waterDepth;
      ableToLand();
   }
   
   /**
   *This getter method retrieves the instance field
   * landOnWater
   *@return if the seaplane can land on the water
   */
   public boolean getLandOnWater(){
      return landOnWater; 
   }
   
   /**
   *This method checks to see if the seaplane 
   *can land based on the value of waterDepth.
   */
   private void ableToLand(){
      if(waterDepth >= 20){
         landOnWater = true;
      }else{
         landOnWater = false;
      }
   }


}
/**
*@author    Dmytro Dovhalets
*@version   1.234
*@since     2-1-2020
*/



public class Airplane{
   /**The span of the airplane wing*/
   private double wingspan;
   /**The number of engines on the plane*/
   private int numEngines;
   /**Is the airplane meant for the military*/
   private boolean isForMilitary;
   
   /**
   *The constructor.
   *
   *No argument constructor which sets a default value 
   *of 50 for the field wingspan.
   */
   public Airplane(){
      wingspan = 50;
   }
   
   
   /**
   *The constructor.
   *
   *Takes as input a single argument, of type double.
   *@param wingspan to set the wingspan of the airplane
   */  
   public Airplane(double wingspan){
      this.wingspan = wingspan;
   }
   
   
   /**
   *This getter method retrieves the value of the numEngines
   *instance field.
   *@return number of engines on the airplane
   */
   
   
   public int getNumEngines(){
      return numEngines;
   }
   
   
   /**
     * This setter method sets the value of the numEngines
     * instance field.
     * 
     * @param num for the number of engines of the airplane
     */
   public void setNumEngines(int num){
      numEngines = num;
   }
   
   
   /**
   *This getter method retrieves the value of the wingspan
   *instance field.
   *@return the span of the airplanes wing
   */
   public double getWingspan(){
      return wingspan;
   }
   
   
   /**
   *This getter method retrieves the value of the isForMilitary
   *instance field.
   *@return wheher the airplane is meant for the military
   */
   public boolean getIsForMilitary(){
      return isForMilitary;
   }
   
   
   /**
   *This method prints out information about the airplane.
   */
   protected void info(){
      System.out.println("Basic Airplane");
   }
}


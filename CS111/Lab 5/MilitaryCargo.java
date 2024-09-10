/**
*@author    Dmytro Dovhalets
*@version   1.234
*@since     2-1-2020
*/

public class MilitaryCargo extends Airplane{
   /**
   *The carrying capacity for missiles
   */
   private int missilePayload;
   
   
   /**
   * The constructor.
   *
   *Takes as input a single argument, of type int
   *@param payload ariplanes carrying capacity for missiles
   */
   public MilitaryCargo(int payload){
      this.missilePayload = payload;
   }
   
   
   /**
   *This getter method retrieves the instance field 
   *missilePayload
   *@return carrying capacity for missiles
   */
   public int getMissilePayload(){
      return missilePayload;
   }

}


// Name: Katherine Reynolds
// Date: 04/13/2021
// File: RobotHead.java
import java.util.Random;
public class RobotHead {
   
   // fields
   private String eyeColor;
   
   // method to print out robot's eye color when called
   public String toString() {
      String color = "Eye color : " + eyeColor;
      return color;
   }
   
   // method to generate what eye color a robot should have 
   // based on which number between 0 and 5 is randomly generated
   public RobotHead() {
      Random randomNumbers = new Random();
      int randomNum = randomNumbers.nextInt(6); 
      switch(randomNum) {
         case 0:
            eyeColor = "sapphire";
            break;
         case 1:
            eyeColor = "emerald";
            break;
         case 2:
            eyeColor = "ruby";
            break;
         case 3:
            eyeColor = "quartz";
            break;
         case 4: 
            eyeColor = "topaz";
            break;
         case 5:
            eyeColor = "opal";
            break;
      }
   }
}   
      
      
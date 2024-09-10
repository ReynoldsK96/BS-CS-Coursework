// Name: Katherine Reynolds
// Date: 04/13/2021
// File: RobotTorso.java
import java.util.Random;
public class RobotTorso {
   
   // fields
   private int numArms;
   
   // method to print out number of arms the robot has when called
   public String toString() {
      String arms = "Number of arms : " + numArms;
      return arms;
   }
   
   // method to generate how many arms a robot will have based on a 
   // random number generated bewteen 0 and 10
   public RobotTorso() {
      Random randomNumbers = new Random();
      numArms = randomNumbers.nextInt(11); 
   }
}
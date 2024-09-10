// Name: Katherine Reynolds
// Date: 04/13/2021
// File: Robot.java
import java.util.Random;
public class Robot {

   // fields
   private static int numRobots;
   private RobotHead robotHead;
   private RobotTorso robotTorso;
   private String serialID;
   
   // method that increments the variable numRobots by one every time a robot is generated,
   // generates a random number between 0 and 100000 to be part of the robots' serialID,
   // creates a serialID by combining the randomly generated number with "ArmyRobot", 
   // calls the RobotHead and RobotTorso methods to generate eye color and numArms of the 
   // robot
   public Robot() {
      numRobots++;
      Random randomNumbers = new Random();
      int randomNum = randomNumbers.nextInt(100000); 
      String serial= randomNum + "";
      serialID = "ArmyRobot" + serial;
      robotHead = new RobotHead();
      robotTorso = new RobotTorso(); 
   }
   
   // method to set SerialID 
   public void setSerialID(String serial) {
      serialID = serial;
   }
   
   // method of get SerialID
   public String getSerialID() {
      return serialID;
   }
   
   // method to get numRobots, necessary because numRobots is a private variable
   public static int getRobotCount() {
      return numRobots;
   }
   
   // method to combine SerialID, eyeColor, and numArms to print out when 
   // called 
   public String toString() {
      String str = "Serial ID: " + serialID + ", " + robotHead.toString() +
                   ", " + robotTorso.toString();
      return str;
   }
   
   // method to check if two different objects of type Robot have the same serialID
   public boolean equals(Robot aRobot) {
      if (serialID.equals(aRobot.getSerialID())) {
         return true;
      } 
      return false;
   }
   
   // method to create a deep copy of another Robot
   public Robot copy() {
      Robot robotCopy = new Robot();
      robotCopy.setSerialID(serialID);
      return robotCopy;
   }
}
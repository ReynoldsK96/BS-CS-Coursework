// Name: Katherine Reynolds
// Date: 04/13/2021
// File: RobotGarage.java
public class RobotGarage {
   public static void main(String[] args) {
   
      // Declare an array of 3 Robot objects
      Robot[] aRobot = new Robot[3];
   
      // Instantiate new Robot objects into indices 0 and 1 of the array of Robots
      aRobot[0] = new Robot();
      aRobot[1] = new Robot();
   
      // Use the copy() method from one of the robots in indices 0 and 1 to create a new robot
      // object, and place the copy of the robot into index 2 of the array of Robots
      aRobot[2] = aRobot[0].copy();
   
      // Use the toString method in each robot object to print to the screen details about 
      // that robot
      System.out.println(aRobot[0].toString());
      System.out.println(aRobot[1].toString());
      System.out.println(aRobot[2].toString());
   
      //Retrieve the value of the static variable numRobots and print it to the screen
      System.out.println("Number of robots in the garage : " + Robot.getRobotCount());
      // Use a series of if-then statements to check if robots at indices 0 and 1, 0 and 2, or 1
      // and 2 are identical using the equals method in the Robot class, and print to the screen
      // which robots are identical
      if (aRobot[0].equals(aRobot[1])) {
         System.out.println("The first and second robots are the same");
      } else if (aRobot[0].equals(aRobot[2])) {
         System.out.println("The first and third robots are the same");
      } else if (aRobot[1].equals(aRobot[2])) {
         System.out.println("The second and third robot are the same");
      }
   }
}

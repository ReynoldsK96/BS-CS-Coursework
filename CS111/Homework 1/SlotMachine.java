// Name: Katherine Reynolds
// Date: 04/09/21
// File: SlotMachine.java
import java.util.Random;
public class SlotMachine {

   // fields
   public static int numPlayerWins;
   public static int numHouseWins;
   private int[][] reels = new int[3][3];
   
   // method that populates the array reels with random numbers between 1 and 9
   public void gambleMachine() {
      Random randomNumbers = new Random();
      for (int i = 0; i < reels.length; i++) {
         for (int j = 0; j < reels[i].length; j++) { 
            reels[i][j] = randomNumbers.nextInt(9) + 1;
         }
      }
   }
   
   // method that checks to see if three in a row occured horizontally or veritacally
   // to determine whether the gambler won or lost
   public boolean isWinner() {
      if ((reels[0][0] == reels[0][1]) && (reels[0][1] == reels[0][2])) {
         return true;
      } 
      if ((reels[1][0] == reels[1][1]) && (reels[1][1] == reels[1][2])) {
         return true;
      } 
      if ((reels[2][0] == reels[2][1]) && (reels[2][1] == reels[2][2])) {
         return true;
      } 
      if ((reels[0][0] == reels[1][1]) && (reels[1][1] == reels[2][2])) { 
         return true;
      } 
      if ((reels[2][0] == reels[1][1]) && (reels[1][1] == reels[0][2])) { 
         return true;
      } else {
         return false;      
      }
   }
   
   // non-default constructor that calls the method gambleMachine
   public SlotMachine() {
      gambleMachine();
   }
   
}
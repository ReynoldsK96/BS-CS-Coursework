// Name: Katherine Reynolds
// Date: 04/09/21
// File: Casino.java
public class Casino {
   public static void main(String[] args) {
   
   // array of 1000000 SlotMachine objects 
      SlotMachine[] array = new SlotMachine[1000000];
   
   // for loop the checks if three in a row occured horizontally and diagonally, 
   // if so, numPlayerWins is incremented by 1, if not, numHouseWins is incremented
   // by one.
      for (int i = 0; i < array.length; i ++) {
         array[i] = new SlotMachine();
         if (array[i].isWinner() == true) {
            SlotMachine.numPlayerWins++;
         } else {
            SlotMachine.numHouseWins++;
         }
      }
      
      // Prints out how many times the player won, how many times the house won, 
      // and what players chance of winning is. 
      System.out.println("The Casino won " + SlotMachine.numHouseWins + ".");
      System.out.println("The Player won " + SlotMachine.numPlayerWins + ".");
      System.out.printf("The chance of you winning is : %.2f",
                        ((SlotMachine.numPlayerWins/100000.0)*10)); 
      System.out.print(" %");
   }
}
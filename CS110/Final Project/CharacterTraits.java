// Name: Katherine Reynolds
// Date: 03/09/2021
// File: CharacterRace.java

// A class that defines an object of type CharacterRace
import java.util.Random;
public class CharacterTraits {
   
   // fields
   private String charRace;
   private String charGender;
   private String charRole;
   private String charClass;
   
   // method to retrieve charRace value
   // Not used now that I implemented arrays
   public String getRace() {
      return charRace;
   }
   
   // method to retrieve charGender value 
   // Not used now that I implemented arrays
   public String getGender() {
      return charGender;
   }
   
   // method to retrieve charRole value
   // Not used now that I implemented arrays
   public String getRole() {
      return charRole;
   }
   
   // method to retrieve charClass value
   // Not used now that I implemented arrays
   public String getCharClass() {
      return charClass;
   }
   
   // method that prints out explaination of program purpose and general instructions
   public void printInstructions() {
      System.out.println("Hello! This program will generate the character " +
                         "you should make in the Elder Scrolls Online! \nYou will be entering "
                         + "a number to determine several of its traits.");
      System.out.print("Would you like to run this program? Respond yes or no: ");
   }

   // method that generates a random number between 0 and 10 
   // and uses that random number to determine what race the
   // character should be
   public String generateRace() {
      Random randomNums = new Random();
      int randomNum = randomNums.nextInt(10) + 1;
      switch (randomNum) {
         case 1:
            charRace = "Breton";
            break;
         case 2:
            charRace = "Redguard";
            break;
         case 3:
            charRace = "Orc";
            break;
         case 4:
            charRace = "Altmer";
            break;
         case 5:
            charRace = "Bosmer";
            break;
         case 6:
            charRace = "Khajiit";
            break;
         case 7:
            charRace = "Nord";
            break;
         case 8:
            charRace = "Dunmer";
            break;
         case 9:
            charRace = "Argonian";
            break;
         case 10:
            charRace = "Imperial";
            break;
         default:
            System.out.println("\nSomething went wrong!\n");
            System.out.print(randomNum);
      }
      return charRace;
   }
   
   // method to determine what gender the character should be. Using the user's input
   // to generate a random number to determine what gender the character should be.
   // If the number is even the character should be female and if the number is odd
   // the character should be a male. 
   public String generateGender(int highestPossibleNum) {
      Random randomNums = new Random();
      int randomNum = randomNums.nextInt(highestPossibleNum);
      // If the number is even the character should be female.
      if (randomNum%2 == 0) {
         charGender = "female";
      // If the number is anything but even the character should be male.
      } else {
         charGender = "male";
      }
      return charGender;
   }
   
   // method that determines what role the character should play. Using the user's input
   // to generate a random number to determine what role the character should play. If the 
   // number is evenly divisible by 10 the role should be tank, if the number is odd the 
   // character should be a healer, and if the number is even the character should be a DPS.
   public String generateRole(int highestPossibleNum)  {
      Random randomNums = new Random();
      int randomNum = randomNums.nextInt(highestPossibleNum);
      if (randomNum%10 == 0) {
         charRole = "tank";
      } else if (!(randomNum%2 == 0)) {
         charRole = "healer";
      } else if (randomNum%2 == 0) {
         charRole = "DPS";
      } else {
         charRole = "\nSomething is not right!\n";
      }
      return charRole;
   }
   
   // method that determines what class your character should be. Using the user's input
   // of valueOne and valueTwo to create a new variable that is eqaul to the value of 
   // the product of valueOne and valueTwo. If the number is evenly divisible by 9 the character
   // should be a Dragonknight, etc.
   public String generateCharClass(double valueOne, double valueTwo) {
      Random randomNums = new Random();
      int randomNum = randomNums.nextInt(1001);
      double productValue = valueOne * valueTwo * randomNum;
      if (productValue%9 == 0) {
         charClass = "Dragonknight";
      } else if (productValue%6 == 0) {
         charClass = "Nightblade";
      } else if (productValue%4 == 0) {
         charClass = "Warden";
      } else if (productValue%3 == 0) {
         charClass = "Templar";
      } else {
         charClass = "Necromancer";
      }
      return charClass;
   }      
}
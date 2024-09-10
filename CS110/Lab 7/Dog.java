// Name: Katherine Reynolds
// Date: 02/17/2021
// File: Dog.java

public class Dog {

   double heightIn;
   int ageYears;
   String name;
   boolean likesBarking;
   
   public void setHeight (double height) {
      heightIn = height;
   }
   
   public void setAge(int age) {
      ageYears = age;
   }

   public void setName(String petName) {
      name = petName;
   }
   
   public void setLikesBarking(boolean barking) {
      likesBarking = barking;
   }
   
   public double getHeight() {
      return heightIn;
   }
   
   public int getAge() {
      return ageYears;
   }
   
   public String getName() {
      return name;
   }
   
   public boolean getLikesBarking() {
      return likesBarking;
   }
}
   
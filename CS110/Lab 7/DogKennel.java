// Name: Katherine Reynolds
// Date: 02/17/2021
// File: DogKennel.java

public class DogKennel {
   public static void main(String[] args) {
      
      System.out.println("Welcome to the dog kennel");
      
      Dog dog1 = new Dog();
      Dog dog2 = new Dog();
      Dog dog3 = new Dog();
      
      dog1.setHeight(13.5);
      dog1.setAge(8);
      dog1.setName("Igor");
      dog1.setLikesBarking(true);
      
      dog2.setHeight(8.2);
      dog2.setAge(5);
      dog2.setName("Lev");
      dog2.setLikesBarking(false);
      
      dog3.setHeight(15.1);
      dog3.setAge(6);
      dog3.setName("Tatsie");
      dog3.setLikesBarking(true);
      
      int sumOfAges = dog1.getAge() + dog2.getAge() + dog3.getAge();
      System.out.println("The sum of the dogs' ages is " + sumOfAges);
      
      double sumOfHeights = dog1.getHeight() + dog2.getHeight() + dog3.getHeight();
      System.out.println("The sum of the dogs' heights is " + sumOfHeights);
      
      String dogNames = dog1.getName() + ", " + dog2.getName()+ ", " + dog3.getName();
      System.out.println("The dogs are: " + dogNames);
      
      boolean dog1Barking = dog1.getLikesBarking();
      int valueOne = (dog1Barking) ? 1 : 0;
      boolean dog2Barking = dog2.getLikesBarking();
      int valueTwo = (dog2Barking) ? 1 : 0;
      boolean dog3Barking = dog3.getLikesBarking();
      int valueThree = (dog3Barking) ? 1 : 0;
      int n = valueOne + valueTwo + valueThree;
      System.out.println(n + " dogs like barking");
      
   }
}
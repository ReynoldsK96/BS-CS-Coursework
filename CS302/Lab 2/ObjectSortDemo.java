import java.util.Arrays;

class Car implements Comparable<Car>{
   
   private int year;
   private String make;
   
   public Car(int year, String make){
      this.year = year;
      this.make = make;
   }
   
   public int compareTo(Car otherCar){
      return this.make.compareTo(otherCar.make);
   }
   
   public String toString(){
      return "year: "+year+"  make: "+make;
   }
   

}

public class ObjectSortDemo{
   
   public static void main(String[] args){
      
      Car car1 = new Car(2000, "Ford");
      Car car2 = new Car(1080, "Toyota");
      Car car3 = new Car(1990, "Acura");
      
      Car[] cars = {car1, car2, car3};
      
      Arrays.sort(cars);
      
      for(Car car : cars){
         System.out.println(car);
      }
   
      
   }

}
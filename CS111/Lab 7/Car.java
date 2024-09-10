//Author:Dima Dovhalets
//Date:
//File:Parked Car
public class Car{
  
  //fields
  private String make; 
  private String model;
  private String color; 
  private String licenseNumber;
  private int minutesParked;
   
   public Car(String carMake, String carModel, String carColor, String carLicenseNum, int carMinutesParked){  
      make = carMake;
      model = carModel;
      color = carColor;
      licenseNumber = carLicenseNum;
      minutesParked = carMinutesParked;
   }
   
   
   public Car(Car car2){//copy constructor
      make = car2.make;
      model = car2.model;
      color = car2.color;
      licenseNumber = car2.licenseNumber;
      minutesParked = car2.minutesParked;
   }
   
   
   public void setAmountOfMinutesParked(int minutesPark){
      minutesParked= minutesPark;
   }
   
   
   //getter methods
   public int getMinutesParked(){
      return minutesParked;
   }
   
   
   public String getMake(){
      return make;
   }
   
   
   public String getModel(){
      return model;
   }
   
   
   public String getColor(){
      return color;
   }   
   
   
   public String getLicenseNumber(){
      return licenseNumber;
   }
   
   
   public String toString(){//toString method
      String aString = "\n"+"Make: "+make+"\n"+"Model: "+model+"\n"+"Color: "+color+"\n"
                        +"License Number: "+licenseNumber+"\n"+"Minutes Parked: "+minutesParked+"\n";
      return aString;                  
   }
    
}
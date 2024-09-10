// Name: Katherine Reynolds
// Date: 02/02/2021
// File: NumberDaysInAYearSoFar.java

// Declare variables and variable types for String monthName, integer year, integer dayOfMonth.
// Set up scanner for user to input of month, day, and year.

// Declare variable and variable types for how many days have passed so far in a year, 
// integer daysSoFarInYear and whether the year is a leap year or not, boolean isLeapYear, 
// assign it the value false.

// Determine whether the year is a leap year, using the following rules
// 1. If the year is evenly divisible by 4, go to step 2. Otherwise, go to step 5.
// 2. If the year is evenly divisible by 100, go to step 3. Otherwise, go to step 5.
// 3. If the year is evenly divisible by 400, got to step 4. Otherwise, go to step 5.
// 4. The year is a leap year (it has 366 days).
// 5. The year is not a leap year (it has 365 days).

// Use a switch statement to determine the number of days since the beginning of the year.
// January will start at 0 and then each past month will be added up to determine the amound
// of days that came before i.e. January has 31 days in it so February will start at 31.
// Statements must also be set up so that the user inputed day of the month has 1 subtracted
// so that the day they are inputing is not put towards the final days it has been because 
// they are still on that day.

// Add additional day to daysSoFarInYear if isLeapYear = true and it is not January or February to
// account for the extra day in February in a leap year.

// Output the correct text. 
// Set up nested if statements to output correct grammar for whether the day is plural or singular.

import java.util.Scanner;
public class NumberOfDaysInAYearSoFar {
   public static void main(String[] args) {
   
      // declare variables and variable type for day, month, and year
      int year, dayOfMonth;
      String monthName;
            
      // Scanner for user to input the day, month, and year
      Scanner keyboard = new Scanner (System.in);
      System.out.print("What is the month? ");
      monthName = keyboard.nextLine();
      System.out.print("What is the day? " );
      dayOfMonth = keyboard.nextInt();
      System.out.print("What year is it? ");
      year = keyboard.nextInt();
      
      // declare more variable and variable types this time for how many days have passed
      // so far in a year, starting at 0, and whether it is a leap year or not
      int daysSoFarInYear = 0; 
      boolean isLeapYear; 
   
      // determine whether user inputed year is leap year or not using boolean
      isLeapYear = false;
      if (year%4 == 0) {
         if (year%100 == 0) {
            if (year%400 == 0) {
               isLeapYear = true;
            }
            else isLeapYear = false;
         } else isLeapYear = true;
      } else {
         isLeapYear = false;
      }   
                   
      // switch statements to determine how many complete days have passed based on month
      // and user inputed dayOfMonth, subtracting 1 for the day they are currenlty on
      switch(monthName){
         case "January":
            daysSoFarInYear = dayOfMonth - 1;
            break;
         case "February":
            daysSoFarInYear = 31;
            daysSoFarInYear += dayOfMonth - 1;
            break;
         case "March":
            daysSoFarInYear = 59;
            daysSoFarInYear += dayOfMonth - 1;
            break; 
         case "April":
            daysSoFarInYear = 90;
            daysSoFarInYear += dayOfMonth - 1;
            break;
         case "May":
            daysSoFarInYear = 120;
            daysSoFarInYear += dayOfMonth - 1;
            break;
         case "June":
            daysSoFarInYear = 151;
            daysSoFarInYear += dayOfMonth - 1;
            break;
         case "July":
            daysSoFarInYear = 181;
            daysSoFarInYear += dayOfMonth - 1;
            break;            
         case "August":
            daysSoFarInYear = 212;
            daysSoFarInYear += dayOfMonth - 1;
            break;
         case "September":
            daysSoFarInYear = 243;
            daysSoFarInYear += dayOfMonth - 1;
            break;
         case "October":
            daysSoFarInYear = 273;
            daysSoFarInYear += dayOfMonth - 1;
            break;
         case "November":
            daysSoFarInYear = 304;
            daysSoFarInYear += dayOfMonth - 1;
            break;
         case "December":
            daysSoFarInYear = 334;
            daysSoFarInYear += dayOfMonth - 1;
            break; 
      } 
          
      // if statement to determine whether to add the extra day to daysSoFarInYear based on whether
      // it is a leap year and which month the user has inputed
      if ((isLeapYear == true) && (monthName.equals("January") == false) && (monthName.equals("February") == false)){
         daysSoFarInYear++;
      }    
   
      // determine correct output based on whether it is a leap year or not, and correct grammar
      // based on whether the daysSoFarInYear value is singular or plural
      if (isLeapYear == false){
         if (daysSoFarInYear > 1){
            System.out.println("There are " + daysSoFarInYear + 
                               " complete days since the beginning of non-leap year "
                               + year + ".");
         } else { 
            if (daysSoFarInYear <= 1)
               System.out.println("There is " + daysSoFarInYear + 
                                  " complete day since the beginning of non-leap year "
                                  + year + ".");
         }
      } else if (isLeapYear == true){
         if (daysSoFarInYear > 1){         
            System.out.println("There are " + daysSoFarInYear + 
                               " complete days since the beginning of non-leap year "
                               + year + ".");
         } else {
            if (daysSoFarInYear <= 1){
               System.out.println("There is " + daysSoFarInYear + 
                                  " complete day since the beginning of non-leap year "
                                  + year + ".");
            }
         }     
      }                                        
   }
}

// Inputs that break the code: What is the month? 2000 What is the day? March -> Exception occurs
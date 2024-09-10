// Name: Katherine Reynolds
// Date: 06/08/2021
// File: BinaryRecursiveSearch.java

// imports 
import java.io.*;

public class BinaryRecursiveSearch {
   
   public static long binarySearch(RandomAccessFile file, long first, long last, short key, int callNumber) throws IOException {
      
      try {
         // increments and prints out the call number
         callNumber++;
         System.out.println("Binary Search call #" + callNumber);
         // set the mid point index
         long mid = (first + last)/2;
         // if statement to make sure that index is read, 
         // if its odd its not at an index point so one is subtracted
         if (mid % 2 != 0) {
            mid -= 1;
         }
         // sets file pointer to mid to read value in the middle of the file and then middle short value
         file.seek(mid);
         short num = file.readShort();
         // checks to see if first variable is greater than last value, if it is the recursion stops
         if (first > last) {
            return -1;
         // checks to see if the short read from the middle is equal to the value being searched for
         } if (num == key) {
            return mid;
         // if the value being searched for is smaller than the middle value, last variable is updated to be equal to mid - 2 and 
         // method is called recursively
         } if (key < num) {
            last = mid - 2;
            return binarySearch(file, first, last , key, callNumber);
         // otherwise the first value is updated to be equal to mid + 2 and method is called recursively 
         } else {
            first = mid + 2;
            return binarySearch(file, first, last, key, callNumber);
         }
    } catch (IOException e) {
      System.out.println(e.getMessage());
      System.exit(1);
    }
      return -1;
   }   

}
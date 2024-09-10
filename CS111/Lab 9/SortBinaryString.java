// Name: Katherine Reynolds
// Date: 06/02/2021
// File: SortBinaryString.java
import com.sun.jdi.event.ExceptionEvent;

import java.util.Random;

public class SortBinaryString {


   public static String sortBinary(String str) {

      if (str.equals("")) {
         return "";
      } else if (str.charAt(0) == '1') {
         return sortBinary(str.substring(1, str.length())) + "1";
      } else {
         return "0" + sortBinary(str.substring(1, str.length()));
      }
   }
   
   
   /*
   Don't Modify anything below this comment.
   */

   public static void main(String[] args) {
      test(10000);
   }


   public static void test(int testSamples){
      int x = 0;
      String[][] outputs = createTestCases(testSamples);
   
      for (int i = 0; i < outputs[0].length; i++) {
         try {
         
            String actual = sortBinary(outputs[0][i]);
            if(!actual.equals(outputs[1][i])){
               System.out.println("Test "+(i+1) + " Failed\n");
               System.out.println("Input    : "+outputs[0][i]);
               System.out.println("Expected : "+outputs[1][i]);
               System.out.println("Returned : "+actual);
               System.out.println("***********************\n");
               throw new Exception();
            }
            x++;
         }catch (Exception e){
            System.out.println(x+"/"+testSamples+" Tests Passed");
            System.exit(0);
         }
      }
      System.out.println(x+"/"+testSamples+" Tests Passed\nAll Tests Passed");
   
   }

   public static String[][] createTestCases(int numSamples){
      Random rand = new Random(243525676);
      String[] inputsArray = new String[numSamples];
      String[] sortedArray = new String[numSamples];
   
      String testString = "";
      String ones = "", zeros = "";
   
      for(int x=0; x<numSamples; x++) {
         int size = rand.nextInt(101) + 1;
      
         testString = "";
         ones = "";
         zeros = "";
      
         for (int i = 0; i < size; i++) {
            int temp = rand.nextInt(2) + 0;
            if (temp == 1) {
               ones += "1";
            } else {
               zeros += "0";
            }
            testString += temp;
         }
      
         sortedArray[x] = zeros + ones;
         inputsArray[x] = testString;
      }
      return new String[][] {inputsArray, sortedArray};
   }


}

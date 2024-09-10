// Name: Katherine Reynolds
// Date: 01/26/2022
// File: Lab2.java

import java.io.*;
import java.util.*;
import java.util.Arrays;

public class Lab2
{
   /**
    *  Problem 1: Arrange the given array such that all even numbers are in increasing
    *  order at even indices and all odd numbers are in decreasing order at odd indices.
    */
   private static void problem1(int[] arr) {
      // sorts arr
      Arrays.sort(arr);
      
      // creates two ArrayLists for even and odd numbers
      ArrayList<Integer> even = new ArrayList<Integer>();
      ArrayList<Integer> odd = new ArrayList<Integer>();
      
      // puts even numbers in even ArrayList and puts odd numbers in odd ArrayList
      for (int i = 0; i <= arr.length-1; i++) {
         if (arr[i] % 2 == 0) {
            even.add(arr[i]);
         } else {
            odd.add(arr[i]);
         }
      }
      
      // variables for incrementing 
      // e will start at first index of even ArrayList and move forwards because the even numbers need to be placed in increasing increments, so starts with the smallest number 
      int e = 0;
      // o will start at the end of odd ArrayList and move backwards because odd numbers need to be placed in decreasing increments, so starts with the largest number
      int o = odd.size()-1;
      
      // for loop to place elements for ArrayLists back into array
      for (int i = 0; i <= arr.length-1; i++) {
         // if index is even place even number in arr
         if (i % 2 == 0) {
            arr[i] = even.get(e);
            // e is incremented 
            e += 1;
         // if index is odd place odd number in arr
         } else {
            arr[i] = odd.get(o);
            // o is decremented 
            o -= 1;
         }
      }      
   }

   /**
    *  Problem 2: Determines for each entry its position in the sorted array.
    */
   private static int[] problem2(int[] arr) {
      
      // making arrays for IntKVPairs and indexArr that will be returned  
      IntKVPair[] pairs = new IntKVPair[arr.length];
      int[] indexArr = new int[arr.length];


      
      // for loop to populate IntKVPairs with keys and values from arr
      for (int i = 0; i <= arr.length-1; i++) {
         int key = arr[i];
         int value = i;
         IntKVPair newPair = new IntKVPair(key, value);
         pairs[i] = newPair;
      }
      
      // sorts pair array
      Arrays.sort(pairs);
            
      // populates indexArray using value to determine the location of i placement
      for (int i = 0; i <= indexArr.length-1; i++) {
         indexArr[pairs[i].value] = i;
      }
         
      return indexArr;
   }

   // ---------------------------------------------------------------------
   // Do not change any of the code below!

   static class IntKVPair implements Comparable<IntKVPair>
   {
      public int key;
      public int value;
   
      public IntKVPair(int key, int value) {
         this.key = key;
         this.value = value;
      }
   
      public int compareTo(IntKVPair other) {
         return this.key - other.key;
      }
   
   }


   private static final int LabNo = 2;
   private static final Random rng = new Random(654321);

   private static boolean testProblem1(int[][] testCase) {
      int[] arr = testCase[0];
   
      int[] answer = arr.clone();
      problem1(answer);
   
      if (answer == null) 
         return false;
      if (answer.length != arr.length) 
         return false;
   
      for (int i = 2; i < answer.length; i += 2) {
         if (answer[i] < answer[i - 2]) 
            return false;
      }
   
      for (int i = 3; i < answer.length; i += 2) {
         if (answer[i] > answer[i - 2]) 
            return false;
      }
   
      Arrays.sort(arr);
      Arrays.sort(answer);
   
      for (int i = 0; i < answer.length; i++) {
         if (arr[i] != answer[i]) 
            return false;
      }
   
      return true;
   }

   private static boolean testProblem2(int[][] testCase) {
      int[] arr = testCase[0];
      int[] solution = testCase[1];
   
      int[] result = problem2(arr);
   
      if (result == null || result.length != solution.length) {
         return false;
      }
   
      for (int i = 0; i < result.length; i++) {
         if (result[i] != solution[i]) 
            return false;
      }
   
      return true;
   }

   public static void main(String args[]) {
      System.out.println("CS 302-- Lab " + LabNo);
   
      testProblems(1);
      testProblems(2);
   }

   private static void testProblems(int prob) {
      int noOfLines = 10000;
   
      System.out.println("-- -- -- -- --");
      System.out.println(noOfLines + " test cases for problem " + prob + ".");
   
      boolean passedAll = true;
   
      for (int i = 1; i <= noOfLines; i++) {
         boolean passed = false;
         boolean exce = false;
      
         int[][] line = null;
      
         try {
            switch (prob) {
               case 1:
                  line = createProblem1(i);
                  passed = testProblem1(line);
                  break;
            
               case 2:
                  line = createProblem2(i);
                  passed = testProblem2(line);
                  break;
            }
         }
         catch (Exception ex) {
            System.out.println(ex.toString());
            passed = false;
            exce = true;
         }
      
         if (!passed) {
            System.out.println("Test " + i + " failed!" + (exce ? " (Exception)" : ""));
            passedAll = false;
            break;
         }
      }
   
      if (passedAll) {
         System.out.println("All test passed.");
      }
   
   }

   private static int[][] createProblem1(int lineNo) {
      int maxSize = Math.min(lineNo, 500);
      int size = rng.nextInt(maxSize) + 2;
      size += size % 2;
   
      int[] numbers = getRandomNumbers(size);
   
      for (int i = 0; i < size; i++)
      {
         numbers[i] = 2 * numbers[i] + (i % 2);
      }
   
      // Shuffle
      for (int i = 0; i < size; i++) {
         int rndInd = rng.nextInt(size - i) + i;
      
         int tmp = numbers[i];
         numbers[i] = numbers[rndInd];
         numbers[rndInd] = tmp;
      }
   
      return new int[][] { numbers };
   }

   private static int[][] createProblem2(int lineNo) {
      int maxSize = Math.min(lineNo, 500);
      int size = rng.nextInt(maxSize) + 2;
   
      int[] numbers = getUniqueRandomNumbers(size);
      Arrays.sort(numbers);
   
      int[] solution = new int[size];
   
      for (int i = 0; i < size; i++) {
         solution[i] = i;
      }
   
      // Shuffle
      for (int i = 0; i < size; i++) {
         int rndInd = rng.nextInt(size - i) + i;
      
         int tmp = numbers[i];
         numbers[i] = numbers[rndInd];
         numbers[rndInd] = tmp;
      
         tmp = solution[i];
         solution[i] = solution[rndInd];
         solution[rndInd] = tmp;
      }
   
      return new int[][] { numbers, solution };
   }

   private static int[] getRandomNumbers(int size) {
      int[] numbers = new int[size];
   
      int maxVal = size * 10;
      for (int i = 0; i < size; i++) {
         numbers[i] = rng.nextInt(maxVal);
      }
   
      return numbers;
   }

   private static int[] getUniqueRandomNumbers(int size) {
      int maxSize = size * 10;
   
      int[] integers = new int[maxSize];
      for (int i = 0; i < maxSize; i++) {
         integers[i] = i;
      }
   
      // Shuffle
      for (int i = 0; i < maxSize; i++) {
         int rndInd = rng.nextInt(maxSize - i) + i;
      
         int tmp = integers[i];
         integers[i] = integers[rndInd];
         integers[rndInd] = tmp;
      }
   
      return Arrays.copyOf(integers, size);
   }
}

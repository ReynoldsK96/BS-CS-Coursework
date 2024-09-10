// Name: Katherine Reynolds
// Date: 02/27/22
// File: Lab5.java

import java.io.*;
import java.util.*;

public class Lab5 {

   public static int test = 0;

   /**
    *  Problem 1: Find the largest integer that appears at least m times.
    */
   private static int problem1(int[] arr, int m) {
      // creation of hashmap
      HashMap<Integer, Integer> map = new HashMap<>();
   
      // for loop to populate hashmap. The array element at index i is the key and the number of occurances
      // is the value. The first time a unique key is encountered, the value is assigned to 1. Everytime
      // the same key is found, the value is incremented
      for (int i = 0; i < arr.length; i++) {
         if (map.containsKey(arr[i]) == true) {
            int temp = map.get(arr[i]);
            temp += 1;
            map.put(arr[i], temp);
         } else {
            map.put(arr[i], 1);
         }
      }
      
      // used to retrieve keys
      Set<Integer> set = map.keySet();
      // list of keys that occur at least m times will be placed
      // any elements in arr that occur at least m times are a possible solution
      List<Integer> mOccurances = new ArrayList<>();
       
      // for loop to go through hashmap of arr elements and their number of occurances.
      // if the value is greater than or equal to m, the key (or arr element) is placed in the arraylist
      for (Integer key : set) {
         int value = map.get(key);
         if (value >= m) {
            mOccurances.add(key);
         }
      }
      
      // solution is initialized as the value at index 0 of the arrayList
      int solution = mOccurances.get(0);
      // for loop to go through arrayList containing arr elements that occur at least m times to find the largest element among them
      // if the current element is larger than solution, solution is made to equal that element
      for (int i = 0; i < mOccurances.size(); i++) {
         if (mOccurances.get(i) > solution) {
            solution = mOccurances.get(i);
         }
      }
      
      return solution;
   }

   /**
    *  Problem 2: Find two distinct indices i and j such that arr[i] = arr[j] and |i - j| <= m.
    */
   private static int[] problem2(int[] arr, int m) {
      // indexes to be returned
      int i = 0;
      int j = i+1;

      
      // creation of hashmaps, one will be to keep track of how many times a value appears in arr with the arr value as the key and number of occurrences as the value
      // and the other will be to determine the distance between the two equal values at different indexes with the arr value as the key and the  difference between the indexes as the value
      HashMap<Integer, Integer> numOccurrences = new HashMap<>();
      HashMap<Integer, Integer> distance = new HashMap<>();

      // for loop to populate hashmaps from arr
      for (int k = 0; k < arr.length; k++) {
         // variable to use
         int temp = 0;
         // if statements to track how many times a value appears in the arr
         // if hashmap already contains a key equal to the value at the current index of arr then
         // the value is incremented by 1
         if (numOccurrences.containsKey(arr[k]) == true) {
            temp = numOccurrences.get(arr[k]);
            numOccurrences.remove(arr[k]);
            temp += 1;
            numOccurrences.put(arr[k], temp);
         // if the hashmap does not contain a key equal to the value at the current index of arr then
         // a key, value pair is added
         } else {
            numOccurrences.put(arr[k], 1);
         }
         
         // if statements to determine the distance between two equal values
         // if this statement is true then the correct matching values have already been found
         if (numOccurrences.get(arr[k]) > 2 && distance.get(arr[k]) == m) {
            break;
         // if hashmap already contains a key equal to the value at the current index of arr then
         // the difference is taken between the current index and the index the previous matching
         // value was at. This new difference is then stored as the value
         } else if (distance.containsKey(arr[k]) == true) {
            i = distance.get(arr[k]);
            j = k;
            int difference = k - distance.get(arr[k]);
            distance.remove(arr[k]);
            distance.put(arr[k], difference);
         // if the hashmap does not contain a key equal to the value at the current index of arr then
         // a key, value pair is added
         } else {
            distance.put(arr[k], k);
         }
         
         // if the difference calcuted above is greater than m, this distance is removed and the 
         // current index is added. This to handle when there are 3 or more occurrences of the same
         // value in arr
         if (distance.get(arr[k]) > m) {
            distance.remove(arr[k]);
            distance.put(arr[k], k);
         }
         
      }

      // used to retrieve keys
      Set<Integer> set = numOccurrences.keySet();
      // list of keys that occur more than one time will be placed
      // any repeated elements in arr are a possible solution
      List<Integer> possibleSolutions = new ArrayList<>();

      // for loop to go through hashmap of arr elements and their number of occurances.
      // if the value is greater than or equal to m, the key (or arr element) is placed in the arraylist
      for (Integer key : set) {
         int value = numOccurrences.get(key);
         if (value >= 2) {
            possibleSolutions.add(key);
         }
      }

      // variable to hold the target value that will be at the correct
      // i and j indexes to be returned
      int target = 0;

      // for loop to go through hashmap of arr elements and the difference between their indexes
      // if the value is less than or equal to m then it is the value where the correct i and j 
      // indexes can be found
      for (int k = 0; k < possibleSolutions.size(); k++) {
         target  = possibleSolutions.get(k);
         if (distance.get(target) <= m) {
            break;
         }
      }

      // for loop to find indexes i and j that j - i <= m
      for (i = 0; i < arr.length;) {

         // if either i or j are equal to the length of arr then the correct
         // value pair was not found and i is incremented and j reset
         if (i == arr.length || j == arr.length) {
            ++i;
            j = i + 1;
            continue;
         }
         
         // if this statement is true then the correct indexes have been identified
         if (arr[i] == arr[j] && j - i <= m) {
            break;
         // if this statement is true then the correct j index needs to be found so j is incremented
         } else if (arr[i] == target && arr[i] != arr[j]) {
            ++j;
            continue;
         // if this is true then the current index of i does not match the target value and j is incremented
         } else if (arr[i] != target) {
            ++i;
            j = i+1;
            continue;
         // if this is true then while the two indexes have equal values, the difference between the two is 
         // incorrect meaning the correct value pair is further along in the array so i is incremented and j reset
         } else if (arr[i] == arr[j] && j - i > m) {
            ++i;
            j = i+1;
            continue;
         }
      }
      
      return new int[] { i, j };
   }

   // ---------------------------------------------------------------------
   // Do not change any of the code below!

   private static final int LabNo = 5;
   private static final Random rng = new Random(123456);

   private static boolean testProblem1(int[][] testCase)
   {
      int[] arr = testCase[0];
      int m = testCase[1][0];
   
      int answer = problem1(arr.clone(), m);       
      
      Arrays.sort(arr);
      
      for (int i = arr.length-1, j = arr.length-1; i >= 0; i = j)
      {
         for (; j >=0 && arr[i] == arr[j]; j--) { }
      
         if (i - j >= m){
            return answer == arr[i];
         }
      }

      
   
      return false; // Will never happen.
   }

   private static boolean testProblem2(int[][] testCase)
   {
      int[] arr = testCase[0];
      int m = testCase[1][0];
   
      int[] answer = problem2(arr.clone(), m);
   
      if (answer == null || answer.length != 2)
      {
         return false;
      }
   
      Arrays.sort(answer);
   
      // Check answer
      int i = answer[0];
      int j = answer[1];
      return i != j
         && j - i <= m
         && i >= 0
         && j < arr.length
         && arr[i] == arr[j];
   }

   public static void main(String args[])
   {
      System.out.println("CS 302 -- Lab " + LabNo);
      testProblems(1);
      testProblems(2);
   }

   private static void testProblems(int prob)
   {
      int noOfLines = prob == 1 ? 100000 : 500000;
   
      System.out.println("-- -- -- -- --");
      System.out.println(noOfLines + " test cases for problem " + prob + ".");
   
      boolean passedAll = true;
   
      for (int i = 1; i <= noOfLines; i++)
      {
      
         int[][] testCase = null;
      
         boolean passed = false;
         boolean exce = false;
      
         try
         {
            switch (prob)
            {
               case 1:
                  testCase = createProblem1(i);
                  passed = testProblem1(testCase);
                  break;
            
               case 2:
                  testCase = createProblem2(i);
                  passed = testProblem2(testCase);
                  break;
            }
         }
         catch (Exception ex)
         {
            System.out.println(ex.toString());
            passed = false;
            exce = true;
         }
      
         if (!passed)
         {
            System.out.println("Test " + i + " failed!" + (exce ? " (Exception)" : ""));
            passedAll = false;
            break;
         }
      }
   
      if (passedAll)
      {
         System.out.println("All test passed.");
      }
   
   }

   private static int[][] createProblem1(int testNo)
   {
      int size = rng.nextInt(Math.min(1000, testNo)) + 5;
   
      int[] numbers = getRandomNumbers(size, size);
      Arrays.sort(numbers);
   
      int maxM = 0;
   
      for (int i = 0, j = 0; i < size; i = j)
      {
         for (; j < size && numbers[i] == numbers[j]; j++) { }
         maxM = Math.max(maxM, j - i);
      }
   
      int m = rng.nextInt(maxM) + 1;
   
      shuffle(numbers);
   
      return new int[][] { numbers, new int[] { m } };
   }

   private static int[][] createProblem2(int testNo)
   {
      int size = rng.nextInt(Math.min(1000, testNo)) + 5;
   
      int[] numbers = getRandomNumbers(size, size);
   
      int i = rng.nextInt(size);
      int j = rng.nextInt(size - 1);
      if (i <= j) j++;
   
      numbers[i] = numbers[j];
   
      return new int[][] { numbers, new int[] { Math.abs(i - j) } };
   }

   private static void shuffle(int[] arr)
   {
      for (int i = 0; i < arr.length - 1; i++)
      {
         int rndInd = rng.nextInt(arr.length - i) + i;
         int tmp = arr[i];
         arr[i] = arr[rndInd];
         arr[rndInd] = tmp;
      }
   }

   private static int[] getRandomNumbers(int range, int size)
   {
      int numbers[] = new int[size];
   
      for (int i = 0; i < size; i++)
      {
         numbers[i] = rng.nextInt(2 * range) - range;
      }
   
      return numbers;
   }
}

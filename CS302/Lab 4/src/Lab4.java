// Name: Katherine Reynolds
// Date: 02/21/22
// File: Lab4.java

import java.io.*;
import java.util.*;

public class Lab4 {
    /**
     *  Problem: Sort multi-digit integers (with n total digits) in O(n) time.
     *  (Technically, it is O(n * b) time. However, since our base b = 128 is constant, it is O(n).)
     */
    private static void problem(byte[][] arr) {

        // copy arr to be sorted
        byte[][] copy = arr.clone();
        // array to count the lengths of array elements
        int[] count = new int[128];

        // count length of array elements
        for (int i = 0; i < arr.length; i++) {
          int length = arr[i].length;
          count[length] += 1;
        }

        // array that will be used to sort arr elements
        byte sorted [][] = new byte[arr.length][];
        // variables to access different elements of the arrays
        // in the following while loop x will be used to access array elements in the sorted array
        int x = 0;
        // in the following while loop b will be used to access array elements in the count array
        int b = 0;

        // while loop that populates sorted array with empty arrays with lengths that correspond to values held in counting array
        // starting with the smallest length found in array to be sorted and going up until 128, the max length an array element can be
        // basically groups all equal array lengths together
        while (b < 128) {
            // if b is greater than 0 add empty array of equal length to the current index of b
            if (count[b] > 0) {
                sorted[x] = new byte[b];
                // decrement b to ensure that the appropriate amount of array elements are added
                --count[b];
                // move the index of sorted forward
                ++x;
            // if the current index of b is 0 that means that no array elements need to added to the sorted array
            // increment index of count
            } else {
                ++b;
            }
        }

        // in the following for loop b will be used to access array elements in the copy array
        b = 0;

        // for loop to fill empty array elements in sorted with array elements in arr that are the same length
        for (int i = 0; i < sorted.length;) {
            // if the current index of copy is not null and it is the same length as the current index of sorted
            // add what is at the current index of copy to the the current index of sorted
            if (copy[b] != null && sorted[i].length == copy[b].length) {
                sorted[i] = copy[b];
                // make that index of copy null to mark that it has already been added to sorted
                copy[b] = null;
                // increment index of sorted
                ++i;
                // reset b since the array that matches the length of the index of sorted could
                // be located anywhere in the copy array. Has to be reset every time to ensure that
                // no array element is missed.
                b = 0;
            // if the current index of copy is null or the current indexes of sorted and copy are not of equal length
            // increment b to continue searching for the array element in the copy array that matches the length of the current index of sorted
            } else {
                ++b;
            }
        }

        // in the following while loop x will be used to access the most significant numbers
        x = 1;
        // in the following while loop b will be used to access an array element and the one in front of it so they can be compared
        b = 0;

        // while loop to sort sorted array by the most significant numbers
        while (b < sorted.length-1) {
            // lengths of current array element being looked at and the one right after it
            int current = sorted[b].length;
            int next = sorted[b+1].length;
            // if the lengths of the array elements are not the equal then they do not need to be compared
            // increment b and go to next iteration of the loop
            if (current != next) {
                ++b;
                continue;
            }
            // if x is smaller than the length of the current array element and the most significant numbers of the current array element
            // and the following array elements are equal then increment x so that the highest significant number that is different in
            // in the two array elements can be found
            if (x < current && current == next && sorted[b][current-x] == sorted[b+1][next-x]) {
                ++x;
                continue;
            }
            // if x is greater than current then the array elements are equal and do not need to be shifted, reset x and
            // increment b to compare the next two elements in the array
            if (x > current) {
                x = 1;
                ++b;
                continue;
            }
            // if the lengths of the current array elements and next one are equal and the highest differing significant number
            // of the current array element is more than that of the next array element, swap them. Reset b to 0 to go back through
            // array to make sure that everything before that point is properly sorted. Reset x to 1 to make it so the comparison
            // starts again at the most significant number.
            if (current == next && sorted[b][current-x] > sorted[b+1][next-x]) {
                byte tempRow[] = sorted[b];
                sorted[b] = sorted[b + 1];
                sorted[b + 1] = tempRow;
                b = 0;
                x = 1;
                continue;
            }
            // this if statement is to check when the highest significant numbers are equal and the next highest number has been found
            // that is different to see if they are already in the right order. If they are then x is reset back to looking at the most
            // significant number and b is incremented to look at the next two elements in the array
            if (x > 1 && current == next && sorted[b][current-x+1] == sorted[b+1][next-x+1] && sorted[b][current-x] < sorted[b+1][next-x]) {
                x = 1;
                ++b;
                continue;
            }
            // b is only incremented here if none of the if statements where true as they all have continue statements and jump right into the
            // next iteration of the while loop if they are found to be true
            ++b;
        }
        // in the following for loop x will be used to access the indexes of the arr array
        x = 0;

        // for loop to make the arr to be sorted equal to the sorted array. Starting at the beginning of the sorted array
        // the arr array is searched until the corresponding element to the current index of sorted is found. The elements
        // in the arr array are then swapped, with the correct element being swapped with the element at the current current
        // index of sorted in the arr array
        for (int i = 0; i < arr.length;) {
            if (sorted[i] == arr[x]) {
                byte tempRow[] = arr[i];
                arr[i] = arr[x];
                arr[x] = tempRow;
                ++i;
                x = i;
            } else {
                ++x;
            }
        }
    }

    // ---------------------------------------------------------------------
    // Do not change any of the code below!

    private static final int LabNo = 4;
    private static final Random rng = new Random(654321);

    private static boolean testProblem(byte[][] testCase) {
        byte[][] numbersCopy = new byte[testCase.length][];

        // Create copy.
        for (int i = 0; i < testCase.length; i++) {
            numbersCopy[i] = testCase[i].clone();
        }

        // Sort
        problem(testCase);
        Arrays.sort(numbersCopy, new numberComparator());

        // Compare if both equal
        if (testCase.length != numbersCopy.length) {
            return false;
        }

        for (int i = 0; i < testCase.length; i++) {
            if (testCase[i].length != numbersCopy[i].length) {
                return false;
            }

            for (int j = 0; j < testCase[i].length; j++) {
                if (testCase[i][j] != numbersCopy[i][j])
                {
                    return false;
                }
            }
        }

        return true;
    }

    // Very bad way of sorting.
    private static class numberComparator implements Comparator<byte[]> {
        @Override
        public int compare(byte[] n1, byte[] n2) {
            // Ensure equal length
            if (n1.length < n2.length) {
                byte[] tmp = new byte[n2.length];
                for (int i = 0; i < n1.length; i++) {
                    tmp[i] = n1[i];
                }
                n1 = tmp;
            }

            if (n1.length > n2.length) {
                byte[] tmp = new byte[n1.length];
                for (int i = 0; i < n2.length; i++) {
                    tmp[i] = n2[i];
                }
                n2 = tmp;
            }

            // Compare digit by digit.
            for (int i = n1.length - 1; i >=0; i--) {
                if (n1[i] < n2[i]) return -1;
                if (n1[i] > n2[i]) return 1;
            }

            return 0;
        }
    }

    public static void main(String args[]) {
        System.out.println("CS 302 -- Lab " + LabNo);
        testProblems();
    }

    private static void testProblems() {
        int noOfLines = 10000;

        System.out.println("-- -- -- -- --");
        System.out.println(noOfLines + " test cases.");

        boolean passedAll = true;

        for (int i = 1; i <= noOfLines; i++) {
            byte[][] testCase =  createTestCase(i);

            boolean passed = false;
            boolean exce = false;

            try {
                passed = testProblem(testCase);
            } catch (Exception ex) {
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

    private static byte[][] createTestCase(int testNo) {
        int maxSize = Math.min(100, testNo) + 5;
        int size = rng.nextInt(maxSize) + 5;

        byte[][] numbers = new byte[size][];

        for (int i = 0; i < size; i++) {
            int digits = rng.nextInt(maxSize) + 1;
            numbers[i] = new byte[digits];

            for (int j = 0; j < digits - 1; j++) {
                numbers[i][j] = (byte)rng.nextInt(128);
            }

            // Ensures that the most significant digit is not 0.
            numbers[i][digits - 1] = (byte)(rng.nextInt(127) + 1);
        }

        return numbers;
    }

}

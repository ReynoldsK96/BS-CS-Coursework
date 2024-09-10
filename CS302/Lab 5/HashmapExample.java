import java.util.*;

public class HashmapExample{
   
   public static void main(String[] args){
      /*
      HashMap<Key, Value>
      
      get(key) - Returns the value to which the specified key is mapped,
                or null if this map contains no mapping for the key.
      
      put(key, value) - Associates the specified value with the specified key in this map    
      
      containtsKey(key) - Returns true if this map contains a mapping for the specified key.      
      */
      
      HashMap<String, Integer> table1 = new HashMap<String, Integer>();
      
      String[] names = {"Sophia", "Boris", "John", "Emma", "Dima"};
      int[] accountBalance = {2345, 5456, 2342, 7686, 1231};
      
      for(int i=0; i<names.length; i++){
         //key = name
         //value = account balance
         table1.put(names[i], accountBalance[i]);
      }
      
      System.out.println("Balance of "+names[3]+" "+ table1.get(names[3]));
      
      
      
      
      
      int[] nums = {3, 2, 4, 6, 1, 5, 3};
      
      HashMap<Integer, Integer> table2 = new HashMap<Integer, Integer>();
      
      for(int i=0; i<nums.length; i++){
         //key = number from the array
         //value = index location
         table2.put(nums[i], i);
      }
      
      int key = -3;
      
      if(table2.containsKey(key)){
         System.out.println(key+" is in the table with value "+table2.get(key));
      }else{
         System.out.println(key+" is not in the table");

      }
   }

}
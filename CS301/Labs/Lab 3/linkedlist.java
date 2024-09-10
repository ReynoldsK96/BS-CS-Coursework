// Name: Katherine Reynolds
// Date: 10/20/2021
// File: linkedlist.java

import java.io.*; 

// Java program to implement 
// a Singly Linked List 
public class linkedlist { 

   Node head; // head of list 

	// Linked list Node. 
	// This inner class is made static 
	// so that main() can access it 
   static class Node { 
   
      int data; 
      Node next; 
   
   	// Constructor 
      Node(int d) 
      { 
         data = d; 
         next = null; 
      } 
   } 

	// **************INSERTION************** 

	// Method to insert a new node 
   public static linkedlist insert(linkedlist list, int data) { 
      
   	// Create a new node with given data 
      Node insertNode = new Node(data);
      
      // then make the new node as head 
      if (list.head == null) {
         list.head = insertNode;
      	// Else traverse till the last node 
      	// and insert the new_node there 
      	// Insert the new_node at last node 
      } else {
         Node temp = list.head;
         
         while (temp.next != null) {
            temp = temp.next;
         }
         
         temp.next = insertNode;
      }
   	// Return the list by head 
      return list;
   } 

	// **************TRAVERSAL************** 

	// Method to print the linkedlist. 
   public static void printList(linkedlist list) { 
   	// Traverse through the linkedlist 
   		// Print the data at current node 
   		// Go to next node
      Node currNode = list.head;
      while (currNode != null) {
         System.out.print(currNode.data + ", ");
         currNode =  currNode.next;
      }
      System.out.println("");
   }

	// **************DELETION BY KEY************** 

	// Method to delete a node in the linkedlist by KEY 
   public static linkedlist deleteByKey(linkedlist list, int key) { 
   	// Store head node 
      Node currNode = list.head;
      Node previousNode = currNode;
   	// 
   	// CASE 1: 
   	// If head node itself holds the key to be deleted 
      if (list.head.data == key) {
         list.head = list.head.next;
         // Display the message 
         System.out.println(key + " found and deleted"); 
      
      	// Return the updated List 
         return list;
      }
   	// 
   	// CASE 2: 
   	// If the key is somewhere other than at head 
   	// 
      // Search for the key to be deleted, 
   	// keep track of the previous node 
   	// as it is needed to change currNode.next 
   		// If currNode does not hold key 
   		// continue to next node 
   	// If the key was present, it should be at currNode 
   	// Therefore the currNode shall not be null 
   		// Since the key is at currNode 
   		// Unlink currNode from linked list 
   		// Display the message 
      while (currNode != null) {
         if (currNode.data == key) {
            previousNode.next = currNode.next;
            System.out.println(key + " found and deleted"); 
            return list;
         }
         previousNode = currNode;
         currNode = currNode.next;
      }
   	// 
   	// CASE 3: The key is not present 
   	// 
   
   	// If key was not present in linked list 
   	// currNode should be null 
   		// Display the message 
      if (currNode == null) {
         System.out.println(key + " is not in the list");
         return list;
      }
   	// return the List
      return list; 
   } 

	// **************DELETION AT A POSITION************** 

	// Method to delete a node in the linkedlist by POSITION 
   public static linkedlist deleteAtPosition(linkedlist list, int index) { 
   	// Store head node 
      Node currNode = list.head;
      Node previousNode = currNode;
   	// 
   	// CASE 1: 
   	// If index is 0, then head node itself is to be deleted 
      if (index == 0) {
         list.head = list.head.next;
         // Display the message 
         System.out.println(index + " position element deleted");
         // Return the updated List 
         return list;  
      } 
   	// 
   	// CASE 2: 
   	// If the index is greater than 0 but less than the size of linkedlist 
   	// 
      int length = 0;
      while (currNode != null) {
         previousNode = currNode;
         currNode = currNode.next;
         length++;
      }
      
      if ((index > 0) && (index <= length)) {
      // Count for the index to be deleted, 
      // keep track of the previous node 
      // as it is needed to change currNode.next 
         int i = 0;
         currNode = list.head;
         while (currNode != null) {            
            // Since the currNode is the required position 
         	// Unlink currNode from linked list 
         	// Display the message 
            if (i == index) {
               previousNode.next = currNode.next;
               System.out.println(index + " position element deleted"); 
               return list;
            }
            // If current position is not the index 
         	// continue to next node 
            previousNode = currNode;
            currNode = currNode.next;
            ++i;
         }
      }
   	// If the position element was found, it should be at currNode 
   	// Therefore the currNode shall not be null 
   	// 
   	// CASE 3: The index is greater than the size of the linkedlist 
   	// 
   	// In this case, the currNode should be null 
      if (currNode == null) {
         // Display the message 
         System.out.println("Invalid index location.");
      }   
   	// return the List 
      return list;
   } 
   private static linkedlist removeDuplicates(linkedlist list) {
      Node currNode = list.head;
      Node previousNode = currNode; 
      Node nextNode = currNode.next;
      while (nextNode != null) {
         if (nextNode.data == currNode.data) {
            currNode.next = nextNode.next;
         }
         previousNode = currNode;
         currNode = currNode.next;
         nextNode = currNode.next;
         if (previousNode.data == currNode.data) {
            previousNode.next = currNode.next;
         }
      }
      // Implement me!
      return list;
   }

	// **************MAIN METHOD************** 

	// method to create a Singly linked list with n nodes 
   public static void main(String[] args) { 
   	/* Start with the empty list. */
      linkedlist list = new linkedlist(); 
   
   	// 
   	// ******INSERTION****** 
   	// 
   
   	// Insert the values 
      list = insert(list, 1); 
      list = insert(list, 2); 
      list = insert(list, 3); 
      list = insert(list, 4); 
      list = insert(list, 5); 
      list = insert(list, 6); 
      list = insert(list, 7); 
      list = insert(list, 8); 
   
   	// Print the linkedlist 
      printList(list); 
   
   	// 
   	// ******DELETION BY KEY****** 
   	// 
   
   	// Delete node with value 1 
   	// In this case the key is ***at head*** 
      deleteByKey(list, 1); 
   
   	// Print the linkedlist 
      printList(list); 
   
   	// Delete node with value 4 
   	// In this case the key is present ***in the middle*** 
      deleteByKey(list, 4); 
   
   	// Print the linkedlist 
      printList(list); 
   
   	// Delete node with value 10 
   	// In this case the key is ***not present*** 
      deleteByKey(list, 10); 
   
   	// Print the linkedlist 
      printList(list); 
   
   	// 
   	// ******DELETION AT POSITION****** 
   	// 
   
   	// Delete node at position 0 
   	// In this case the key is ***at head*** 
      deleteAtPosition(list, 0); 
   
   	// Print the linkedlist 
      printList(list); 
   
   	// Delete node at position 2 
   	// In this case the key is present ***in the middle*** 
      deleteAtPosition(list, 2); 
   
   	// Print the linkedlist 
      printList(list); 
   
   	// Delete node at position 10 
   	// In this case the key is ***not present*** 
      deleteAtPosition(list, 10); 
   
   	// Print the linkedlist 
      printList(list); 
                
                // Build a list with duplicates
      linkedlist duplicates = new linkedlist();
      duplicates = insert(duplicates, 1);
      duplicates = insert(duplicates, 1);
      duplicates = insert(duplicates, 1);
      duplicates = insert(duplicates, 2);
      duplicates = insert(duplicates, 3);
      duplicates = insert(duplicates, 3);
      duplicates = insert(duplicates, 4);
                // Print list with duplicates
      printList(duplicates);
                // Remove duplicates
      duplicates = removeDuplicates(duplicates);
                // Print list without duplicates
      printList(duplicates);
   } 
} 

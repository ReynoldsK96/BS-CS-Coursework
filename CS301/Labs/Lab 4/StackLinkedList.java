// Name: Katherine Reynolds
// Date: 10/27/2021
// File: StackLinkedList.java
class Car{
   private String make;
   
   public Car(String make){
      this.make = make;
   }
   
   public String toString(){
      return make;
   }
}


class Node<T>{
   
   public T data;
   public Node next;
   
   public Node(T data){
      this.data = data;
      this.next = null;
   }

}



public class StackLinkedList<T>{
   
   //Single field of type Node   
   //to represent the front of the stack
   Node<T> head;
     
   //operation push()
   public void push(T data) {
      /*
      The push operation is equivalent to the inserting a node at 
      the head of the list.
      
      */
      
      // declaring variables
      Node newNode = new Node(data);
      Node currNode = head;
      Node prevNode = currNode;
      
      // if head is null that means the list is empty and the first node is inserted
      if (head == null) {
         head = newNode;
         System.out.println(head.data + " pushed onto the stack");
      // if the node following the head is null that means that there is only one node in the list and a second is added
      } else if (head.next == null) {
         head.next = newNode;
         System.out.println(newNode.data + " pushed onto the stack");
      // otherwise the list is cycled through until the end is determined and a node is added
      } else {
         while (currNode != null) {
            prevNode = currNode;
            currNode = currNode.next; 
            if (currNode == null) {
               prevNode.next = newNode;
               System.out.println(newNode.data + " push onto the stack");
               break;
            }   
         }
      } 
   } 
      
   //operation pop()
   public void pop(){
      /*
      Pop is equivalent to deleting the node at the front
      */
      
      // declaring variables
      Node currNode = head;
      Node prevNode = currNode;
 
      // if the head is null that means the list is empty
      if (head == null) {
         System.out.println("The stack is empty");
      // if the node following the head is null that means there is only one node in the list and it is deleted
      } else if (head.next == null) {
         System.out.println(head.data + " removed from the stack");
         head = null;
      // otherwise the list is cycled through until the end is determined and that node is deleted            
      } else {
         while (currNode != null) {
            prevNode = currNode;
            currNode = currNode.next;
            if (currNode.next == null) {
               System.out.println(currNode.data + " removed from the stack");
               prevNode.next = currNode.next;
               break;
            }
         }
      }
   }
   
   //operation peek()
   public String peek() {
      /*
      Peek is equivalent to the pop operation
      but instead of removing the node, simply return the data
      */
      
      // variable declaration 
      String str = "";
      Node currNode = head;
      Node prevNode = currNode;
      
      // list is cycled through until the end is determined 
      while (currNode != null) {
         prevNode = currNode;
         currNode = currNode.next;
      }
      // end value is converted to string to be returned
      str = String.valueOf(prevNode.data);
      return str;
   }        
   
   
   //operation print()
   public void print() {
      /*
      Walk through the list (stack) and print it out.
      */
      
      // variable declaration
      Node temp = head;
      
      // while loop that cycles through the list and prints out each node
      while (temp != null) {
         System.out.print(temp.data + ", ");
         temp = temp.next;
      }
      System.out.println();
   }
   
   
   //main()
   public static void main(String[] args){
       /*
      Test cases have been set up to test the program. The stack will be 
      populated with different types.
      You can comment them out when while implementing the operations. 
      */
      
      StackLinkedList s1 = new StackLinkedList();
      s1.push(new Car("Honda"));
      s1.push(new Car("BMW")); 
      s1.print();
      
      System.out.println("top of the stack: "+ s1.peek());
      
      s1.pop();
      s1.print();
      
      s1.push(new Car("Mercedes"));
      s1.print();
      
      s1.pop();
      s1.pop();
      s1.pop();
      System.out.println("\n--------------------------------\n");
      
      
      StackLinkedList s2 = new StackLinkedList();
      s2.push(10);
      s2.push(20); 
      s2.print();
      
      System.out.println("top of the stack: "+ s2.peek());
      
      s2.pop();
      s2.print();
      
      s2.push(30);
      s2.print();
      
      s2.pop();
      s2.pop();
      s2.pop();
      System.out.println("\n--------------------------------\n");
   
   
   
      StackLinkedList s3 = new StackLinkedList();
      s3.push("cat");
      s3.push("dog"); 
      s3.print();
      
      System.out.println("top of the stack: "+ s3.peek());
      
      s3.pop();
      s3.print();
      
      s3.push("tiger");
      s3.print();
      
      s3.pop();
      s3.pop();
      s3.pop();
   }
   
}

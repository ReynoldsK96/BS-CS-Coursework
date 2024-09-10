// Name: Katherine Reynolds
// Date: 01/24/2022
// File: BST.java

import java.io.*;
import java.util.*;

public class BST {
   /**
    *  Problem: Perform rotations on tree1 to make it equivalent to tree2.
    */
   public static void problem(BST tree1, BST tree2) {
      
      // create arrays out of the two trees for comparison
      int[] arr1 = tree1.getPreOrder();
      int[] arr2 = tree2.getPreOrder();
      
      //for loop to check to see if the tree structure is the same
      for (int i = 0; i < arr1.length; i++) {
         // if the the i elements of the arrays don't match they do not have the same structure
         if (arr1[i] != arr2[i]) {
    
           // find where the matching node node in tree1 is
           Node match = tree1.find(arr2[i]);
           
           // while loop to move the node into the correct place
           while (arr1[i] != arr2[i] && match != tree1.root) {
               
               // parent of matching node
               Node matchParent = match.parent;
  
               // if match node is larger than its parent, rotate to the left
               if (match.key > matchParent.key) {
                  tree1.rotateL(matchParent);
                  // update array to match new preorder order of tree1 after rotation
                  arr1 = tree1.getPreOrder();
               // else if match node is not larger than its parent, rotate to the right
               } else {
                  tree1.rotateR(matchParent);
                  // update array to match new preorder order of tree1 after rotation
                  arr1 = tree1.getPreOrder();
               }
            }
         }
      }
      return;
   }

   // ---------------------------------------------------------------------
   // Do not change any of the code below!

   private class Node {
      public Node left = null;
      public Node right = null;
      public Node parent = null;
   
      public int key;
   
      public Node(int key) {
         this.key = key;
      }
   }

   private Node root = null;

   public int getRootKey() {
      return root.key;
   }

   private Node find(int key) {
      for (Node cur = root; cur != null;) {
         if (key < cur.key) {
            cur = cur.left;
         } else if (key == cur.key) {
            return cur;
         } else { // key > cur.key
            cur = cur.right;
         }
      }
      return null;
   }

   //     x            y
   //    / \          / \
   //   a   y   =>   x   c
   //      / \      / \
   //     b   c    a   b
   private void rotateL(Node xNode) {
      Node xPar = xNode.parent;
      boolean isRoot = xPar == null;
      boolean isLChild = !isRoot && xPar.left == xNode;
   
      Node yNode = xNode.right;
      Node beta = yNode.left;
   
      if (isRoot) root = yNode;
      else if (isLChild) xPar.left = yNode;
      else xPar.right = yNode;
   
      yNode.parent = xPar;
      yNode.left = xNode;
   
      xNode.parent = yNode;
      xNode.right = beta;
   
      if (beta != null) beta.parent = xNode;
   }

   //     y        x
   //    / \      / \
   //   x   c => a   y
   //  / \          / \
   // a   b        b   c
   private void rotateR(Node yNode) {
      Node yPar = yNode.parent;
      boolean isRoot = yPar == null;
      boolean isLChild = !isRoot && yPar.left == yNode;
   
      Node xNode = yNode.left;
      Node beta = xNode.right;
   
      if (isRoot) root = xNode;
      else if (isLChild) yPar.left = xNode;
      else yPar.right = xNode;
   
      xNode.parent = yPar;
      xNode.right = yNode;
   
      yNode.parent = xNode;
      yNode.left = beta;
   
      if (beta != null) beta.parent = yNode;
   }

   public void insert(int key) {
      if (root == null) {
         root = new Node(key);
         return;
      }
   
      Node par = null;
   
      for (Node node = root; node != null;) {
         par = node;
      
         if (key < node.key) {
            node = node.left;
         } else if (key > node.key) {
            node = node.right;
         } else { // key == node.key
            // Nothing to do, because no value to update.
            return;
         }
      }
   
      // Create node and set pointers.
      Node newNode = new Node(key);
      newNode.parent = par;
   
      if (key < par.key) par.left = newNode;
      else par.right = newNode;
   }

   public int[] getInOrder() {
      if (root == null) 
         return new int[] { };
   
      Stack<Node> stack = new Stack<Node>();
      ArrayList<Integer> orderList = new ArrayList<Integer>();
   
      for (Node node = root;;) {
         if (node == null) {
            if (stack.empty()) 
               break;
         
            node = stack.pop();
            orderList.add(node.key);
            node = node.right;
         } else {
            stack.push(node);
            node = node.left;
         }
      }
   
      int[] order = new int[orderList.size()];
      for (int i = 0; i < order.length; i++) {
         order[i] = orderList.get(i);
      }
   
      return order;
   }

   public int[] getPreOrder() {
      if (root == null) 
         return new int[] { };
   
      Stack<Node> stack = new Stack<Node>();
      ArrayList<Integer> orderList = new ArrayList<Integer>();
   
      for (Node node = root;;) {
         if (node == null) {
            if (stack.empty()) 
               break;
         
            node = stack.pop();
            node = node.right;
         } else {
            orderList.add(node.key);
            stack.push(node);
            node = node.left;
         }
      }
   
      int[] order = new int[orderList.size()];
      for (int i = 0; i < order.length; i++) {
         order[i] = orderList.get(i);
      }
   
      return order;
   }
}

// Name: Katherine Reynolds
// Date: 04/06/21
// File: DocumentFixer.java

// sets up use of file and scanner methods
import java.io.*;
import java.util.Scanner;

public class DocumenfFixer { 
   // main method that declare variable file that will is being manipulated and
   // calls the method that will manipulate the file
   public static void main(String[] args) throws IOException {
      
      // declaring variable
      String fileName = "Employees.txt";
      // calling fixDocument method I wrote
      fixDocument(fileName);
   }
   
   // method that manipulates the file so that the salary is adjusted by 
   // 3% and comes in front of the employee's ID number
   public static void fixDocument(String fileName) throws IOException {
      // declaring variables, setting up scanner, and setting up filewriter
      File myFile = new File(fileName);
      Scanner inputFile = new Scanner(myFile);
      FileWriter updatedFile = new FileWriter("EmployeesUpdatedSalaries.txt");
      PrintWriter out = new PrintWriter(updatedFile);
      
      // arrays for the different information parts that are being manipulated
      String[] employeeNames = new String[483];
      String[] employeeIDs = new String[483];
      int[] employeeSalaries = new int[483];
      
      // for loop that seperates employee names, IDs, and salaries and adjusts and manipulates
      // them into the desired amount and position i.e., name, salary increased by 3%, ID
      for (int i = 0; i < 483; i++) {
         String lines = inputFile.nextLine();
         String[] tokens = lines.split(",");
         employeeNames[i] = tokens[0];
         employeeIDs[i] = tokens[1];
         employeeSalaries[i] = Integer.parseInt(tokens[2].substring(1));
         employeeSalaries[i] *= 1.03;
         out.println(employeeNames[i] + ", " + "$" + employeeSalaries[i] + ", " + employeeIDs[i]);
      }
      out.close();
      updatedFile.close();
   }
}
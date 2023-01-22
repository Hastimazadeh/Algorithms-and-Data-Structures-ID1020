//Hasti Mohebali Zadeh
//12 - September - 2020

//Input: Integers as: size of array and then the array itself
//Output: the content of the array that is being sorted is printed after each inner loop iteration

package task1;

import java.util.Scanner;

public class Task1main {

	public static void main(String[] args)  {
		
		 
		 Scanner input = new Scanner(System.in);
		 
	     System.out.println("Enter the size of the array:");
	     int size = input.nextInt();
	    
	     int [] sequence = new int[size];
	     
	      System.out.println("Enter the integers of the array:");
	      for(int j=0; j<size; j++ ) {
	        sequence[j] = input.nextInt();
	    	 
	      }
		
		Task1.print(sequence);
		System.out.println ();
		Task1.insertSort (sequence);

	}
	
	

}

//Hasti Mohebali Zadeh
//12 - September - 2020

//Input: Integers as: size of array and then the array itself
//Output: the content of the array that is being sorted is printed after each inner loop iteration and The number of swaps in an array 
//as well as the number of inversions. Number of inversions is equal with the number of each smaller element to the right of each element

package task3;

import java.util.Scanner;

public class Task3main {

	public static void main(String[] args) {

		 Scanner input = new Scanner(System.in);
		 
	     System.out.println("Enter the size of the array:");
	     int size = input.nextInt();
	    
	     int [] sequence = new int[size];
	     
	      System.out.println("Enter the integers of the array:");
	      for(int j=0; j<size; j++ ) {
	        sequence[j] = input.nextInt();
	    	 
	      }
		Task3.inversion(sequence);
		Task3.print(sequence);
		System.out.println ();
		Task3.insertSort (sequence);

	}

}

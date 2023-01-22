//Hasti Mohebali Zadeh
//15 - September - 2020

//Input: Integers as: size of array and then the array itself
//Output: the content of the array that is being sorted is printed after each inner loop iteration
//the array is printed in descending order

package extra1;

import java.util.Scanner;


public class Extra1main {

	public static void main(String[] args) {
		 
		 Scanner input = new Scanner(System.in);
		 
	     System.out.println("Enter the size of the array:");
	     int size = input.nextInt();
	    
	     int [] sequence = new int[size];
	     
	      System.out.println("Enter the integers of the array:");
	      for(int j=0; j<size; j++ ) {
	        sequence[j] = input.nextInt();
	    	 
	      }
		System.out.println("your array is : ");
		Extra1.print(sequence);
		System.out.println ();
		
		Extra1.insertSort (sequence);
		System.out.println ();
		
		//adding O(N) operation once after it being sorted  
		for(int i = 0; i < size/2; i++) { //explain from the picture
			sequence[i]=sequence[i]+sequence[size-1-i] ;
			sequence[size-1-i] = sequence[i]-sequence[size-1-i];
			sequence[i] = sequence[i]-sequence[size-1-i];
		
		}
		System.out.println("your sorted array in descending order is : ");
		Extra1.print(sequence);

	}

}

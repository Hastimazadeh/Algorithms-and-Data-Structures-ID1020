//Hasti Mohebali Zadeh
//12 - September - 2020

//Implementing insertion sort that all the content of the array that is being sorted is printed after each inner loop iteration.
//having a test in main() which allows the user to define the size of the input and then input integers from stdin which is to be sorted.
//printing the number of swaps performed when sorting the array.

package task2;

public class Task2 {
	

	public static void insertSort(int[] sequence) {
		int e = 0;
		int holePos = 0;
		int swap = 0;
		//Starting with the 2nd position as the partition with 1 elements is already sorted.
		for (int i = 1; i < sequence.length; i++) { //going through the array
			e = sequence[i]; //setting e to the values inside array
			holePos = i; //setting the hole position to where e is
			
			while(holePos>0 && e<sequence[holePos -1]) { //if e is less than the value before it
				sequence[holePos]=sequence[holePos-1]; //both e and the one before(hole pos and hole pos-1) it are now the bigger number(the one before e aka holepos-1)
				//and now we set the one before e (holepos -1) to the smaller number which was e
				sequence[holePos-1]= e; //so now the smaller number is before the bigger number 
				holePos--;
		        swap++; ///////if (sequence[holePos] != e) //the swap had to be in outer loop for 2 swaps
				print(sequence);//printing each inner loop iteration sequence
			}
			sequence[holePos]=e;// this is for the case when it doesn't go in the while
			//but in fact its doing the same thing as what we did [holePos-1]= e; cause after than line we holepos--
		}
		System.out.println();
		System.out.println("The sorted list: ");
		System.out.println();
		print(sequence); //printing out the final array
		System.out.println("The number of swaps performed : " + swap);
	}
	
	
	 public static void  print (int [] sequence) { //a printing method
		 for (int elements : sequence) //going through each element in the array
			 System.out.print("[" + elements + "]"); //printing them out with brackets 
		 System.out.println();
	 }

}

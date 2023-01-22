//Hasti Mohebali Zadeh
//15 - September - 2020

//Implementing two sorting method (merge and insertion)
//insertion code is from task1 and merge code is from task5
//we experiment with the cut-off to insertion sort in merge.
//A suitable range for cut-off values to test with could be [0-30].
//input : random integers from fill method
//output : printing out the runtime

package task6;

import java.util.Random;

public class Task6 {

	public static void insertSort(int[] sequence) { 

		int e = 0;
		int holePos = 0;
		//Starting with the 2nd position as the partition with 1 elements is already sorted.
		for (int i = 1; i < sequence.length; i++) { //going through the array
			e = sequence[i]; //setting e to the values inside array
			holePos = i; //setting the hole position to where e is

			while(holePos>0 && e<sequence[holePos -1]) { //if e is less than the value before it
				sequence[holePos]=sequence[holePos-1]; //both e and the one before(hole pos and hole pos-1) it are now the bigger number(the one before e aka holepos-1)
				//sequence[holePos-1]= e;//and now we set the one before e (holepos -1) to the smaller number which was e
				//we swapped here 
				holePos--;
			}
			sequence[holePos]=e; // this is for the case when it doesn't go in the while
			//but in fact its doing the same thing as what we did [holePos-1]= e; cause after than line we holepos--
		}
	} 
	//*****************************************************************************************************************************************
	
	 
	public static final int CUTOFF = 2;
	public static void merge(int[] array, int low, int high) {
		if (high <= low) return;

		// low is the lower boundary of the elements being sorted.
		// high is the higher boundary of the elements being sorted.
		// mid is the cut off between the low and high boundaries.
		
		if (high-low+1<CUTOFF) { // 0 to 30    high - low
			insertSort(array);
			return;}
		
		int mid = (low+high)/2;
		
		merge(array, low, mid);
		merge(array, mid+1, high);
		mergeSort(array, low, mid, high);
	}
	//will merge the results in the correct order.
	//Merges two parts of an arrays by first copying into the auxiliary array, sorting the elements and then merging back
	//the sorted elements to the original array.
	public static void mergeSort(int[] array, int low, int mid, int high) {
		// Creating temporary subarrays
		int leftArray[] = new int[mid - low + 1]; //number of elements in it
		int rightArray[] = new int[high - mid];

		// Copying our subarrays into temporaries
		for (int i = 0; i < leftArray.length; i++)
			leftArray[i] = array[low + i];
		for (int i = 0; i < rightArray.length; i++)
			rightArray[i] = array[mid + 1 + i];

		// Iterators containing current index of temp subarrays
		int leftIndex = 0;
		int rightIndex = 0;

		// Copying from leftArray and rightArray back into array
		for (int i = low; i < high + 1; i++) {
			// If there are still uncopied elements in R and L, copy minimum of the two
			if (leftIndex < leftArray.length && rightIndex < rightArray.length) {//so it doesn't fall out
				if (leftArray[leftIndex] < rightArray[rightIndex]) {
					array[i] = leftArray[leftIndex];
					leftIndex++;

				} else {
					array[i] = rightArray[rightIndex];
					rightIndex++;
				}
				//one of the arrays is done and the other one couldn't catch up so we do it separately for them here
			} else if (leftIndex < leftArray.length) {
				// If all elements have been copied from rightArray, copy rest of leftArray
				array[i] = leftArray[leftIndex];
				leftIndex++;

			} else if (rightIndex < rightArray.length) {
				// If all elements have been copied from leftArray, copy rest of rightArray
				array[i] = rightArray[rightIndex];
				rightIndex++;   
			}

		}
	}
	//******************************************************************************************

	public static void fill(int[]arrayI, int []arrayM) {
		int i = 0;
		int low = -99;
		int high = 100;
		Random r = new Random();
		while(i < arrayI.length)
		{
			int n = r.nextInt(high - low) + low;
			arrayI[i] = n;
			arrayM[i] = n;
			i++;
		}
	}
	public static void main(String[] args) {

		int [] arrayIn = new int [10000];
		int [] arrayMe = new int [10000];

		fill(arrayIn, arrayMe);

		//printing the arrays that are not sorted

		// System.out.println(Arrays.toString(arrayIn));
		//	System.out.println();
		//	System.out.println(Arrays.toString(arrayMe));
		//	System.out.println(); 


		long startTimeMerge;
		long endTimeMerge;
		long runTime;
		startTimeMerge = System.nanoTime();
		Task6.merge(arrayMe, 0, arrayMe.length-1); //inja cut off o avaz mikonam
		endTimeMerge = System.nanoTime();
		runTime = endTimeMerge - startTimeMerge;

		// Print runtime in nanoseconds
				System.out.println(" runtime is : " + (runTime));}
		

		// Print sorted collection

		//	System.out.println(Arrays.toString(arrayIn));
		//System.out.println();
		//	System.out.println(Arrays.toString(arrayMe));
		//	System.out.println(); 


}
/* 0 runtime is : 3794400
 * 1 runtime is : 3898200
 * 2 runtime is : 3757300
 * 3 runtime is : 81257200
 * 4 runtime is : 81581400
 * 5 runtime is : 79851500
   6 runtime is : 61736300
   7 runtime is : 62773300
   8 runtime is : 65051700
   9 runtime is : 63471400
  10 runtime is : 65032300
  11 runtime is : 58203700
  12 runtime is : 55725800
  13 runtime is : 54814700
  14 runtime is : 52816900
  15 runtime is : 52400600
  16 runtime is : 57280600
  17 runtime is : 55691500
  18 runtime is : 56087400
  19 runtime is : 57340200
  20 runtime is : 50991300
  21 runtime is : 47670500
  22 runtime is : 45995800
  23 runtime is : 47404000
  24 runtime is : 46833600
  25 runtime is : 45248900
  26 runtime is : 45202900
  27 runtime is : 45015300
  28 runtime is : 46429500
  29 runtime is : 45366500
  30 runtime is : 46255200
 * */	

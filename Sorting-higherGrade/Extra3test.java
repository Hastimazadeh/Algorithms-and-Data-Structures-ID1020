//Hasti Mohebali Zadeh
//18 - September - 2020

//Implementing two sorting method (Quick with the first and middle element as pivot)
//Quick sort method with the first element as pivot is from task extra 2
//we compare the execution times for both of them in main for different size of arrays
//input : random integers from fill method
//output : printing out the runtime for both sorting methods

package extra3;

import java.util.Arrays;
import java.util.Random;

public class Extra3test {


	public static void swap(int[]array, int i, int j){
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	public static void quickSortM(int[]array, int low, int high) {
		if (high <= low)return;

		int middle = low + (high - low) / 2;
		//to make sure its the median of three
		//so that there is one smaller element and one bigger element than it before and after
		if(array[middle]<array[low])
			swap (array,low, middle);
		if(array[high]<array[low])
			swap (array,low, high);
		if(array[high]<array[middle])
			swap (array,middle, high);
		
		int pivot = array[middle];

		int l = low;
		int h = high;
		// calculate pivot number, I am taking pivot as middle index number
		// Divide into two arrays
		while (l <= h) {
			/*In each iteration, we will identify a number from left side which is greater then the pivot value, and also we will identify a number 
	              from right side which is less then the pivot value. Once the search is done, then we exchange both numbers.*/

			// If the current value from the left list is smaller than the pivot element then get the next element from the left list cause that one should stay there
			while (array[l] < pivot) {
				l++;
			}
			// If the current value from the right list is larger than the pivot element then get the next element from the right list  cause that one should stay there
			while (array[h] > pivot) { 
				h--;
			}
			//If we have found a value in the left list which is larger than
			// the pivot element and if we have found a value in the right list
			// which is smaller than the pivot element then we exchange them (when it didn't go in the while)
			if (l <= h) {
				//swapping
				int temp = array[l];
				array[l] = array[h];
				array[h] = temp;
				//move index to next position on both sides
				// As we are done we can increase i and j
				l++;
				h--;
			}
		}
		// recursively sort two sub parts 
		if (low < h)
			quickSortM(array,low, h);//left side cause h --d and reached the right half
		if (l < high)
			quickSortM(array,l, high);//right side
	}

	

	//*****************************************************************************************************************

	public static void quickSortF(int[]array, int low, int high){
		if(low<high){
			int index=partitionF(array,low,high); //index = h
			quickSortF(array,low,index-1); //quicksorting the left side low to h-1
			quickSortF(array,index+1,high);//quicksorting the right side h+1 to high
		}
		return;
	}
	public static int partitionF(int[]array, int low, int high){
		int pivot = low;
		int l = low;
		int h= high;

		/*In each iteration, we will identify a number from left side which is greater then the pivot value, and also we will identify a number 
        from right side which is less then the pivot value. Once the search is done, then we exchange both numbers.*/
		while (l< h){
			// If the current value from the left list is smaller than the pivot element then get the next element from the left list cause that one should stay there
			while(array[l]<= array[pivot] && l< high){
				l++;
			}
			// If the current value from the right list is larger than the pivot element then get the next element from the right list  cause that one should stay there
			while(array[h]> array[pivot] && h > low){
				h--;
			}
			//If we have found a value in the left list which is larger than
			// the pivot element and if we have found a value in the right list
			// which is smaller than the pivot element then we exchange the
			if(l< h){
				swap(array,l,h);
			}
		}
		swap(array,h,pivot);// pivot element goes to it right place(almost in the middle) and h goes in the first
		return h; //return for partition  h is the biggest smaller number than pivot
	}

	

	

	//********************************************************************************
	public static void fill(int[]arrayF, int []arrayM) {
		int i = 0;
		int low = -99;
		int high = 100;
		Random r = new Random();
		while(i < arrayM.length)
		{
			int n = r.nextInt(high - low) + low;
			arrayF[i] = n;
			arrayM[i] = n;
			i++;
		}
	}
	public static void main(String[] args) {

		int [] arrayFi = new int [5];
		int [] arrayMi = new int [5];

		fill(arrayFi, arrayMi);
		
		//printing the arrays that are not sorted

	/*	System.out.println(Arrays.toString(arrayFi));
		System.out.println();
		System.out.println(Arrays.toString(arrayMi));
		System.out.println(); */

		/*	for (int i = 0; i < arrayQu.length; i++) {
				    System.out.print(arrayIn[i] + ",");
				}
				System.out.println();

				for (int i = 0; i < arrayMe.length; i++) {
				    System.out.print(arrayMe[i] + ",");
				}*/

		/*long startTimeQuick = System.nanoTime();
				Extra2.quickSort(arrayQu,0,arrayQu.length-1);
				long endTimeQuick = System.nanoTime();*/

		long startTimeM;
		long endTimeM;
		long mTime;
		long startTimeF;
		long endTimeF;
		long fTime;

		
		startTimeF = System.nanoTime();
		quickSortF(arrayFi,0,arrayFi.length-1);
		endTimeF = System.nanoTime();
		fTime = endTimeF - startTimeF;
		System.out.println("Quick Sort First runtime:  " + (fTime));

		startTimeM = System.nanoTime();
		quickSortM(arrayMi, 0, arrayMi.length-1);
		endTimeM = System.nanoTime();
		mTime = endTimeM - startTimeM;
		System.out.println("Quick Sort Middle runtime: " + (mTime));
		
		// Print sorted collection
	/*  System.out.println(); 
		System.out.println("first sorted:");
		System.out.println(Arrays.toString(arrayFi));
		System.out.println(); 
		System.out.println("midlle sorted:");
		System.out.println(Arrays.toString(arrayMi));*/


		/*for (int i = 0; i < arrayMe.length; i++) {
				    System.out.print(arrayMe[i] + ",");
				}
				System.out.println();
				for (int i = 0; i < arrayQu.length; i++) {
				    System.out.print(arrayIn[i] + ",");
				}
				System.out.println();*/




	}



}
/*
 * for 10 elements
first test
Quick Sort First runtime:  7200
Quick Sort Middle runtime: 6800
second test
Quick Sort First runtime:  7500
Quick Sort Middle runtime: 6200
thirst test
Quick Sort First runtime:  8700
Quick Sort Middle runtime: 7200

for 100 elements
first test
Quick Sort First runtime:  35300
Quick Sort Middle runtime: 30900
second test
Quick Sort First runtime:  34500
Quick Sort Middle runtime: 27800
thirst test
Quick Sort First runtime:  36200
Quick Sort Middle runtime: 28300

for 1000 elements
first test
Quick Sort First runtime:  778700
Quick Sort Middle runtime: 443300
second test
Quick Sort First runtime:  886300
Quick Sort Middle runtime: 425300
thirst test
Quick Sort First runtime:  681700
Quick Sort Middle runtime: 399300

for 10000 elements
first test
Quick Sort First runtime:  3709100
Quick Sort Middle runtime: 3779200
second test
Quick Sort First runtime:  3876000
Quick Sort Middle runtime: 2653600
thirst test
Quick Sort First runtime:  3734000
Quick Sort Middle runtime: 3192100

for 100000 elements
merge is faster now
first test
Quick Sort First runtime:  30873900
Quick Sort Middle runtime: 12484800
second test
Quick Sort First runtime:  37224100
Quick Sort Middle runtime: 11585600
thirst test
Quick Sort First runtime:  40298300
Quick Sort Middle runtime: 32529400



 */

//Hasti Mohebali Zadeh
//14 - September - 2020

//Implementing two sorting method (merge and insertion)
//insertion code is from task1
//we compare the execution times for both of them in main for different size of arrays
//input : random integers from fill method
//output : printing out the runtime for both sorting methods(insertion and merge)

package Task5;

import java.util.Random;

public class Task5 {

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
	// Main function that sorts array[low...high] using merge() 
	public static void mergeSort(int[] array, int low, int high) {
		if (high <= low) return;
		//low is the lower boundary of the elements being sorted.
		//high is the higher boundary of the elements being sorted.
		//mid is the cut off between the low and high boundaries.
		int mid = (low+high)/2;
		// Sort first and second halves 
		mergeSort(array, low, mid);
		mergeSort(array, mid+1, high);
		//Merge the sorted halves 
		merge(array, low, mid, high);
	}
	//will merge the results in the correct order.
	//Merges two parts of an arrays by first copying into the auxiliary array, sorting the elements and then merging back
	//the sorted elements to the original array.
	public static void merge(int[] array, int low, int mid, int high) {
		// Creating temporary subarrays
		int leftArray[] = new int[mid - low + 1]; //number of elements in it
		int rightArray[] = new int[high - mid];

		// Copying our data of subarrays into temporaries
		for (int i = 0; i < leftArray.length; i++)
			leftArray[i] = array[low + i];
		for (int i = 0; i < rightArray.length; i++)
			rightArray[i] = array[mid + 1 + i];

		// Iterators containing current index of temp subarrays(counters)
		int leftIndex = 0;
		int rightIndex = 0;

		//merging subarrays together
		// Copying from leftArray and rightArray back into array
		for (int i = low; i < high + 1; i++) {

			// If there are still uncopied elements in R and L, copy minimum of the two
			if (leftIndex < leftArray.length && rightIndex < rightArray.length) {//so each of(counters) them wont fall out of their arrays //A & B
				if (leftArray[leftIndex] < rightArray[rightIndex]) {
					array[i] = leftArray[leftIndex]; //in our array now the smaller one goes
					leftIndex++; //going to the next one to check

				} else { //rightArray[rightIndex]<leftArray[leftIndex]
					array[i] = rightArray[rightIndex];//in our array now the smaller one goes
					rightIndex++;//going to the next one to check
				}
				//one of the arrays is done and the other one couldn't catch up so we do it separately for them here
				//Copy remaining elements of leftArray[] if any
			} else if (leftIndex < leftArray.length) { //A
				// If all elements have been copied from rightArray, copy rest of leftArray
				array[i] = leftArray[leftIndex];
				leftIndex++;

				//Copy remaining elements of rightArray[] if any
			} else if (rightIndex < rightArray.length) {//B
				// If all elements have been copied from leftArray, copy rest of rightArray
				array[i] = rightArray[rightIndex];
				rightIndex++;   
			}

		}
	}
	//****************************************************************************************************************************************
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

		/*  System.out.println(Arrays.toString(arrayIn));
		System.out.println();
		System.out.println(Arrays.toString(arrayMe));
		System.out.println(); */

		/*	for (int i = 0; i < arrayIn.length; i++) {
		    System.out.print(arrayIn[i] + ",");
		}
		System.out.println();
		for (int i = 0; i < arrayMe.length; i++) {
		    System.out.print(arrayMe[i] + ",");
		}*/
		
		long startTimeInsert;
		long endTimeInsert;
		long insertTime;
		long startTimeMerge;
		long endTimeMerge;
		long mergeTime;

		startTimeInsert = System.nanoTime();
		insertSort(arrayIn);
		endTimeInsert = System.nanoTime();
		insertTime = endTimeInsert - startTimeInsert;
		System.out.println("Insertion Sort runtime: " + (insertTime));

		startTimeMerge = System.nanoTime();
		mergeSort(arrayMe, 0, arrayMe.length-1);
		endTimeMerge = System.nanoTime();
		mergeTime = endTimeMerge - startTimeMerge;
		System.out.println("Merge Sort runtime:     " + (mergeTime));

		// Print sorted collection

		/*System.out.println(Arrays.toString(arrayIn));
		System.out.println();
		System.out.println(Arrays.toString(arrayMe));
		System.out.println(); */

		/*for (int i = 0; i < arrayMe.length; i++) {
		    System.out.print(arrayMe[i] + ",");
		}
		System.out.println();
		for (int i = 0; i < arrayIn.length; i++) {
		    System.out.print(arrayIn[i] + ",");
		}
		System.out.println();*/



	}
}
/*
 * for 10 elements
first test
Insertion Sort runtime: 2500
Merge Sort runtime:     8500
second test
Insertion Sort runtime: 2500
Merge Sort runtime:     9500
thirst test
Insertion Sort runtime: 2900
Merge Sort runtime:     9100

for 100 elements
first test
Insertion Sort runtime: 87700
Merge Sort runtime:     124100
second test
Insertion Sort runtime: 54400
Merge Sort runtime:     62600
thirst test
Insertion Sort runtime: 43000
Merge Sort runtime:     92000

for 1000 elements
(merge is faster from now on)
first test
Insertion Sort runtime: 2530700
Merge Sort runtime:     1318900
second test
Insertion Sort runtime: 2138300
Merge Sort runtime:     922100
thirst test
Insertion Sort runtime: 2634200
Merge Sort runtime:     1335600

for 10000 elements
first test
Insertion Sort runtime: 30943900
Merge Sort runtime:     2775700
second test
Insertion Sort runtime: 35784300
Merge Sort runtime:     2573500
thirst test
Insertion Sort runtime: 32064400
Merge Sort runtime:     2720100

 */
/*Time Complexity: 
In Merge Sort the Worst Case: O(N*log N), Average Case: O(N*log N), and Best Case: O(N*log N),
In Insertion Sort the Worst Case: O(N2), Average Case: O(N2), and Best Case: O(N).

Space Complexity: 
Merge sort being recursive takes up the auxiliary space complexity of O(N) hence it cannot be preferred over the place where memory is a problem,
In Insertion sort only takes O(1) auxiliary space complexity. It sorts the entire array just by using an extra variable.

Data sets: Merge Sort is preferred for huge data sets. It happens to compare all the elements present in the array hence is not much helpful for small data sets
Insertion Sort is preferred for fewer elements. It becomes fast when data is already sorted or nearly sorted because it skips the sorted values.
Efficiency: Considering average time complexity of both algorithm we can say that Merge Sort is efficient in terms of time and Insertion Sort is efficient in terms of space.*/

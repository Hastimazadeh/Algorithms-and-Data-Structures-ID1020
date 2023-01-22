//Hasti Mohebali Zadeh
//17 - September - 2020

//Implementing two sorting method (merge and Quick)
//merge code is from task5
//we compare the execution times for both of them in main for different size of arrays
//input : random integers from fill method
//output : printing out the runtime for both sorting methods(quick and merge)
//input : random integers from fill method
//output : printing out the runtime for both sorting methods(quick and merge)

package extra2;

import java.util.Random;

public class Extra2test {


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

	public static int partition(int[]array, int low, int high){
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

	private static void swap(int[]array, int i, int j){
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	public static void quickSortF(int[]array, int low, int high){
		if(low<high){
			int index=partition(array,low,high); //index = h
			quickSortF(array,low,index-1); //quicksorting the left side low to h-1
			quickSortF(array,index+1,high);//quicksorting the left side h+1 to high
		}
		return;
	
	}
	//**************************************************************************************************************************
	
	public static void fill(int[]arrayQ, int []arrayM) {
		int i = 0;
		int low = -99;
		int high = 100;
		Random r = new Random();
		while(i < arrayM.length)
		{
			int n = r.nextInt(high - low) + low;
			arrayQ[i] = n;
			arrayM[i] = n;
			i++;
		}
	}
	public static void main(String[] args) {

		int [] arrayQu = new int [1000000];
		int [] arrayMe = new int [1000000];

		fill(arrayQu, arrayMe);

		//printing the arrays that are not sorted

		/*  System.out.println(Arrays.toString(arrayQu));
				System.out.println();
				System.out.println(Arrays.toString(arrayMe));
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

		long startTimeMerge;
		long endTimeMerge;
		long mergeTime;
		long startTimeQuick;
		long endTimeQuick;
		long quickTime;

		startTimeQuick = System.nanoTime();
		quickSortF(arrayQu,0,arrayQu.length-1);
		endTimeQuick = System.nanoTime();
		quickTime = endTimeQuick - startTimeQuick;
		System.out.println("Quick Sort runtime: " + (quickTime));
		
		startTimeMerge = System.nanoTime();
		mergeSort(arrayMe, 0, arrayMe.length-1);
		endTimeMerge = System.nanoTime();
		mergeTime = endTimeMerge - startTimeMerge;
		System.out.println("Merge Sort runtime: " + (mergeTime));

		// Print sorted collection

		/*	System.out.println(Arrays.toString(arrayQu));
				System.out.println();
				System.out.println(Arrays.toString(arrayMe));
				System.out.println(); */

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
Quick Sort runtime: 9200
Merge Sort runtime: 12700
second test
Quick Sort runtime: 7700
Merge Sort runtime: 11300
thirst test
Quick Sort runtime: 8500
Merge Sort runtime: 11000

for 100 elements
first test
Quick Sort runtime: 37200
Merge Sort runtime: 79900
second test
Quick Sort runtime: 43200
Merge Sort runtime: 84200
thirst test
Quick Sort runtime: 39200
Merge Sort runtime: 80700

for 1000 elements
first test
Quick Sort runtime: 822900
Merge Sort runtime: 1378800
second test
Quick Sort runtime: 441200
Merge Sort runtime: 856500
thirst test
Quick Sort runtime: 762200
Merge Sort runtime: 853400

for 10000 elements
first test
Quick Sort runtime: 3539700
Merge Sort runtime: 3949100
second test
Quick Sort runtime: 3269900
Merge Sort runtime: 4275500
thirst test
Quick Sort runtime: 5204000
Merge Sort runtime: 6030000

for 100000 elements
merge is faster now
first test
Quick Sort runtime: 33117500
Merge Sort runtime: 22243700
second test
Quick Sort runtime: 33680600
Merge Sort runtime: 25546700
thirst test
Quick Sort runtime: 27429500
Merge Sort runtime: 20449400

for 1000000 elements
first test
Quick Sort runtime: 680553200
Merge Sort runtime: 151938500
second test
Quick Sort runtime: 682692400
Merge Sort runtime: 144248900
thirst test
Quick Sort runtime: 667708300
Merge Sort runtime: 136171000

 */
/*
Time Complexity: 
The worst case complexity of quick sort is O(n squared) as there is need of lot of comparisons in the worst condition.
average case is O(n log(n)).Best case is the same as average.
In merge sort, worst case and average case has same complexities O(n log n).

Data sets:
Merge sort works faster than quick sort in case of larger array size or data sets.
Quick sort  works faster than merge sort in case of smaller array size or data sets.


Space Complexity: 
Merge sort requires additional memory space to store the auxiliary arrays. On the other hand,
the quick sort doesn’t require much space for extra storage.

Conclusion
The quick sort is faster cases but is inefficient in some situations and also performs a lot of comparisons 
as compared to merge sort. Although merge sort requires less comparison, it needs an 
additional memory space of 0(n) for storing the extra array while quick sort needs space of O(log n).
 */
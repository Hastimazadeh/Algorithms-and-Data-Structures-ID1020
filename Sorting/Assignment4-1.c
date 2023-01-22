//Hasti Mohebali Zadeh
//13 - September - 2020
//Input: Integers as follows: size of the array and then the array itself
//Output: The array printed as first it is negative numbers, then 0's and then positive numbers
//This code traverses the array twice: once for any negative numbers it swaps them into the beggining, saves the index and then it traverses it starting from that index to place the 0's.

#include <stdio.h>

void swap(int *arr, int i, int j){ //"inter" variable for swapping and that's the extra 1 element of memory
  int inter = arr[i];
  arr[i] = arr[j];
  arr[j] = inter;
  }

void order(int *array, int size){
  int h = 0;
  int current = 0;
  for(h = 0; h < size; h++) //going throgh the array
    if(array[h] < 0){ //if array[h] is negative swap it with the one before and then go to the next element
      swap(array,h,current);
      current++;} //this only increments if we enter the if meaning that its negative

//so far everything before c is negative

   for(h = current; h < size; h++)
     if(array[h] == 0){
        swap(array,h,current);
        current++;
  	}
    // show the picture for this part
      for(h = 0; h < size; h++)
        printf("%d   ", array[h]);
}

void main(){
  int size;
  printf("Enter the size of the array : ");
  scanf("%d", &size); //getting the size that we input
  int array[size]; //setting arrays length to that size
  int k = 0;
  printf("Enter the positive and negative numbers : ");
  for(k=0; k < size; k++){
    scanf("%d", &array[k]);
    }
  order(array,size);

}

//Hasti Mohebali Zadeh
// 3 - September - 2020

//Implementing  an iterative version of a function which reads characters from stdin until a newline character is read and then prints them on stdout in reverse order.

//Input: characters from stdin
//Output: Same characters to stdout but in reverse order

#include <stdio.h>

void iterative(){

  int c = getchar(); //it uses stdin
  int stack[8];
  int k=0;
  while ( k<8 && !(c== '\n' )){ //when its not new line and not out of bounce
    stack[k++]= c ; //we put the char in stack and then n+1
    c = getchar(); //if we dont write this getchar its gonna fill the whole stack (with 8 space) with the first char we got
    //so we need to write a new char everytime we are looping here
  }
  for( int i= 7; i>=0; i--){ //going through the stack from the end so that we can print them out in reverse
    putchar(stack[i]); //it uses stdout
  }

}
int main() { //in main we call our function
  iterative();
  printf("done \n");
  return 0;
}
// it is easier to implement and raed recursively
//but iterative is faster than recursive because of overhead like calling functions and registering stacks repeatedly .
// many times recursive is not efficient as it takes more time and space

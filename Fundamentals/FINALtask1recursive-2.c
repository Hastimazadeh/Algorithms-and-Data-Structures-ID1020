//Hasti Mohebali Zadeh
// 3 - September - 2020

// Implementing a recursive version of a function which reads characters from stdin until a newline character is read and then prints them on stdout in reverse order.

//Input: characters from stdin
//Output: Same characters to stdout but in reverse order

#include <stdio.h>

void recursive(){ //its recursive because it calls itself inside the function

  int c = getchar();
  if ( c == '\n') // if its newline it goes to return and then the next line of when it was called which is putchar
    return;
  else { //if its not newline
    //it reads recursive again and gets a new character
    //this "else" and the return at the end can be removed
    recursive();
    putchar(c);
    return;
  }

}
  int main() { //in main we call the function
    recursive();
    printf("done \n");
    return 0;
  } // it is easier to implement and raed recursively
  //but iterative is faster than recursive because of overhead like calling functions and registering stacks repeatedly .
  // many times recursive is not efficient as it takes more time and space

//Hasti Mohebali Zadeh
//21 september 2020
//Input: A text file
//Output: The same text file but every character other than alphabetic, blank or newline are replaced with blank

#include <stdio.h>
#include <ctype.h>

void main(){
  FILE *f;
  char* file = "C:\\Users\\hasti\\Desktop\\task1\\lab3test.txt";//the text file in canvas
  char c;
  f = fopen(file,"r"); //opening and reading that text file
  printf("Enter your text file : ");
  while((c = fgetc(f))!= EOF){ //while its not end of the file
    if(!isalpha(c) && c != ' ' && c != '\n' )
      putchar(' '); //replacing anything that is not alphabetic, blank or newline by blank
    else
      putchar(c);
    }
    fclose(f);//closing the file
}
/*
//for when we wanna input by keyboard
void main(){
  char c;
  while((c = getchar()) != EOF){ //getting a new character //while its not end of the file
    if(!isalpha(c) && c != ' ' && c != '\n')
      putchar(' ');  //replacing anything that is not alphabetic, blank or newline by blank
    else
      putchar(c);
  }
}
*/

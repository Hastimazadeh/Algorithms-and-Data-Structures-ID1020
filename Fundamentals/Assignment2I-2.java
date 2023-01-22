//Hasti Mohebali Zadeh
// 3 - September - 2020 

// implementing an iterative version of a function using ADT which reads characters from stdin until a newline character is read and then 
//prints them on stdout in reverse order.
//Input:chars from stdin
//Output: Same chars in reverse order to stdout
//This is basically the same as the previous code in C, where the only difference would be that I had to use the class InputStreamReader in order to be similar with getchar

package task2;
import java.io.*;

public class Assignment2I {
	 char[] stack = new char[10]; //making an array of chars 
     int n = 0;
    
    public Assignment2I() { //ADT the data type we made
    	this.stack = new char[10];
    }
	public void push(char c){  //puts the new char in stack[n] and then n++
		stack[n++] = c; 
	}
	public char pop() { 
		if(n == 0) //if n is 0 there is nothing to pop
		    return 0 ;
		char trash = stack[--n]; //if n is not zero we set the stack[n-1] to trash and then 
		stack[n]= 0; //and then we set it to 0 which means that place is empty
		return trash; 
	}
	   

	public  void iterative() throws IOException {
		InputStreamReader in = new InputStreamReader(System.in); //we only go through this one cause its not in while loop
		 
	     char c = (char) in.read();
			while ( n<10 && !(c== '\n' )) //when its not new line and not out of bounce
				//if n< 10 was not there when we write more than 10 inputs it gives error but now it just doesnt print out the extras 
	      {
			   push(c);
			   c = (char) in.read();//if we don't write this  its gonna fill the whole stack (with 10 space) with the first char we got
			    //so we need to write a new char everytime we are looping here
			}
			while(n > 0) //checking if its not empty for printing
	     {
			   System.out.print(pop()); //(it uses stdout)
	      }
	}
}

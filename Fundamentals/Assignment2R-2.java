//Hasti Mohebali Zadeh
// 3 - September - 2020 

// implementing an recursive version of a function using ADT which reads characters from stdin until a newline character is read and then 
//prints them on stdout in reverse order.
//Input:chars from stdin
//Output: Same chars in reverse order to stdout
//This is basically the same as the previous code in C, where the only difference would be that I had to use the class InputStreamReader in order to be similar with getchar

package task2;
import java.io.*;
public class Assignment2R {
	 char[] stack ;//making an array of 10 chars
     int n = 0;
     InputStreamReader in = new InputStreamReader(System.in); //for inputing chars
    
    public Assignment2R() { //ADT the data type we made
    	this.stack = new char[10];
    }
       
	public  void push(char c){ //func push that puts c in stack[n] and then n++
		stack[n++] = c; 
	}
	
	public  char pop() { //gets the value for stack[n-1] sets it to trash 
		char trash = stack[--n];
		stack[n]= 0; //and then puts that place to 0 or basically makes it empty 
		return trash; 
	}
	  
	public  void recursive() throws IOException {
		char c = (char) in.read(); //gets the new char
		
		
		if(c =='\n') { // if its newline it goes to return and then the next line of when it was called which is pop
			return;
		} //if its not newline
	    //it reads recursive again and gets a new character
		push(c);
		
		recursive();//its recursive because it calls itself inside the method
		System.out.print(pop());
		
		return;
	}
	//in java doesnt matter if main is at the end or not
	
}

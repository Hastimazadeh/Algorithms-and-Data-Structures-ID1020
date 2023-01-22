//Hasti Mohebali Zadeh
// 3 - September - 2020 

//another recursive code without pop and push
// implementing an recursive version of a function using ADT which reads characters from stdin until a newline character is read and then 
//prints them on stdout in reverse order.
//Input:chars from stdin
//Output: Same chars in reverse order to stdout
//This is basically the same as the previous code in C, where the only difference would be that I had to use the class InputStreamReader in order to be similar with getchar

package task2;
import java.io.InputStreamReader;
import java.io.IOException;

public class Assignment2RAlter {

	
	         static InputStreamReader in = new InputStreamReader(System.in); //for inputing chars

	            public static void recursive() throws IOException{
	                char c;
	                if((c = (char) in.read()) != '\n') //asking for an input
	                	//if its newline it goes to return and then the next line of when it was called
	                	recursive();  //its recursive because it calls itself inside the function
	                
	                System.out.print(c);
	                
	            }

}

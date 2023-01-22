//Hasti Mohebali Zadeh
// 6 - September - 2020 

//Implementing a program which takes as input a series of parentheses , that is a series of the characters: '(', ')', '[', ']', '{', '}'.
//The program checks if the parentheses are "balanced" or not by calling the balance method in main class.
//Input: Written from the test method (main) 
//Output: Prints out  if the parenthesis are balanced or not.

package taskExtra;

public class Assinment7 {

	public static void balance(char[] parentheses) { //a function that gets an array of characters
		//Initialising my counters
		int brackets = 0; //()
		int curly_brackets=0; //{}
		int square_brackets=0; //[]
		int sum =0;
		
		for (char c : parentheses) { //for each c in the array
		
			switch(c) { //looks for one of the cases
			
				case '(' :
					brackets++;
					break;
				case ')' :
					brackets--;
					break;
				case '{' :
					curly_brackets++;
					break;
				case '}' :
					curly_brackets--;
					break;
				case '[' :
					square_brackets++;
					break;
				case ']' :
					square_brackets--;
					break;
				}
			if(brackets < 0 || curly_brackets < 0 || square_brackets < 0) { //for the case thats its like ")(" 
				//or when it starts with  closing parentheses
				
				sum = 1000000; //because i know im never gonna have this many brackets 
				break;
			}
		}
	sum += brackets + curly_brackets + square_brackets; //we add sum+sum for the special if case 
	if ( sum == 0 ) 
		System.out.println("it is balanced");
	else 
		System.out.println("it is not balanced");
	
	
	}
	
	}

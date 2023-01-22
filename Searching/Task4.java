//Hasti Mohebali Zadeh
//24 September 2020

//a program that asks for word to show all the positions of that word in the text file and the number of appearances
//input : a text file and a word
//output :all the positions of that word in the text file and the number of appearances

package Task4;

import java.io.*;
import java.util.*;

public class Task4 {
	static List<Integer> wordFinder(String text, String word) {//the wrdFinder function that gets the text and the word we are looking for

		List<Integer> indices = new ArrayList<Integer>();// we create a new list to put the positions of the word
		String theWord = " " + word + " ";  //we put space around it so it doesn't find that word if its inside other words like the in them or they
		int i = 0;
		while (i != -1) {//i only gets -1 when it doesn't find the word anymore so the list is done

			//this is a function in java that looks for the word in the text after position i and after finding it it returns the position that the word is in 
			//and then it  gives i that position 
			//so that it starts looking for the word again after that i (when we do i++)
			i = text.indexOf(theWord, i);  
			if(i!=-1){
				indices.add(i);  //you add i to the list of positions
				i++; //start searching again after the position where we last found the word
			}
		}
		return indices;//the list of positions 
	}


	public static void main(String[] args) throws FileNotFoundException {

		File file = new File("C:\\Users\\hasti\\Desktop\\task1\\lab3test.txt");
		Scanner in = new Scanner(System.in); // to input the word we are looking for
		Scanner sc = new Scanner(file);//the text

		String text="";//our text file
		String line;
		while (sc.hasNext()) {
			line = sc.nextLine();//every new word from text
			//and then adding them one by one
			text = text + line + " "; //putting every word in the file in our text (line is every new word we get and text is the old ones)
		}

		String word;//the word we are looking for
		System.out.println("Enter the word you are looking for: ");

		word = in.next();

		List<Integer> list = wordFinder(text, word); //call the wordFinder to find the word in the text and it returns a list of all the positions 

		if (list.isEmpty()) System.out.println("No occurrences of the word " + "'" + word +"'");// for when the word doesn't exists in the text
		else {
			int col = 0;    //for print out the positions in 6 columns (can change)

			System.out.println("The word " +"' " + word +" '"+ " is found " + list.size() + " time(s) at the positin(s) : ");//list size is the number of appearances

			for (Integer index : list) {//going through the list of all the positions

				System.out.print(index + " "); //printing them out with a space after each position

				col++;

				if (6 == col) { //after writing 6 of them it goes to the next row
					System.out.println();

					col = 0;
				}
			}


		}
	}
}
//README
//Hasti Mohebali Zadeh
//2 October 2020

//we use this class for both Task 1 and 2

/*This Graph client allows clients to define graphs with String vertex names instead of integer indices.
It maintains instance variables st (a symbol table that maps names to indices), keys (an array that
maps indices to names), and G (a graph, with integer vertex names). To build these data structures,
it makes two passes through the graph definition (each line has a string and a list of adjacent strings,
separated by the delimiter sp).*/

package task1;//and task2

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SymbolGraph {

	//A symbol table st with String keys (vertex names) and int values (indices)
	private Lab3_BST<String, Integer> st; // String -> index
	//An array keys[] that serves as an inverted index, giving the vertex name associated with each integer index
	private String[] keys; // index -> String
	//A Graph graph built using the indices to refer to vertices
	private Graph graph; // the graph

	//Initialises a graph from file, using a specified delimiter. 
	//Each line in the file contains the name of the vertex
	//followed by a list of the names of the vertices adjacent to that vertex, separated by the delimiter.
	//file the file to get the vertices
	//delimiter the delimiter between fields.
	public SymbolGraph (File file, String delimiter) throws FileNotFoundException
	{
		//First pass builds the index by reading strings to associate each distinct string with an index.

		st = new Lab3_BST<String, Integer>();//create a new symbol table st
		Scanner in = new Scanner (file); 

		while (in.hasNextLine())  // as long as it has a new line
		{
			String[] a = in.nextLine().split(delimiter);  //takes the next line it splits it up in several strings so it doesn't take the whole line as one char
			for (int i = 0; i < a.length; i++) //i<2
				// if st doesn't contain that key already
				if (!st.contains(a[i])) 
					st.put(a[i], st.size());  // puts it in st with its size which is gonna be the associated index to that string
		}

		// Inverted index to get string keys in an array.
		//filling the keys array 
		keys = new String[st.size()]; //setting the size of the keys array to st.size
		for (String name : st.keys()) 
			keys[st.get(name)] = name; //we use get to the the associated index to that key


		// Second pass builds the graph  by connecting the first vertex on each line to all the others.
		graph = new Graph(st.size()); //public Graph_Task1(int V)  //setting the size of the graph  to st.size
		in = new Scanner(file); 

		while (in.hasNextLine())  // as long as it has a new line
		{
			String[] a = in.nextLine().split(delimiter); //takes the next line it splits it up in several strings so it doesn't take the whole line as one char
			int v = st.get(a[0]); 
			for (int i = 1; i < a.length; i++) 
			{
				int w = st.get(a[i]);
				graph.addEdge(v, w);  //public void addEdge(int v, int w)
			}
		}
	}

	//Does st contain the vertex name given in the source?
	//return true if it is in st otherwise false.
	public boolean contains(String s) {
		return st.contains(s);
	}
	//Returns the integer (value part of ST) of the given vertex name in parameter source.
	//return the integer (between 0 and V - 1) associated with the vertex given.
	public int index(String key) { 
		return st.get(key); 
	}
	//Returns the name of the given vertex number given in the parameter. 
	public String name(int v) {
		return keys[v];
	}

	//Returns the graph associated with the symbol graph.
	public Graph graph() { 
		return graph; 
	} 

}
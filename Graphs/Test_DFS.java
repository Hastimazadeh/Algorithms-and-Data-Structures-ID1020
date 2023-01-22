//README
//Hasti Mohebali Zadeh
//2 October 2020

//in this class we give the file address and also ask for two vertices to show the path between them if there is any

package task1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test_DFS {
	public static void main(String[] args) throws FileNotFoundException   {

		File file = new File("C:\\Users\\hasti\\Documents\\courses\\Algorithm\\labs\\textForlab4.txt");
		String delimiter = " ";

		SymbolGraph sg = new SymbolGraph(file, delimiter);
		Graph thisGraph = sg.graph();//normal graph based on symbol graph //to get the numbers for keys

		//System.out.println(sg.graph().toString(sg)); 
		System.out.println(thisGraph.toString(sg)); //prints each node and the edges for all nodes //.toString(sg)

		//ask user 	
		System.out.println("Find the path from : ");
		Scanner in = new Scanner(System.in); 
		String fromString = in.next();
		int fromInt = sg.index(fromString);

		System.out.println("To : ");
		String toString = in.next();
		int toInt = sg.index(toString);

		DepthFirstPaths dfs = new DepthFirstPaths(thisGraph, fromInt);//gets the fromInt as the source 

		System.out.println("\n" + "From " + fromString + " to " + toString + " : ");

		//check there is path or not
		if(dfs.hasPathTo(toInt)) 
		{
			System.out.println("yes there is a path between these two");
			for(Integer i : dfs.pathTo(toInt))
				//System.out.print(i+"  "); for printing their idices
				System.out.print(sg.name(i) + " "); //if there is a path prints the name
		}	
		else
			System.out.println("There is no path between these two");
	}
}

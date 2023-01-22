//README
//Hasti Mohebali Zadeh
//3 October 2020

//in this class we give the file address and also ask for two vertices to show the shortest path between them if there is any
//it is very similar to test-DFs class

package task1;//and task2

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test_BFS {
	public static void main(String[] args) throws FileNotFoundException   {

		File file = new File("C:\\Users\\hasti\\Documents\\courses\\Algorithm\\labs\\textForlab4.txt");
		String delimiter = " ";

		SymbolGraph sg = new SymbolGraph(file, delimiter);
		Graph thisGraph = sg.graph();//normal graph based on symbol graph
		System.out.println(thisGraph.toString(sg)); 

		//System.out.println(sg.graph().toString(sg)); //prints each node and the edges for all nodes //.toString(sg)

		//ask user 	
		System.out.println("Find the path from : ");
		Scanner in = new Scanner(System.in); 
		String fromString = in.next();
		int fromInt = sg.index(fromString);

		System.out.println("To : ");
		String toString = in.next();
		int toInt = sg.index(toString);

		BreadthFirstPaths bfs = new BreadthFirstPaths(sg.graph(), fromInt);//gets the fromInt as the source 

		System.out.println("\n" + "From " + fromString + " to " + toString + " : ");

		//check there is path or not
		if(bfs.hasPathTo(toInt)) 
		{
			System.out.println("yes there is a path between these two");
			for(Integer i : bfs.pathTo(toInt))
				System.out.print(sg.name(i) + " "); //if there is a path prints the name
		}	
		else
			System.out.println("There is no path between these two");
	}
}

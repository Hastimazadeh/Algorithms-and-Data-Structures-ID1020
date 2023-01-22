//README
//Hasti Mohebali Zadeh
//4 October 2020

//in this class we give the file address and also ask for two vertices to show the path between them if there is any

package task1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test_Task3 {
	public static void main(String[] args) throws FileNotFoundException   {

		File file = new File("C:\\Users\\hasti\\Documents\\courses\\Algorithm\\labs\\textForlab4.txt");
		String delimiter = " ";

		SymbolDigraph_Task3 sgd = new SymbolDigraph_Task3(file, delimiter);
		Digraph_Task3 thisGraph = sgd.diiigraph();//normal graph based on symbol graph
		System.out.println(thisGraph.toString(sgd)); 
		
		//System.out.println(sg.graph().toString(sg)); //prints each node and the edges for all nodes //.toString(sg)

		//ask user 	
		System.out.println("Find the path from : ");
		Scanner in = new Scanner(System.in); 
		String fromString = in.next();
		int fromInt = sgd.index(fromString);

		System.out.println("To : ");
		String toString = in.next();
		int toInt = sgd.index(toString);

		DirectedDFS_Task3 dfs = new DirectedDFS_Task3(sgd.diiigraph(), fromInt);//gets the fromInt as the source 
		DirectedDFS_Task3 dfsReverse = new DirectedDFS_Task3(sgd.diiigraph(), toInt);//gets the toInt as the source 
		

		System.out.println("\n" + "From " + fromString + " to " + toString + " : ");

		//check there is path or not
		if(dfs.hasPathTo(toInt)) 
		{
			System.out.println("Yes there is a directed path from ( " + fromString +" ) to ( " + toString + " ).");
			for(Integer i : dfs.pathTo(toInt))
				System.out.print(sgd.name(i) + " "); //if there is a path prints the name
		}	
		
		else if( dfsReverse.hasPathTo(fromInt)) 
		{
			System.out.println("There is no directed path from ( " + fromString +" ) to ( " + toString + " ).");
			System.out.println("But there is a path from ( " + toString +" ) to ( " + fromString + " ). So it is a path in reverse order.");
			for(Integer i : dfsReverse.pathTo(fromInt))
				System.out.print(sgd.name(i) + " "); //if there is a path prints the name
		}
		else {
			System.out.println("there is no path between ( " + fromString +" ) to ( " + toString + " ).");
		}
	}


}

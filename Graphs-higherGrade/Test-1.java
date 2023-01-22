//README
//Hasti Mohebali Zadeh
//7 October 2020

//final answer

//in this class we give the file address and also ask for three vertices to show the path between them if there is any

package hg;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import task1.Edge_HG;
import task1.ShortestPath_HG;

public class Test {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("C:\\Users\\hasti\\Documents\\courses\\Algorithm\\labs\\DamnIt.txt");
		// File path = new File("C:\\Users\\You Bastard!\\Desktop\\path.txt");
		Scanner input = new Scanner(System.in);
		EdgeWeightedGraph_HG ewd = new EdgeWeightedGraph_HG(file);

		System.out.println("from:");
		int a = input.nextInt();
		System.out.println("passing:");
		int b = input.nextInt();
		System.out.println("to:");
		int c = input.nextInt();
		//one Sp for a to b
		//the other one for b to c
		SP sp1 = new SP(ewd,a);
		SP sp2 = new SP(ewd,b);
		//if you want the total distance 
		double ab = sp1.distTo(b);
		double bc = sp2.distTo(c);
		double total_distance = ab + bc;

		//if sp1 one has path from a to b
		//and also if sp2 has a path from b to c
		//print both paths
		if(sp1.hasPathTo(b)) 
		{
			if(sp2.hasPathTo(c)) 
			{

				for(hg.Edge_HG i : sp1.pathTo(b))
					System.out.print(i + " "); //if there is a path prints the name



				for(hg.Edge_HG i : sp2.pathTo(c))
					System.out.print(i + " "); //if there is a path prints the name
				
				System.out.println();
				System.out.print("The total distance is : " + total_distance); 
			}
		}	
		else
			System.out.println("there is no path from ( " + a + " ) passing ( " + b + " ) to ( " + c + " )." );

	}

}

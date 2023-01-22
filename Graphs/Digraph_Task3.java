//README
//Hasti Mohebali Zadeh
//4 October 2020

//this Digraph class is used in task 3

//this class has number of vertices and edges and an array of bags in which it saves the adjacency relations.
//the difference between this class and the graph class is that if for example w is in v's adj list it doesn't mean that v is also in w's adj list because its directed

package task1;

//import java.util.Scanner;

public class Digraph_Task3 {

	private final int V; // number of vertices can't be updated
	private int E; // number of edges can be updated

	private Bag <Integer> [] adj; // adjacency lists using bag data type // an array called adj of bags type integer

	//Constructor 1
	public Digraph_Task3(int V) 
	{
		this.V = V; //set number of vertices to the integer given
		this.E = 0;//set edges to zero for now

		//Creating empty graph 
		adj = ( Bag <Integer> []) new Bag[V]; // create the array called adj of bags type integer with size v for the array

		//we go through the array and give each index a bag
		for (int v = 0; v < V; v++) // Initialise all lists for each vertex/index
			adj[v] = new Bag<Integer>(); //to empty.
	}
	//this is not being used here cause we have string not integers so we use symbol graph
	/*
	//Constructor 2. reads a graph , in the format V followed by E followed by a list of pairs of int values between 0 and V-1
	public Digraph_Task3(Scanner in)//scanner
	{
		//?
		this(in.nextInt()); // Read V and constructor1 with it
		int E = in.nextInt(); // Read E.
		for (int i = 0; i < E; i++)
		{ 
			// a list of pairs of values between 0 and v-1 and Add an edge.
			int v = in.nextInt(); // Read a vertex,
			int w = in.nextInt(); // read another vertex,
			addEdge(v, w); // and add edge connecting them.
		}
	}*/

	//gets V and gets E
	public int vertexCount() { 
		return V; 
	}
	public int edgeCount() { 
		return E; 
	}

	//To add an edge connecting v and w, we add w to v’s adjacency list 
	//and NOT v to w’s adjacency list. because its one way
	public void addEdge(int v, int w)
	{
		adj[v].add(w); // Add w to v’s list.
		E++;
	}

	//Allows to iterate through the vertices adjacent to a given vertex
	//iterate for vertices adjacent to v
	public Iterable<Integer> adj(int v)
	{ 
		return adj[v]; //returns a bag at index v in the array
	}
	
	
	//string representation of the graph’s adjacency lists (instance method in Graph)
	public String toString(SymbolDigraph_Task3 hello)

	{
		//printing number of vertices and edges
		String s = V + " vertices, " + E + " edges\n";

		for (int v = 0; v < V; v++)//for each vertex v
		{
			s += hello.name(v) + ": "; //Returns the name of the given vertex number given in the parameter + ":"


			for (int w : this.adj(v))//going through the adjacency list of each vertex for example v
			{
				s += hello.name(w) + " "; //printing all the name of the given vertex number given in the parameter  inside the bag for vertex v

			}
			s += "\n";// go to the next line after writing all the vertices adjacent to that v and then we go to the next v
		}
		return s;
	}


}

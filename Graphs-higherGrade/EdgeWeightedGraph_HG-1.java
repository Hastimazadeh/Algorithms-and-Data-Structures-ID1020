//README
//Hasti Mohebali Zadeh
//5 October 2020

//final answer

//Edge weighted Graph is still undirected but every edge has a weight (unique number - ex: distance)
//so it is very similar to the graph implementation in task1
//Graph class has number of vertices and edges and an array of bags in which it saves the adjacency relations.

package hg;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class EdgeWeightedGraph_HG {

	private final int V; // number of vertices can't be updated
	private int E; //  number of edges can be updated

	//instead of the adjacency lists of integers used in Graph, it uses adjacency lists of Edge objects.
	private Bag <Edge_HG>[] adj; // adjacency lists using bag data type // an array called adj of bags of object edge

	//Constructor 1
/*	public EdgeWeightedGraph_HG(int V)
	{
		this.V = V;
		this.E = 0;
		adj = (Bag<Edge_HG>[]) new Bag[V];// create the array called adj of bags type integer with size v for the array
		//we go through the array and give each index a bag
		for (int v = 0; v < V; v++)// Initialise all lists for each vertex/index
			adj[v] = new Bag<Edge_HG>();//to empty.
	}*/



	//Constructor 2
	//the first input is number of vertices
	//then the number edges
	//followed by the vertices edges and each edge's weight 
	public EdgeWeightedGraph_HG(File file) throws FileNotFoundException
	{
		Scanner in = new Scanner(file);
		V=in.nextInt();

		adj = (Bag<Edge_HG>[]) new Bag[V];// create the array called adj of bags type integer with size v for the array
		//we go through the array and give each index a bag
		for (int v = 0; v < V; v++)
			adj[v] = new Bag<Edge_HG>();

			int E = in.nextInt();
			for( int i = 0; i < E; i++){
				int v = in.nextInt();
				int w = in.nextInt();
				double weight = in.nextDouble();
				Edge_HG e = new Edge_HG(v,w,weight);
				this.addEdge(e);
			}
	}


	//gets V and gets E
	public int vertexCount() {
		return V;
	}
	public int edgeCount() { 
		return E;
	}


	//To add an edge connecting v and w, we add the edge to w and v’s adjacency lists (w and v are the vertices at both sides of that edge)
	public void addEdge(Edge_HG e)
	{
		int v = e.from(); //from returns v
		int w = e.to(); //to returns w

		adj[v].add(e);
		adj[w].add(e);
		//E++;
	}
	//Allows to iterate through the vertices adjacent to a given vertex instead of writing for
	//iterate for vertices adjacent to v
	//since its private up there this is how we access it
	public Iterable<Edge_HG> adj(int v)
	{ 
		return adj[v];//returns a bag at index v in the array
	}

	//The edges() method provides clients with the ability to iterate through to all the graph’s edges 
	//The edges() method puts all the edges in a Bag
	public Iterable<Edge_HG> edges()
	{
		Bag<Edge_HG> bag = new Bag<Edge_HG>();
		for (int v = 0; v < V; v++)
			for (Edge_HG e : adj[v])
				bag.add(e);
		return bag;
	}

}

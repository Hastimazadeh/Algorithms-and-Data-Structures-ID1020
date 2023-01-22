//README
//Hasti Mohebali Zadeh
//5 October 2020

//final answer

//An edge now is a class of its own and is used for creating the graph

package hg;

public class Edge_HG
{
	private final int v; // one vertex
	private final int w; // the other vertex
	private final double weight; // edge weight

	//each edge has two vertices and a weight
	//constructor
	//an edge has two vertices and a weight
	public Edge_HG(int v, int w, double weight)
	{
		this.v = v;
		this.w = w;
		this.weight = weight;
	}

	public double weight()
	{ 
		return weight;
	}

	//to get the vertices at the two sides of the edges
	public int from()
	{ 
		return v;
	}

	public int to()
	{ 
		return w; 
	}

	//to print out both vertices at the sides of edge and its weight 
	//for example 1->2 2008.0  
	
	public String toString() {
		StringBuilder sb =new StringBuilder();
		sb.append(v + "->" + w + " (" + weight + ") ");
		return String.valueOf(sb);
	}
}

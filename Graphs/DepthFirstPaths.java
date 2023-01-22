//README
//Hasti Mohebali Zadeh
//2 October 2020

//This implementation of depth-first search provides clients the ability to test which vertices are reachable from a given vertex . 
//This class basically means if two points in a graph are connected with a path

package task1;

public class DepthFirstPaths
{
	//It maintains an array of boolean values to mark all of the vertices that are connected to the source. 
	private boolean[] visited; 
	// edgeTo[v] = previous edge on shortest s-v path
	private int[] edgeTo; // last vertex on known path to this vertex //a vertex-indexed array edgeTo[]
	private final int s; // source


	//Computes the shortest path between the source vertex s and every other vertex in the graph G.
	public DepthFirstPaths(Graph G, int s) // initialises data structure
	{
		//setting the size of these two arrays to the number of vertices
		visited = new boolean[G.vertexCount()];//an array of true or false for every vertex in the graph
		edgeTo = new int[G.vertexCount()];
		this.s = s;
		dfs(G, s);  //find vertices connected to s
	}

	//This method is called depth-first search (DFS). 
	//To search a graph, invoke a recursive method that visits vertices. To visit a vertex:
	private void dfs(Graph G, int v) 
	{
		visited[v] = true;//A )Mark it as having been visited.

		// *(it only has time to do this for the first not visited vertex adjacent to v cause afterwards it calls dfs for that one)*

		for (int w : G.adj(v))//B) Visit (recursively) all the vertices that are adjacent to it
			if (!visited[w])//B) and that have not yet been marked
			{
				edgeTo[w] = v;//D) that edgeTo[w] = v means that v-w was the edge used to access w for the first time.

				//now do all of this again for w
				dfs(G, w); //recursive dfs does the work
			}
	}

	//Is there a path between the SOURCE vertex and vertex ?
	public boolean hasPathTo(int v)
	{ 
		return visited[v]; 
	}

	//Returns a  path between the source vertex  (or sources) and v, or  null if no such path.
	public Iterable<Integer> pathTo(int v)
	{
		if (!hasPathTo(v)) 
			return null;

		Stack<Integer> path = new Stack<Integer>();//creates a stack vertices that will contain the vertices along the path

		for (int x = v; x != s; x = edgeTo[x])//going back and back to get to the source
			path.push(x);//pushing all the vertices from the last to the source
		path.push(s);//and then pushing the source 

		return path;
	}
}

//README
//Hasti Mohebali Zadeh
//3 October 2020

//This class basically finds if two points in a graph are connected with the shortest path

package task1;

public class BreadthFirstPaths
{
	//It maintains an array of boolean values that if that vertex been visited or not
	private boolean[] visited; // Is a shortest path to this vertex known?
	private int[] edgeTo; // last vertex on known path to this vertex
	private final int s; // source
	
	public BreadthFirstPaths(Graph G, int s)
	{
		visited = new boolean[G.vertexCount()];
		edgeTo = new int[G.vertexCount()];
		this.s = s;
		bfs(G, s);
	}
	//we use queue here to put in our vertices
	private void bfs(Graph G, int s)
	{
		Queue_BFS<Integer> queue = new Queue_BFS<Integer>();
		
		visited[s] = true; // Mark the source
		
		queue.enqueue(s); // and put it on the queue.
		
		while (!queue.isEmpty())//while the queue is not empty
		{
			int v = queue.dequeue(); //Remove (the top) next vertex from the queue//after line 42 we come back here and take the first thing in the queue
			
			//it does this for all the vertices adjacent to v cause as oppose to dfs its doesn't call bfs again
			
			for (int w : G.adj(v)) //all the vertices that are adjacent to it
				if (!visited[w]) // if they are not already visited
				{
					edgeTo[w] = v; // save last edge on a shortest path,
					visited[w] = true; // mark it because path is known,
					queue.enqueue(w); // and add it to the queue. then we take v as the first thing that was added here to remove at line 25
				}
		}
	}
	
	//Is there a path between the SOURCE vertex (or sources) and vertex ?
	public boolean hasPathTo(int v)
	{ 
		return visited[v]; 
		}
	//it is the same as the one in dfs
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
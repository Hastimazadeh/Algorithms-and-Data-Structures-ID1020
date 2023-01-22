//README
//Hasti Mohebali Zadeh
//6 October 2020

//final answer

//this is a way to find the shortest path using their distances
//it is using bellman ford short path
//this algorithm uses a version of relax() that puts vertices pointed to by edges that successfully relax on a FIFO queue
package hg;

public class SP {

	private double[] distTo; // length of path to v// distTo[v] = distance  of shortest s->v path
	private Edge_HG[] edgeTo; // last edge on path to v // edgeTo[v] = last edge on shortest s->v path
	private boolean[] onQ; // Is this vertex on the queue?
	private Queue<Integer> queue; // vertices being relaxed

	// Computes a shortest-paths tree from the source vertex to every other vertex in the edge-weighted graph.
	public SP(EdgeWeightedGraph_HG G, int s)
	{
		//setting their sizes
		distTo = new double[G.vertexCount()];
		edgeTo = new Edge_HG[G.vertexCount()];
		onQ = new boolean[G.vertexCount()];

		queue = new Queue<Integer>();
		//giving all the vertices distance infinity from source 
		for (int v = 0; v < G.vertexCount(); v++)
			distTo[v] = Double.POSITIVE_INFINITY;
		//giving the source distance 0 from itself
		distTo[s] = 0.0;
		//put the source in queue
		queue.enqueue(s);
		//we set s as true in the queue because it is in the queue
		onQ[s] = true;
		while (!queue.isEmpty())
		{
			//we take the first thing out of the queue
			int v = queue.dequeue();
			//we set it to false cause its not on the cause anymore and so it hasn't been relaxed
			onQ[v] = false;
			relax(G,v);
		}
	}



	private void relax(EdgeWeightedGraph_HG G, int v)
	{
		//we do this for all the edges for v
		for (Edge_HG e : G.adj(v))
		{
			int w = e.to(); //to() returns w
			//if distance of s to w (it can be either infinity or some already updated distance) is more than v's already distance + the edge's weight ( the edge that connects v and w )
			//so basically distTo[v] + e.weight() is gonna be the new way to reach w if its short enough
			if (distTo[w] > distTo[v] + e.weight())
			{
				//updating the distance to the shorter one
				distTo[w] = distTo[v] + e.weight();
				//and we change the edgeTo to where it is the closest to it
				//meaning that the shortest way so far to reach w is edge e
				edgeTo[w] = e;
				//if w was not on the queue then put it there and mark it as it being there
				if (!onQ[w])
				{
					queue.enqueue(w);
					onQ[w] = true; // means that it has been relaxed
				}
			}
		}
	}

	//to get the distance value
	public double distTo(int v) {
		return distTo[v];
	}

	//any distance that is less than infinity means that there is a path
	//if its still infinity means that we couldn't reach that vertex to update its distance
	public boolean hasPathTo(int v) {
		return distTo[v] < Double.POSITIVE_INFINITY;
	}

	//Returns a shortest path between the source vertex  and vertex v.
	//This iterator is going to iterate through all the edges used for the shortest path;
	public Stack<Edge_HG> pathTo(int v)
	{
		if (!hasPathTo(v)) return null;
		Stack<Edge_HG> path = new Stack<Edge_HG>();
		for (Edge_HG e = edgeTo[v]; e != null; e = edgeTo[e.from()])
			path.push(e);
		return path;
	}



}











//the time complexity is O ( EV )

package bobo.graph.minSpanTrees;

import java.util.Iterator;

public interface WeightedGraph<Weight> {
	
	public int V();
	public int E();
	
	public void addEdge(Edge e);
	public boolean hasEdge(int v ,int w);
	public void show();
	public Iterable<Edge> adj(int v);
}

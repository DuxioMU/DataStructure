package bobo.graph.novel;

import java.util.ArrayList;
import java.util.Vector;

//³íÃÜÍ¼-ÁÚ½Ó¾ØÕó
@SuppressWarnings("rawtypes")
public class DenseGraph {
	
	private int n,m;
	private boolean directed;
	private	boolean[][] g;
	
	public DenseGraph(int n ,boolean directed) {
		this.n = n;
		this.m = 0;
		this.directed = directed;
		g = new boolean[n][n];
	}
	
	public int V() {
		return n;
	}
	public int E() {
		return m;
	}
	
	void addEdge(int v ,int w) {
		
	}
	
}

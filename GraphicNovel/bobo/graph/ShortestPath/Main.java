package bobo.graph.ShortestPath;

import org.junit.Test;

public class Main {
	
	@Test //测试我们的Bellman-Ford最短路径算法
	public void main2() {
		String filename = "Bellman/testG1.txt";
        //String filename = "testG_negative_circle.txt";
        int V = 5;

        SparseWeightedGraph<Integer> g = new SparseWeightedGraph<Integer>(V, true);
        ReadWeightedGraph readGraph = new ReadWeightedGraph(g, filename);

        System.out.println("Test Bellman-Ford:\n");
        BellmanFord<Integer> bellmanFord = new BellmanFord<Integer>(g,0);
        if( bellmanFord.negativeCycle() )
            System.out.println("The graph contain negative cycle!");
        else
            for( int i = 1 ; i < V ; i ++ ){
                if(bellmanFord.hasPathTo(i)) {
                    System.out.println("Shortest Path to " + i + " : " + bellmanFord.shortestPathTo(i));
                    bellmanFord.showPath(i);
                }
                else
                    System.out.println("No Path to " + i );

            System.out.println("----------");
        }
	}
	
	     
	@Test//测试Dijkstra最短路径算法
	 public void  main() {
		

        String filename = "Primtest/testG1.txt";
        int V = 8;

        SparseWeightedGraph<Integer> g = new SparseWeightedGraph<Integer>(V, true);
        // Dijkstra最短路径算法同样适用于有向图
        //SparseGraph<int> g = SparseGraph<int>(V, false);
        ReadWeightedGraph readGraph = new ReadWeightedGraph(g, filename);

        System.out.println("Test Dijkstra:\n");
        Dijkstra<Integer> dij = new Dijkstra<Integer>(g,0);
        for( int i = 1 ; i < V ; i ++ ){
            if(dij.hasPathTo(i)) {
                System.out.println("Shortest Path to " + i + " : " + dij.shortestPathTo(i));
                dij.showPath(i);
            }
            else
                System.out.println("No Path to " + i );

            System.out.println("----------");
        }
	}
}

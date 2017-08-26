package bobo.graph.baisc;

import java.util.Iterator;
import java.util.concurrent.SynchronousQueue;

import org.junit.Test;

public class Main {
	
	String filename1 = "testG1.txt";
	String filename2 = "testG2.txt";
	
	@Test //随机生成图
	public void main6() {
		int V = 19;
		int E = 30;
		Graph graph = new SparseGraph(V,false);
		RandomGraph randomGraph = new RandomGraph(graph,V,E);
		graph.show();
		
	}
	
	@Test //测试无权图最短路径算法
	public void main5() {
		
		String filename = "testG.txt";
		SparseGraph g = new SparseGraph(7 ,false);
		ReadGraph readGraph = new ReadGraph(g,filename);
		g.show();
		System.out.println();
		
		//比较实用深度有优先遍历和广度优先遍历获得的路径的不同
		//广度优先遍历获得的是无权图的最短路径
		Path dfs = new Path(g,0);
		System.out.print("DFS: ");
		dfs.showPath(6);;
		
		ShortestPath bfs = new ShortestPath(g,0);
		System.out.print("BFS:");
		bfs.showPath(6);
		System.out.println(bfs.length(6));
	}
	
	@Test //4、打印从点原始点0 到指定点 6 的路径
	public void main4() {
		SparseGraph g = new  SparseGraph(13 ,false);
		ReadGraph readGraph = new ReadGraph(g ,filename1);
		g.show();
		System.out.println();
		
		Path dfs = new Path(g,0);
		System.out.print("DFS:");
		dfs.showPath(6);
	}
	
	
	@Test //测试图的连通分量算法
	public void main3() {
		
		
		SparseGraph g1 = new SparseGraph(13,false);
		ReadGraph readGraph1 = new ReadGraph(g1 ,filename1);
		Component component1 = new Component(g1);
		System.out.println("TestG1.txt,Component Count:"+ component1.count());
		System.out.println();
		
		
        SparseGraph g2 = new SparseGraph(6, false);
        ReadGraph readGraph2 = new ReadGraph(g2, filename2);
        Component component2 = new Component(g2);
        System.out.println("TestG2.txt, Component Count: " + component2.count());
	}
	
	
	@Test //2.读取图存储文件
	public void main2(){
		//使用两种图的存储方式读取testG1.text文件
		String filename = "testG1.txt";
		SparseGraph g1 = new SparseGraph(13,false);
		ReadGraph readGraph1 = new ReadGraph(g1,filename);
		System.out.println("test G1 in Sparse Graph");
		g1.show();
		System.out.println();
		
	 	DenseGraph g2 = new DenseGraph(13, false);
        ReadGraph readGraph2 = new ReadGraph(g2 , filename );
        System.out.println("test G1 in Dense Graph:");
        g2.show();
        System.out.println();
        
        
        // 使用两种图的存储方式读取testG2.txt文件
        filename = "testG2.txt";
        SparseGraph g3 = new SparseGraph(6, false);
        ReadGraph readGraph3 = new ReadGraph(g3, filename);
        System.out.println("test G2 in Sparse Graph:");
        g3.show();

        System.out.println();

        DenseGraph g4 = new DenseGraph(6, false);
        ReadGraph readGraph4 = new ReadGraph(g4, filename);
        System.out.println("test G2 in Dense Graph:");
        g4.show();
		
	}
	
	@Test //创建随机图
	public void main1() {
		
		int N = 20;  //节点数
		int M = 100; //边数
		
		SparseGraph g1 = new SparseGraph(N , false);
	//	DenseGraph g1 = new DenseGraph(N , false);
		
		for( int i = 0 ; i < M ; i ++ ){
			int a = (int)(Math.random()*N);
			int b = (int)(Math.random()*N);
			g1.addEdge(a, b);
		}
		
		for( int v = 0 ; v < N ; v ++){
			System.out.print(v+ ":");
			Iterator<Integer> adj = g1.adj(v).iterator();
			while(adj.hasNext())
				System.out.print(adj.next()+" ");
			System.out.println();
		}
	}
}

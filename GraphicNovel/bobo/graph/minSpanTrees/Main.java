package bobo.graph.minSpanTrees;

import java.util.Vector;

import org.junit.Test;

public class Main {
	
	
	@Test //测Prim算法  
	public  void main2() {
		String filename = "testG4.txt";
		int v = 8;
		
		SparseWeightedGraph<Double> g = new SparseWeightedGraph<Double>(v,false);
		ReadWeightedGraph  readGraph = new ReadWeightedGraph(g , filename);
		
		//Test Lazy Prim MST
		System.out.println("Test Lazy Prim MST");
		LazyPrimMST<Double> lazyPrimMST = new LazyPrimMST<Double>(g	);
		Vector<Edge<Double>> mst = lazyPrimMST.mstEdge();
		for(int i = 0;i<mst.size(); i++)
			System.out.println(mst.elementAt(i));
		System.out.println("The MST weight is :" +lazyPrimMST.result());
		
		System.out.println();
		
		
	}
	@Test
	public void main1() {
		   // 使用两种图的存储方式读取testG1.txt文件
        String filename = "testG3.txt";
        SparseWeightedGraph<Double> g1 = new SparseWeightedGraph<Double>(8, false);
        ReadWeightedGraph readGraph1 = new ReadWeightedGraph(g1, filename);
        System.out.println("test G1 in Sparse Weighted Graph:");
        g1.show();

        System.out.println();

        DenseWeightedGraph<Double> g2 = new DenseWeightedGraph<Double>(8, false);
        ReadWeightedGraph readGraph2 = new ReadWeightedGraph(g2 , filename );
        System.out.println("test G1 in Dense Graph:");
        g2.show();

        System.out.println();
	}
}
